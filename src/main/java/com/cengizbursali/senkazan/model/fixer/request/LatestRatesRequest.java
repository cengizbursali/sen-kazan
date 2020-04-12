package com.cengizbursali.senkazan.model.fixer.request;

import com.cengizbursali.senkazan.model.enums.Symbol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LatestRatesRequest {

    @Builder.Default
    private Symbol base = Symbol.EUR;

    @Builder.Default
    private List<Symbol> symbols = new ArrayList<>();
}
