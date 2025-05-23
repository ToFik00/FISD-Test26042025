package org.piva.fisdtest26042025.dto.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
    @JsonProperty("last_updated_at")
    private String lastUpdatedAt;
}
