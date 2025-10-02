package com.example.lotteryreader.domain.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "mahajana_sampatha_results")
public class LotteryResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lotteryName;   // e.g., Mahajana Sampatha
    private String drawDate;      // e.g., October 01, 2025 - Wednesday
    private String eventNumber;   // e.g., 5969

    private String letter;        // e.g., A, B, C, etc.

    private String number1;
    private String number2;
    private String number3;
    private String number4;
    private String number5;
    private String number6;

    public LotteryResult() {}

    public LotteryResult(String lotteryName, String drawDate, String eventNumber, String letter,
                         String number1, String number2, String number3,
                         String number4, String number5, String number6) {
        this.lotteryName = lotteryName;
        this.drawDate = drawDate;
        this.eventNumber = eventNumber;
        this.letter = letter;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getLotteryName() { return lotteryName; }
    public void setLotteryName(String lotteryName) { this.lotteryName = lotteryName; }

    public String getDrawDate() { return drawDate; }
    public void setDrawDate(String drawDate) { this.drawDate = drawDate; }

    public String getEventNumber() { return eventNumber; }
    public void setEventNumber(String eventNumber) { this.eventNumber = eventNumber; }

    public String getLetter() { return letter; }
    public void setLetter(String letter) { this.letter = letter; }

    public String getNumber1() { return number1; }
    public void setNumber1(String number1) { this.number1 = number1; }

    public String getNumber2() { return number2; }
    public void setNumber2(String number2) { this.number2 = number2; }

    public String getNumber3() { return number3; }
    public void setNumber3(String number3) { this.number3 = number3; }

    public String getNumber4() { return number4; }
    public void setNumber4(String number4) { this.number4 = number4; }

    public String getNumber5() { return number5; }
    public void setNumber5(String number5) { this.number5 = number5; }

    public String getNumber6() { return number6; }
    public void setNumber6(String number6) { this.number6 = number6; }
}