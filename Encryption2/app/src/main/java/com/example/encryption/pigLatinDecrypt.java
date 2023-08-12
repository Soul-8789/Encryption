package com.example.encryption;

public class pigLatinDecrypt {

    static boolean isVowel(char c) {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    static String decode(String s) {
        String[] words = s.split("\\s+");
        StringBuilder decryptedMessage = new StringBuilder();

        for (String word: words) {
            String lowerCaseWord = word.toLowerCase();
            StringBuilder decryptedWord = new StringBuilder();

            if (lowerCaseWord.matches("[a-z]+")) {
                int length = lowerCaseWord.length();

                if (length > 2 && lowerCaseWord.endsWith("ay")) {
                    decryptedWord.append(lowerCaseWord, 0, length - 2);
                    char lastChar = decryptedWord.charAt(decryptedWord.length() - 1);
                    decryptedWord.deleteCharAt(decryptedWord.length() - 1)
                            .insert(0, lastChar);
                } else if (length > 2 && lowerCaseWord.endsWith("ya")) {
                    decryptedWord.append(lowerCaseWord, 0, length - 2);
                }
            } else {
                decryptedWord.append(word);
            }
            decryptedMessage.append(decryptedWord).append(" ");
        }

        return decryptedMessage.toString().trim();
    }
}
