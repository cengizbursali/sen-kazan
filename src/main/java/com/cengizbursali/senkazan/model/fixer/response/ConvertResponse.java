package com.cengizbursali.senkazan.model.fixer.response;

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
public class ConvertResponse {

    private boolean success;
    private Query query;
    private Info info;
    private LocalDate localDate;
    private Double result;
}
