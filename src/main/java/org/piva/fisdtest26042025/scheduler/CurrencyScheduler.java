package org.piva.fisdtest26042025.scheduler;

import lombok.RequiredArgsConstructor;
import org.piva.fisdtest26042025.dto.currency.CurrencyApiResponse;
import org.piva.fisdtest26042025.entity.User;
import org.piva.fisdtest26042025.repository.UserRepository;
import org.piva.fisdtest26042025.service.CurrencyService;
import org.piva.fisdtest26042025.util.EmailSenderUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CurrencyScheduler {

    private final CurrencyService currencyService;
    private final UserRepository userRepository;
    private final EmailSenderUtil emailSenderUtil;

    @Scheduled(cron = "0 * * * * *")
    public void sendDailyCurrencyUpdate() {
        CurrencyApiResponse response = currencyService.fetchLatestRates();
        String ratesText = formatRates(response);
        List<User> users = userRepository.findByEnabled(true);
        for (User user : users) {
            emailSenderUtil.sendEmail(user.getEmail(), "Ежедневные курсы валют", ratesText);
        }
    }

    private String formatRates(CurrencyApiResponse response) {
        return response.getData().values().stream()
                .map(data -> data.getCode() + ": " + data.getValue())
                .collect(Collectors.joining(", "));
    }
}
