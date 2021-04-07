package com.github.danielsbaumann.info;

import com.github.danielsbaumann.info.entity.Country;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InfoApplication {

    @Bean
    public CommandLineRunner init() {
        return args -> {

//            try {
//
//                Instant yesterday = Instant
//                        .now()
//                        .minus(1, ChronoUnit.DAYS);
//                System.out.println(yesterday);
//                String URL = "https://api.covid19api.com/live/country/BR/status/confirmed/date/" + yesterday;
//
//                RestTemplate restTemplate = new RestTemplate();
//
//                ResponseEntity<Object[]> responseEntity =
//                        restTemplate.getForEntity(URL, Object[].class);
//
//                Object[] objects = responseEntity.getBody();
//
//                List<Object> list = Arrays.asList(objects);
//
//                Integer confirmed = new Country().confirmed(list);
//                System.out.println("teste confirmed");
//                System.out.println(confirmed);
//
//            } catch (HttpClientErrorException e) {
//                e.printStackTrace();
//            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(InfoApplication.class, args);
    }

}
