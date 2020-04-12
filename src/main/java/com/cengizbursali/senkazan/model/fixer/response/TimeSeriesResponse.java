package com.cengizbursali.senkazan.model.fixer.response;

import com.cengizbursali.senkazan.model.enums.Symbol;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TimeSeriesResponse {

    private boolean success;
    private boolean timeseries;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("end_date")
    private LocalDate endDate;

    private Symbol base;
    private Map<LocalDate, Map<Symbol, Double>> rates;
}
