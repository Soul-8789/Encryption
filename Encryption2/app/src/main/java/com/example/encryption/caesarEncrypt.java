package com.example.encryption;

public class caesarEncrypt {

    public static String encode(String inputStr, int shiftKey) {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String encryptStr = "";

        for (int i = 0; i < inputStr.length(); i++) {
            int pos = ALPHABET.indexOf(inputStr.charAt(i));
            if((inputStr.charAt(i)>='A' && inputStr.charAt(i)<='Z') || (inputStr.charAt(i)>='a' && inputStr.charAt(i)<='z')) {
                int encryptPos = (shiftKey + pos) % 52;
                char encryptChar = ALPHABET.charAt(encryptPos);
                encryptStr += encryptChar;
            }
            else {
                encryptStr += inputStr.charAt(i);
                continue;
            }
        }

        return encryptStr;
    }
}
