package org.piva.fisdtest26042025.dto.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyData {
    private String code;
    private Double value;
}