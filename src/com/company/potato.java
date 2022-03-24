package com.company;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class potato {
    public static void main(String[] args) {
        int numberOfDigits = 5;
        BigDecimal a = new BigDecimal("8.0");
        BigDecimal b = new BigDecimal("7.0");

        MathContext mathContext = new MathContext(numberOfDigits, RoundingMode.HALF_UP);
        System.out.println(a.divide(b, mathContext));
    }
}
