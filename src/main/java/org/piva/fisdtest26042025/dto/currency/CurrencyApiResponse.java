package org.piva.fisdtest26042025.dto.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.repository.Meta;

import java.util.Map;

@Data
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyApiResponse {
    private Meta meta;
    private Map<String, CurrencyData> data;
}
