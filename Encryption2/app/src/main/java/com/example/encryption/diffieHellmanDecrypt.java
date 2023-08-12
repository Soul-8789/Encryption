package com.example.encryption;

public class diffieHellmanDecrypt {
    static int q = 23, alpha = 9;

    static int generateSecretNumber(int x,int y) {
        if(x >= q) return -1;

        int sec = helper(y, x, q);

        return sec;
    }

    private static int helper(int alpha, int x, int q) {
        int ans = 1, pdt = 1;
        for (int i = 1; i <= x; i++) {
            pdt *= alpha;
            ans = pdt % q;
            pdt %= q;
        }

        return ans;
    }
}
