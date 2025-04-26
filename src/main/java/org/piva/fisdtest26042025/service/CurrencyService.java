package org.piva.fisdtest26042025.service;

import org.piva.fisdtest26042025.client.CurrencyClient;
import org.piva.fisdtest26042025.dto.currency.CurrencyApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final CurrencyClient client;
    private final String apiKey;
    private final String baseCurrency;

    public CurrencyService(
            CurrencyClient client,
            @Value("${API_CURRENCY_KEY}") String apiKey,
            @Value("${API_CURRENCY_BASE}") String baseCurrency
    ) {
        this.client = client;
        this.apiKey = apiKey;
        this.baseCurrency = baseCurrency;
    }

    public CurrencyApiResponse fetchLatestRates() {
        return client.getLatest(apiKey, baseCurrency);
    }
}
