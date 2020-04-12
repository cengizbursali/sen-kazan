package com.cengizbursali.senkazan.utils;

import com.cengizbursali.senkazan.model.enums.Symbol;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolUtilsTest {

    @Test
    public void it_should_concat_symbol_list() {
        // Given
        List<Symbol> symbols = List.of(Symbol.EUR, Symbol.USD, Symbol.TRY);

        // When
        String symbolList = SymbolUtils.concatSymbolsWithComma(symbols);

        // Then
        assertThat(symbolList).isEqualTo("EUR,USD,TRY");
    }
}