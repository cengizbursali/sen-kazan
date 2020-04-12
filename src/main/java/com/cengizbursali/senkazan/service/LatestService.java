package com.cengizbursali.senkazan.service;

import com.cengizbursali.senkazan.model.enums.Symbol;
import com.cengizbursali.senkazan.model.fixer.request.HistoricalRatesRequest;
import com.cengizbursali.senkazan.model.fixer.request.LatestRatesRequest;
import com.cengizbursali.senkazan.model.fixer.response.LatestRatesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LatestService {

    private static final List<Symbol> SYMBOLS = Arrays.asList(Symbol.BTC,
                                                              Symbol.EUR,
                                                              Symbol.USD,
                                                              Symbol.TRY);
    private final FixerApiService fixerApiService;

    public LatestRatesResponse denememe() {
        final LatestRatesRequest latestRatesRequest = LatestRatesRequest.builder().build();
        final HistoricalRatesRequest historicalRatesRequest = HistoricalRatesRequest.builder().build();
        fixerApiService.getHistoricalRatesResponse(historicalRatesRequest);
        return fixerApiService.getLatestRatesResponse(latestRatesRequest);
    }
}
