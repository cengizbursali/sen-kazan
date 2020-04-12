package com.cengizbursali.senkazan.utils;

import com.cengizbursali.senkazan.model.enums.Symbol;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SymbolUtils {

    private static final String COMMA = ",";

    public static String concatSymbolsWithComma(List<Symbol> symbols) {
        return symbols.stream()
                .map(Enum::name)
                .collect(Collectors.joining(COMMA));
    }
}
