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
public class Province {

    private String country;
    private String province;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;

    public List<Province> list(List<Object> objects) {
        List<Province> list = new ArrayList<Province>();
        objects.forEach(obj -> {
            list
                    .add(new Province()
                            .toProvince(obj.toString()));
        });
        return list;
    }

    public Province toProvince(String tag) {
        return Province
                .builder()
                .country(country(tag))
                .province(province(tag))
                .confirmed(confirmed(tag))
                .deaths(deaths(tag))
                .recovered(recovered(tag))
                .build();
    }

    public String country(String tag) {
        Pattern pattern = Pattern.compile("Country=(.*?),");
        Matcher matcher = pattern.matcher(tag);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "ERRO";
        }
    }

    public String province(String tag) {
        Pattern pattern = Pattern.compile("Province=(.*?),");
        Matcher matcher = pattern.matcher(tag);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "ERRO";
        }
    }

    public Integer confirmed(String tag) {
        Pattern pattern = Pattern.compile("Confirmed=(.*?),");
        Matcher matcher = pattern.matcher(tag);
        if (matcher.find()) {
            return new Integer(matcher.group(1));
        } else {
            return 0;
        }
    }

    public Integer deaths(String tag) {
        Pattern pattern = Pattern.compile("Deaths=(.*?),");
        Matcher matcher = pattern.matcher(tag);
        if (matcher.find()) {
            return new Integer(matcher.group(1));
        } else {
            return 0;
        }
    }

    public Integer recovered(String tag) {
        Pattern pattern = Pattern.compile("Recovered=(.*?),");
        Matcher matcher = pattern.matcher(tag);
        if (matcher.find()) {
            return new Integer(matcher.group(1));
        } else {
            return 0;
        }
    }
}
