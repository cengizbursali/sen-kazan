package com.cengizbursali.senkazan.controller;

import com.cengizbursali.senkazan.model.fixer.response.LatestRatesResponse;
import com.cengizbursali.senkazan.service.LatestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deneme")
@RequiredArgsConstructor
public class DenemeController {

    private final LatestService latestService;

    @GetMapping
    public LatestRatesResponse getLatestResponse() {
        return latestService.denememe();
    }
}
