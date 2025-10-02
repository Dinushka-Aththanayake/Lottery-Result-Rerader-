package com.example.lotteryreader.domain.service;
import com.example.lotteryreader.domain.entity.LotteryResult;
import com.example.lotteryreader.domain.service.LotteryScrapperService;
import com.example.lotteryreader.external.LotteryResultRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class LotteryService {

    private final LotteryScrapperService scraperService;
    private final LotteryResultRepository repository;

    public LotteryService(LotteryScrapperService scraperService, LotteryResultRepository repository) {
        this.scraperService = scraperService;
        this.repository = repository;
    }

    public void fetchAndSaveLatestResult() {
        try {
            LotteryResult result = scraperService.scrapeLatestResult();
            repository.save(result);
            System.out.println(
                    "Saved: " + result.getDrawDate() + " (Event " + result.getEventNumber() + ") → " +
                            result.getLetter() + " " +
                            result.getNumber1() + " " +
                            result.getNumber2() + " " +
                            result.getNumber3() + " " +
                            result.getNumber4() + " " +
                            result.getNumber5() + " " +
                            result.getNumber6()
            );
        } catch (IOException e) {
            System.err.println("Error fetching result: " + e.getMessage());
        }
    }
}
