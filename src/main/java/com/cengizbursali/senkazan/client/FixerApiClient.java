package com.cengizbursali.senkazan.client;

import com.cengizbursali.senkazan.model.enums.Symbol;
import com.cengizbursali.senkazan.model.fixer.response.ConvertResponse;
import com.cengizbursali.senkazan.model.fixer.response.FluctuationResponse;
import com.cengizbursali.senkazan.model.fixer.response.HistoricalRatesResponse;
import com.cengizbursali.senkazan.model.fixer.response.LatestRatesResponse;
import com.cengizbursali.senkazan.model.fixer.response.TimeSeriesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "fixerApiClient", url = "${fixer.api.url}")
public interface FixerApiClient {

    @GetMapping(value = "/latest")
    LatestRatesResponse getLatestRatesResponse(@RequestParam("access_key") String accessKey,
                                               @RequestParam Symbol base,
                                               @RequestParam String symbols);

    @GetMapping(value = "/{date}")
    HistoricalRatesResponse getHistoricalRatesResponse(@PathVariable String date,
                                                       @RequestParam("access_key") String accessKey,
                                                       @RequestParam Symbol base,
                                                       @RequestParam String symbols);

    @GetMapping(value = "/convert")
    ConvertResponse convert(@RequestParam("access_key") String accessKey,
                            @RequestParam Symbol from,
                            @RequestParam Symbol to,
                            @RequestParam Double amount);

    @GetMapping(value = "/timeseries")
    TimeSeriesResponse getTimeSeriesResponse(@RequestParam("access_key") String accessKey,
                                             @RequestParam("start_date") String startDate,
                                             @RequestParam("end_date") String endDate);

    @GetMapping(value = "/fluctuation")
    FluctuationResponse getFluctuationResponse(@RequestParam("access_key") String accessKey,
                                               @RequestParam("start_date") String startDate,
                                               @RequestParam("end_date") String endDate);
}
