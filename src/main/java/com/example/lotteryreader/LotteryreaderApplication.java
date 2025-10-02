package com.example.lotteryreader;

import com.example.lotteryreader.domain.service.LotteryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.io.IOException;

@SpringBootApplication
public class LotteryreaderApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LotteryreaderApplication.class, args);
		LotteryService lotteryService = context.getBean(LotteryService.class);
		System.out.println("Fetching latest lottery result and saving to database...");
		lotteryService.fetchAndSaveLatestResult();
	}

}
