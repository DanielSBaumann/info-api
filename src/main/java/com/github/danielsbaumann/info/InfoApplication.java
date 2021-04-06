package com.github.danielsbaumann.info;

import com.github.danielsbaumann.info.entity.Climate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class InfoApplication {

    @Bean
    public CommandLineRunner init() {
        return args -> {

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(InfoApplication.class, args);
    }

}
