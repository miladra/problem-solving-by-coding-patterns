package com.patterns.twopointers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidPalindrome {
    public boolean isPalindrome(String s) {

        if(s == null || s.equals("")){
            return false;
        }

        int left = 0;
        int right = s.length() -1;

        while(left < right){

            while(left < right  && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;

        }

        return true;
    }
}


class ValidPalindromeTest {

    @Test
    public void testNullInput() {
        ValidPalindrome palindrome = new ValidPalindrome();
        boolean result = palindrome.isPalindrome(null);
        Assertions.assertFalse(result);
    }

    @Test
    public void testEmptyString() {
        ValidPalindrome palindrome = new ValidPalindrome();
        boolean result = palindrome.isPalindrome("");
        Assertions.assertFalse(result);
    }

    @Test
    public void testSingleCharacter() {
        ValidPalindrome palindrome = new ValidPalindrome();
        boolean result = palindrome.isPalindrome("a");
        Assertions.assertTrue(result);
    }

    @Test
    public void testNonAlphanumericCharacters() {
        ValidPalindrome palindrome = new ValidPalindrome();
        boolean result = palindrome.isPalindrome("!@#$%^&*()_+-=[]{}\\|;':\",./<>?");
        Assertions.assertTrue(result);
    }

    @Test
    public void testPalindrome() {
        ValidPalindrome palindrome = new ValidPalindrome();
        boolean result = palindrome.isPalindrome("A man, a plan, a canal: Panama");
        Assertions.assertTrue(result);
    }

    @Test
    public void testNonPalindrome() {
        ValidPalindrome palindrome = new ValidPalindrome();
        boolean result = palindrome.isPalindrome("race a car");
        Assertions.assertFalse(result);
    }
}

