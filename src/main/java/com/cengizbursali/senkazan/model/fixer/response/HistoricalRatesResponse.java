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
public class HistoricalRatesResponse {

    private boolean success;
    private long timestamp;
    private Symbol base;
    private LocalDate date;
    private Map<Symbol, Double> rates;
}
