package com.beyondbanking.ssh.controllers;

import com.beyondbanking.ssh.specific.Suggestions;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

/**
 * Created by Rucha on 06/06/2018.
 * service to provide suggestions of nearby attractions
 */
@RestController @RequestMapping(path = "/v1/suggestions") public class LocationController {

    private static final String API_KEY = "AIzaSyCt5XBp-skzorOCLINhWsdHJADdRx27Ctk";

    private static Logger logger = Logger.getLogger("LocationController");

    /**
     * this method calls Google's nearbysearch API with user given criterias
     *
     * @param location location longitude, latitude
     * @param type     to search
     * @param maxprice attraction average maximum cost
     * @return Suggestions
     */
    @RequestMapping(value = "/nearbysearch", method = RequestMethod.GET) @Produces(MediaType.APPLICATION_JSON)
    @ResponseBody @CrossOrigin public HttpEntity<Suggestions> nearbySearch(
        @RequestParam(value = "location", required = false, defaultValue = "52.312662,4.948121") String location,
        @RequestParam(value = "type", required = false, defaultValue = "restaurant") String type,
        @RequestParam(value = "maxprice", required = false, defaultValue = "3") String maxprice) {

        String googleApi = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
        UriComponentsBuilder builder =
            UriComponentsBuilder.fromHttpUrl(googleApi).queryParam("key", API_KEY).queryParam("location", location)
                .queryParam("radius", 3500).queryParam("maxprice", maxprice).queryParam("type", type);
        logger.info(builder.build().encode().toString());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity exchange =
            restTemplate.exchange(builder.build().encode().toString(), HttpMethod.GET, null, Suggestions.class);
        Suggestions locationSuggestions = (Suggestions) exchange.getBody();
        return new ResponseEntity<>(locationSuggestions, HttpStatus.OK);
    }
}
