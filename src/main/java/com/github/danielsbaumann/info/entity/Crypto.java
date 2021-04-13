package com.github.danielsbaumann.info.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Crypto {

    private String name;
    private Double usd;
    private Double brl;

    public List<Crypto> list(List<String> cr) {

        List<Crypto> list = new ArrayList<Crypto>();

        cr.forEach(line -> {
            Crypto crypto = new Crypto()
                    .cryptoByLine(line);
            list.add(crypto);
        });

        return list;
    }

    public Crypto cryptoByLine(String line) {
        String op = line
                .substring(0, line.indexOf(":"))
                .replace("\"", "");
        switch (op) {
            case "ripple": {
                return ripple(line);
            }
            case "litecoin": {
                return litecoin(line);
            }
            case "bitcoin": {
                return bitcoin(line);
            }
            case "bitcoin-cash": {
                return bitcoinCash(line);
            }
            case "ethereum": {
                return ethereum(line);
            }
            default:
                return null;
        }
    }

    public Crypto bitcoin(String json) {
        return Crypto
                .builder()
                .name("bitcoin")
                .usd(usd(json))
                .brl(brl(json))
                .build();
    }

    public Crypto ethereum(String json) {
        return Crypto
                .builder()
                .name("ethereum")
                .usd(usd(json))
                .brl(brl(json))
                .build();
    }

    public Crypto bitcoinCash(String json) {
        return Crypto
                .builder()
                .name("bitcoin-cash")
                .usd(usd(json))
                .brl(brl(json))
                .build();
    }

    public Crypto litecoin(String json) {
        return Crypto
                .builder()
                .name("litecoin")
                .usd(usd(json))
                .brl(brl(json))
                .build();
    }

    public Crypto ripple(String json) {
        return Crypto
                .builder()
                .name("ripple")
                .usd(usd(json))
                .brl(brl(json))
                .build();
    }

    public Double usd(String json) {
        Pattern pattern = Pattern.compile("usd\":(.*?),");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return new Double(matcher.group(1));
        } else {
            return 0d;
        }
    }

    public Double brl(String json) {
        return new Double(json
                .substring(json
                        .lastIndexOf(":") + 1));
    }
}
