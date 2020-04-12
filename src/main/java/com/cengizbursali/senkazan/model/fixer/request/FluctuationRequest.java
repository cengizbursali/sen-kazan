package com.cengizbursali.senkazan.model.fixer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FluctuationRequest {

    private LocalDate startDate;
    private LocalDate endDate;
}
