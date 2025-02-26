package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class FunctionSystem {

    public static Double count(Double x) {
        if (x <= 0)
            return firstFunc(x);
        else
            return secondFunc(x);
    }

    private static Double firstFunc(Double x) {
        return Math.pow(
                Math.pow(Math.pow(Math.pow(Trigonometry.sin(x), 3), 3), 2)
                        * (Trigonometry.sec(x) * Trigonometry.sec(x)),
                3);
    }

    private static Double secondFunc(Double x) {
        return Math.pow((Logarithm.log5(Math.pow(x, 2)) - Logarithm.log5(x)) / Logarithm.log5(x), 2)
                + Math.pow(Logarithm.ln(x) * Logarithm.log2(x), 3);
    }
}
