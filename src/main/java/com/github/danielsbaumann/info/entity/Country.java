package com.github.danielsbaumann.info.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private final String country = "Brasil";
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;

    public Country br(List<Object> objects) {
        return Country
                .builder()
                .confirmed(confirmed(objects))
                .deaths(deaths(objects))
                .recovered(recovered(objects))
                .build();
    }

    public Integer confirmed(List<Object> objects) {
        List<Province> list = new Province()
                .list(objects);
        return list
                .stream()
                .mapToInt(pr -> pr.getConfirmed())
                .sum();
    }

    public Integer deaths(List<Object> objects) {
        List<Province> list = new Province()
                .list(objects);
        return list
                .stream()
                .mapToInt(pr -> pr.getDeaths())
                .sum();
    }

    public Integer recovered(List<Object> objects) {
        List<Province> list = new Province()
                .list(objects);
        return list
                .stream()
                .mapToInt(pr -> pr.getRecovered())
                .sum();
    }
}
