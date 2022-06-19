package io.github.dbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SeriesSumFinderTest {

    private SeriesSumFinder seriesSumFinder;

    @BeforeEach
    void setUp() {
        seriesSumFinder = new SeriesSumFinder();
    }

    @ParameterizedTest(name = "calculateSum({arguments})")
    @CsvSource(value = {
            "1.0,1.0",
            "2.0,3.0",
            "3.0,6.0",
            "4.0,10.0",
            "5.0,15.0",
            "6.0,21.0",
            "7.0,28.0",
            "8.0,36.0",
            "9.0,45.0",
            "10.0,55.0",
            "45.0,1035.0",
            "568.0,161596.0"
    })
    void calculateSum(double number, double expectedSum) {
        int calculatedSum = (int) seriesSumFinder.calculateSum(number);
        Assertions.assertEquals(
                expectedSum,
                calculatedSum,
                0.1,
                "The calculated sum is not correct!"
        );
    }

    @Test
    void calculateSumWithNegativeNumber() {
        int calculatedSum = (int) seriesSumFinder.calculateSum(-1);
        Assertions.assertEquals(
                0,
                calculatedSum,
                "The calculated sum is not correct!"
        );
    }
}