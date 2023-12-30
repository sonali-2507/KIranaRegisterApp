package com.kiranastore.transactionmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FxRatesApiResponse {
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("rates")
    private Map<String,Double>rates;


}
