package com.erikalves.main.palindrome;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
class PalindromeTest {

    static final Logger LOG = Logger.getLogger(PalindromeTest.class.getName());
    private Palindrome palindrome = new Palindrome() ;

    @ParameterizedTest (name = "{index} => message=''{0}''")
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void checkIfLetterIsPalindrome(String candidate) {
        assertTrue(palindrome.isPalindrome(candidate));
    }


    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest (name = "{index} => message=''{0}''")
    @ValueSource(strings = {"Hello", "World"})
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        assertNotNull(message);
    }

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
}