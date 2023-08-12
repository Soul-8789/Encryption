package com.example.encryption;

public class pigLatinEncrypt {
    static boolean isVowel(char c) {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    static String encode(String s) {

        // the index of the first vowel is stored.
//        int len = s.length();
//        int index = -1;
//        for (int i = 0; i < len; i++) {
//            if (isVowel(s.charAt(i))) {
//                index = i;
//                break;
//            }
//        }
//
////        // Pig Latin is possible only if vowels is present
//        if (index == -1)
//            return "-1";
//
//        // Take all characters after index (including index). Append all characters which are before index. Finally append "ay"
//        return s.substring(index) + s.substring(0, index) + "ay";
        String[] words = s.split("\\s+");
        StringBuilder encryptedMessage = new StringBuilder();

        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            StringBuilder encryptedWord = new StringBuilder();

            if (lowerCaseWord.matches("[a-z]+")) {
                char firstChar = lowerCaseWord.charAt(0);

                if (isVowel(firstChar)) {
                    encryptedWord.append(lowerCaseWord).append("ya");
                } else {
                    encryptedWord.append(lowerCaseWord.substring(1))
                            .append(firstChar)
                            .append("ay");
                }
            } else {
                encryptedWord.append(word);
            }

            encryptedMessage.append(encryptedWord).append(" ");
        }

        return encryptedMessage.toString().trim();

    }
}

