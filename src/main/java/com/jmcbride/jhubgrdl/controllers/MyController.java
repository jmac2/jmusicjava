package com.jmcbride.jhubgrdl.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.jmcbride.jhubgrdl.model.SongTitles;
import com.jmcbride.jhubgrdl.service.SongTitlesService;
import com.jmcbride.jhubgrdl.speechproccesor.SpeechProcessor;
import com.jmcbride.jhubgrdl.tunehandler.PropertiesHandler;
import com.jmcbride.jhubgrdl.tunehandler.TuneHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@RestController
public class MyController {

        @Autowired
        SongTitlesService songTitlesService;

        @Autowired
        PropertiesHandler propertiesHandler;

        @Autowired
        TuneHandler tuneHandler;

        @Value("${pitchmatcher.islocal}")
        String isLocal = "false";


        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @GetMapping("/greeting")
        public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
                List<SongTitles> songs =  songTitlesService.getAllSongtitless();
            return new Greeting(counter.incrementAndGet(), String.format(template, songs.get(0).getSongtitle()));
        }





        @GetMapping("/api/general/getSpeechData")
        @Produces("text/plain")
        public String getSpeechData(@QueryParam("action") String action, @QueryParam("request") String request,
                                    @QueryParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {
                System.out.println("about to get speech data");
                SpeechProcessor speechProcessor = new SpeechProcessor();
                String ret = speechProcessor.getSpeechData("");

                return ret;
        }


        @PostMapping("/api/general/putSpeechData")
        @Produces("text/plain")
        public String putSpeechData(@QueryParam("action") String action, @FormParam("request") String request,
                                    @FormParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {

                System.out.println("about to write speech data");
                System.out.println("The payload is: " + payload);
                SpeechProcessor speechProcessor = new SpeechProcessor();
                speechProcessor.postSpeechData(payload);
                String ret = "";

                return ret;
        }



        @PostMapping("/api/general/clearSpeechData")
        @Produces("text/plain")
        public String clearSpeechData(@QueryParam("action") String action, @FormParam("request") String request,
                                      @FormParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {


                SpeechProcessor speechProcessor = new SpeechProcessor();
                speechProcessor.clearSpeechDataByName(payload);
                String ret = "";

                return ret;
        }





        @GetMapping("/api/general/getTune")
        @Produces("text/plain")
        public String getTune(@QueryParam("action") String action, @QueryParam("request") String request,
                              @QueryParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {
                System.out.println("return tune");
                System.out.println(payload);
                String ret = tuneHandler.getTune(payload);
                return ret;

        }


        @PostMapping("/api/general/writeTune")
        @Produces("text/plain")
        public String writeTuneData(@QueryParam("action") String action, @FormParam("request") String request,
                                    @FormParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {

                String ret="";

                TuneHandler tuneHandler =new TuneHandler();
                tuneHandler.saveTune("newtune", payload);


                return ret;
        }



        @PostMapping("/api/general/writeNotesAndLyrics")
        @Produces("text/plain")
        public String writeNotesAndLyrics(@QueryParam("action") String action, @FormParam("request") String request,
                                          @FormParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {

                String ret="";

                TuneHandler tuneHandler =new TuneHandler();
                tuneHandler.saveNotesAndLyrics(payload);


                return ret;
        }




        @GetMapping("/api/general/getProperties")
        @Produces("text/plain")
        public String getProperties(@QueryParam("action") String action, @QueryParam("request") String request,
                                    @QueryParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {
                System.out.println("return tune");
                System.out.println(payload);

                String ret = propertiesHandler.getProperties();
                return ret;


        }


        @PostMapping("/api/general/writeProperties")
        @Produces("text/plain")
        public String writeProperties(@QueryParam("action") String action, @FormParam("request") String request,
                                      @FormParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {

                String ret="";


                propertiesHandler.writeProperties(payload);


                return ret;
        }


        @GetMapping("/api/general/deleteSheetWatcher")
        @Produces("text/plain")
        public String deleteSheetWatcher(@QueryParam("action") String action, @QueryParam("request") String request,
                                         @QueryParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {
                String ret="";
              //  DeleteWatcher deleteWatcher = new DeleteWatcher();
              //  deleteWatcher.deleteSheetWatcher();


                return ret;
        }


//"http://localhost:8080/Atest/api/general/checkiflocal?action=action&request=request&payload="
        @GetMapping("/api/general/checkiflocal")
        @Produces("text/plain")
        public String checkIfLocal(@QueryParam("action") String action, @QueryParam("request") String request,
                                   @QueryParam("payload") String payload, @HeaderParam("User-Agent") String whichBrowser) {
                ;
                String ret = isLocal; //  new Boolean(isLocal).toString();
                return ret;


        }

}
