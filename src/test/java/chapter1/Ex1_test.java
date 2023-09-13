package chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static chapter1.Ex1.isUniqueA;
import static chapter1.Ex1.isUniqueB;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Ex1_test {

    private static final String uniqueString = "abcdef";
    private static final String notUniqueString = "abcdefa";

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { uniqueString })
    void uniqueA_positiveScenarios(String str) {
        boolean result = isUniqueA(str);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = { notUniqueString })
    void uniqueA_negativeScenarios(String str) {
        boolean result = isUniqueA(str);
        assertFalse(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { uniqueString })
    void uniqueB_positiveScenarios(String str) {
        boolean result = isUniqueB(str);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = { notUniqueString })
    void uniqueB_negativeScenarios(String str) {
        boolean result = isUniqueB(str);
        assertFalse(result);
    }
}
