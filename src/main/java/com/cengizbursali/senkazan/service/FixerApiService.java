package com.cengizbursali.senkazan.service;

import com.cengizbursali.senkazan.client.FixerApiClient;
import com.cengizbursali.senkazan.configuration.FixerApiProperties;
import com.cengizbursali.senkazan.model.fixer.request.ConvertRequest;
import com.cengizbursali.senkazan.model.fixer.request.FluctuationRequest;
import com.cengizbursali.senkazan.model.fixer.request.HistoricalRatesRequest;
import com.cengizbursali.senkazan.model.fixer.request.LatestRatesRequest;
import com.cengizbursali.senkazan.model.fixer.request.TimeSeriesRequest;
import com.cengizbursali.senkazan.model.fixer.response.ConvertResponse;
import com.cengizbursali.senkazan.model.fixer.response.FluctuationResponse;
import com.cengizbursali.senkazan.model.fixer.response.HistoricalRatesResponse;
import com.cengizbursali.senkazan.model.fixer.response.LatestRatesResponse;
import com.cengizbursali.senkazan.model.fixer.response.TimeSeriesResponse;
import com.cengizbursali.senkazan.utils.SymbolUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FixerApiService {

    private final FixerApiProperties fixerApiProperties;
    private final FixerApiClient fixerApiClient;

    public LatestRatesResponse getLatestRatesResponse(LatestRatesRequest latestRatesRequest) {

        final String symbols = SymbolUtils.concatSymbolsWithComma(latestRatesRequest.getSymbols());

        return fixerApiClient.getLatestRatesResponse(fixerApiProperties.getAccessKey(),
                                                     latestRatesRequest.getBase(),
                                                     symbols);
    }

    public HistoricalRatesResponse getHistoricalRatesResponse(HistoricalRatesRequest historicalRatesRequest) {

        final String symbols = SymbolUtils.concatSymbolsWithComma(historicalRatesRequest.getSymbols());

        return fixerApiClient.getHistoricalRatesResponse(historicalRatesRequest.getLocalDate().toString(),
                                                         fixerApiProperties.getAccessKey(),
                                                         historicalRatesRequest.getBase(),
                                                         symbols);
    }

    public ConvertResponse convert(ConvertRequest convertRequest) {
        return fixerApiClient.convert(fixerApiProperties.getAccessKey(),
                                      convertRequest.getFrom(),
                                      convertRequest.getTo(),
                                      convertRequest.getAmount());
    }

    public TimeSeriesResponse getTimeSeriesResponse(TimeSeriesRequest timeSeriesRequest) {

        return fixerApiClient.getTimeSeriesResponse(fixerApiProperties.getAccessKey(),
                                                    timeSeriesRequest.getStartDate().toString(),
                                                    timeSeriesRequest.getEndDate().toString());
    }

    public FluctuationResponse getFluctuationResponse(FluctuationRequest fluctuationRequest) {

        return fixerApiClient.getFluctuationResponse(fixerApiProperties.getAccessKey(),
                                                     fluctuationRequest.getStartDate().toString(),
                                                     fluctuationRequest.getEndDate().toString());
    }
}
