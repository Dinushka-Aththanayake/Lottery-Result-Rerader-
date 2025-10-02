package com.example.lotteryreader.external;

import com.example.lotteryreader.domain.entity.LotteryResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryResultRepository extends JpaRepository<LotteryResult,Long> {
}
