package chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static chapter1.Ex4.isPalindromePermutation1;
import static chapter1.Ex4.isPalindromePermutation2;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex4_test {


    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"Anita lava la tina", "Taco cat"})
    void isPalindromePermutation1_positiveScenarios(String text) {
        boolean result = isPalindromePermutation1(text);
        assertTrue(result);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"Anita no lava la tina", "Taco car"})
    void isPalindromePermutation1_negativeScenarios(String text) {
        boolean result = isPalindromePermutation1(text);
        assertFalse(result);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"Anita lava la tina", "Taco cat"})
    void isPalindromePermutation2_positiveScenarios(String text) {
        boolean result = isPalindromePermutation2(text);
        assertTrue(result);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"Anita no lava la tina", "Taco car"})
    void isPalindromePermutation2_negativeScenarios(String text) {
        boolean result = isPalindromePermutation2(text);
        assertFalse(result);
    }
}
