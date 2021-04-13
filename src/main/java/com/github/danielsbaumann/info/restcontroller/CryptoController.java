package com.github.danielsbaumann.info.restcontroller;

import com.github.danielsbaumann.info.entity.Crypto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/api/info/crypto")
public class CryptoController {

    private final String URL = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,litecoin,ripple,bitcoin-cash&vs_currencies=usd,brl";

    @GetMapping
    public List<Crypto> crypto() {
        try {

            RestTemplate restTemplate = new RestTemplate();

            String resp = restTemplate
                    .getForObject(URL, String.class);

            List<String> cr = asList(resp
                    .substring(1, resp.length() - 2)
                    .split("},"));

            return new Crypto()
                    .list(cr);

        } catch (HttpClientErrorException e) {
            return null;
        }
    }

}
