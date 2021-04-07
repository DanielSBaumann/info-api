package com.github.danielsbaumann.info.restcontroller;

import com.github.danielsbaumann.info.entity.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/info/covid")
public class CovidController {

    @GetMapping
    public Country country() {
        try {

            Instant yesterday = Instant
                    .now()
                    .minus(1, ChronoUnit.DAYS);

            String URL = "https://api.covid19api.com/live/country/BR/status/confirmed/date/" + yesterday;

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Object[]> responseEntity =
                    restTemplate
                            .getForEntity(URL, Object[].class);

            List<Object> objects = Arrays
                    .asList(responseEntity.getBody());

            return new Country()
                    .br(objects);
        } catch (HttpClientErrorException e) {
            return null;
        }

    }
}
