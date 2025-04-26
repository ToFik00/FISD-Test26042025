package org.piva.fisdtest26042025.client;

import org.piva.fisdtest26042025.dto.currency.CurrencyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency", url = "https://api.currencyapi.com")
public interface CurrencyClient {

    @GetMapping("/v3/latest")
    CurrencyApiResponse getLatest(@RequestParam("apikey") String apikey,
                                  @RequestParam("base_currency") String baseCurrency);
}