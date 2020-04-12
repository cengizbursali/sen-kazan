package com.cengizbursali.senkazan.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "fixer.api")
@Getter
@Setter
public class FixerApiProperties {

    private String accessKey;
}
