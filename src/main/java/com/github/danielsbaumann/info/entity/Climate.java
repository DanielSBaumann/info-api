package com.github.danielsbaumann.info.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Climate {

    private String country;
    private String state;
    private String city;
    private String condition;
    private Integer temperature;
    private Integer sensation;

    public Climate climate(String data) {
        return Climate
                .builder()
                .country(country(data))
                .state(state(data))
                .city(city(data))
                .condition(condition(data))
                .temperature(temperature(data))
                .sensation(sensation(data))
                .build();
    }

    public String country(String data) {
        Pattern pattern = Pattern.compile("country\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "ERRO";
        }
    }

    public String state(String data) {
        Pattern pattern = Pattern.compile("state\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "ERRO";
        }
    }

    public String city(String data) {
        Pattern pattern = Pattern.compile("name\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "ERRO";
        }
    }

    public String condition(String data) {
        Pattern pattern = Pattern.compile("condition\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "ERRO";
        }
    }

    public Integer temperature(String data) {
        Pattern pattern = Pattern.compile("temperature\":(.*?),");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return new Integer(matcher.group(1));
        } else {
            return 0;
        }
    }

    public Integer sensation(String data) {
        Pattern pattern = Pattern.compile("sensation\":(.*?),");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return new Integer(matcher.group(1));
        } else {
            return 0;
        }
    }
}
