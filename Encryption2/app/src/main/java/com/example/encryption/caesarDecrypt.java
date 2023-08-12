package com.example.encryption;

public class caesarDecrypt {

    public static String decode(String inputStr, int shiftKey) {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String decryptStr = "";


        for (int i = 0; i < inputStr.length(); i++) {
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            if((inputStr.charAt(i)>='A' && inputStr.charAt(i)<='Z') || (inputStr.charAt(i)>='a' && inputStr.charAt(i)<='z')) {
                int decryptPos = (pos - shiftKey) % 52;
                if (decryptPos < 0) {
                    decryptPos = ALPHABET.length() + decryptPos;
                }
                char decryptChar = ALPHABET.charAt(decryptPos);
                decryptStr += decryptChar;
            }
            else {
                decryptStr += inputStr.charAt(i);
                continue;
            }
        }
        return decryptStr;
    }
}
