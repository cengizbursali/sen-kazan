package com.cengizbursali.senkazan.model.fixer.response;

import com.cengizbursali.senkazan.model.enums.Symbol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LatestRatesResponse {

    private boolean success;
    private boolean historical;
    private long timestamp;
    private LocalDate date;
    private Symbol base;
    private Map<Symbol, Double> rates;
}
