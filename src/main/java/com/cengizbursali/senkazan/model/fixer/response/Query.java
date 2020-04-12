package com.cengizbursali.senkazan.model.fixer.response;

import com.cengizbursali.senkazan.model.enums.Symbol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Query {

    private Symbol from;
    private Symbol to;
    private Double amount;
}
