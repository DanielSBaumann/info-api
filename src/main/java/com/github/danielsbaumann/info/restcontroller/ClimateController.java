package com.github.danielsbaumann.info.restcontroller;

import com.github.danielsbaumann.info.entity.Climate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/info/climate")
public class ClimateController {

    @GetMapping
    public Climate climate() {
        try {
            String URL = "http://apiadvisor.climatempo.com.br/api/v1/weather/locale/5959/current?token=ba05d4d244bc50d3c7f9df825f1c989d";
            RestTemplate restTemplate = new RestTemplate();
            String data = restTemplate
                    .getForObject(URL, String.class);
            return new Climate()
                    .climate(data);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return null;
        }
    }

}
