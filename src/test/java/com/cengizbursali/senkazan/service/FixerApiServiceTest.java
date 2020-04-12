package com.cengizbursali.senkazan.service;

import com.cengizbursali.senkazan.client.FixerApiClient;
import com.cengizbursali.senkazan.model.enums.Symbol;
import com.cengizbursali.senkazan.model.fixer.request.HistoricalRatesRequest;
import com.cengizbursali.senkazan.model.fixer.request.LatestRatesRequest;
import com.cengizbursali.senkazan.model.fixer.response.HistoricalRatesResponse;
import com.cengizbursali.senkazan.model.fixer.response.LatestRatesResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FixerApiServiceTest {

    @Autowired
    private FixerApiService fixerApiService;

    @MockBean
    private FixerApiClient fixerApiClient;

    @Test
    public void it_should_get_latest_rates() {
        // Given
        LatestRatesRequest latestRatesRequest = LatestRatesRequest.builder()
                .base(Symbol.TRY)
                .symbols(List.of(Symbol.EUR, Symbol.USD))
                .build();
        LatestRatesResponse latestRatesResponse = LatestRatesResponse.builder().build();
        given(fixerApiClient.getLatestRatesResponse("test_key", Symbol.TRY, "EUR,USD"))
                .willReturn(latestRatesResponse);

        // When
        LatestRatesResponse result = fixerApiService.getLatestRatesResponse(latestRatesRequest);

        // Then
        verify(fixerApiClient).getLatestRatesResponse("test_key", Symbol.TRY, "EUR,USD");
        assertThat(result).isEqualTo(latestRatesResponse);
    }

    @Test
    public void it_should_get_historical_rates() {
        // Given
        LocalDate now = LocalDate.of(2020, 4, 12);
        HistoricalRatesRequest historicalRatesRequest = HistoricalRatesRequest.builder()
                .localDate(now)
                .base(Symbol.TRY)
                .symbols(List.of(Symbol.EUR, Symbol.BTC))
                .build();
        HistoricalRatesResponse historicalRatesResponse = HistoricalRatesResponse.builder().build();
        given(fixerApiClient.getHistoricalRatesResponse("2020-04-12", "test_key", Symbol.TRY, "EUR,BTC"))
                .willReturn(historicalRatesResponse);

        // When
        HistoricalRatesResponse result = fixerApiService.getHistoricalRatesResponse(historicalRatesRequest);

        // Then
        verify(fixerApiClient).getHistoricalRatesResponse("2020-04-12", "test_key", Symbol.TRY, "EUR,BTC");
        assertThat(result).isEqualTo(historicalRatesResponse);
    }
}