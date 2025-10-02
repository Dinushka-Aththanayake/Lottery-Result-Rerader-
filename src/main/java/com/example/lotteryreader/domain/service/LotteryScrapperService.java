package com.example.lotteryreader.domain.service;

import com.example.lotteryreader.domain.entity.LotteryResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

@Service
public class LotteryScrapperService {
    private static final String URL = "https://www.lankayp.com/lottery/result/mahajana-sampatha";

    public LotteryResult scrapeLatestResult() throws IOException {
        Document doc = Jsoup.connect(URL).timeout(10_000).get();

        // Get the first draw title
        Element title = doc.selectFirst(".lotto_title");
        if (title == null) throw new IOException("No draw title found");

        String drawInfo = title.text();  // contains date + event number
        String[] parts = drawInfo.split(" ");
        String eventNumber = parts[parts.length - 1]; // last part
        String drawDate = drawInfo.replace(eventNumber, "").trim();

        // Get numbers block
        Element numbersBlock = title.nextElementSibling();
        Elements numbers = numbersBlock.select(".lotto_no_r");

        if (numbers.size() < 7) throw new IOException("Not enough numbers found");

        // First element is the letter
        String letter = numbers.get(0).text();

        return new LotteryResult(
                "Mahajana Sampatha",
                drawDate,
                eventNumber,
                letter,
                numbers.get(1).text(),
                numbers.get(2).text(),
                numbers.get(3).text(),
                numbers.get(4).text(),
                numbers.get(5).text(),
                numbers.get(6).text()
        );
    }
}
