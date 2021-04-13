package com.github.danielsbaumann.info;

import com.github.danielsbaumann.info.entity.Country;
import com.github.danielsbaumann.info.entity.Crypto;
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

import static java.util.Arrays.asList;

@SpringBootApplication
public class InfoApplication {

    @Bean
    public CommandLineRunner init() {
        return args -> {

//            try {
//
//                /*
//                {"ripple":{"usd":1.7,"brl":9.77},"litecoin":{"usd":266.88,"brl":1530.22},"bitcoin":{"usd":62782,"brl":359972},"bitcoin-cash":{"usd":718.55,"brl":4119.98},"ethereum":{"usd":2245.64,"brl":12875.8}}
//                    bitcoin
//                    ethereum
//                    bitcoin cash
//                    litecoin
//                    ripple
//                 */
//
//                String resp = "{\"ripple\":{\"usd\":1.7,\"brl\":9.77},\"litecoin\":{\"usd\":266.88,\"brl\":1530.22},\"bitcoin\":{\"usd\":62782,\"brl\":359972},\"bitcoin-cash\":{\"usd\":718.55,\"brl\":4119.98},\"ethereum\":{\"usd\":2245.64,\"brl\":12875.8}}";
//                List<String> cr = asList(resp.substring(1, resp.length() - 2).split("},"));
//
//                List<Crypto> list = new Crypto().list(cr);
//                list.forEach(System.out::println);
//                cr.forEach(System.out::println);

//                String URL = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,litecoin,ripple,bitcoin-cash&vs_currencies=usd,brl";
//
//                RestTemplate restTemplate = new RestTemplate();

//                Crypto cripto = restTemplate
//                        .getForObject(URL, Crypto.class);
//
//                System.out.println(cripto.toString());

//                String cripto = restTemplate
//                        .getForObject(URL, String.class);
//
//                System.out.println(cripto);

//                Crypto bitcoin = new Crypto().bitcoin(cripto);
//
//                System.out.println(bitcoin.toString());

//                ResponseEntity<Object[]> responseEntity =
//                        restTemplate.getForEntity(URL, Object[].class);
//
//                Object[] objects = responseEntity.getBody();
//
//                List<Object> list = asList(objects);
//
//                list.forEach(System.out::println);

//            } catch (HttpClientErrorException e) {
//                e.printStackTrace();
//            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(InfoApplication.class, args);
    }

}
