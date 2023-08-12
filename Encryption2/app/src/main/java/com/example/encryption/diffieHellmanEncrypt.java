package com.example.encryption;

public class diffieHellmanEncrypt {
    static int q = 23, alpha = 9;

    static int generatePublicKey(int x) {
        if(x >= q) return -1;

        int y = helper(alpha, x, q);

        return y;
    }

    private static int helper(int alpha, int x, int q) {
        int ans = 1, pdt = 1;
        for(int i = 1; i <= x; i++) {
            pdt *= alpha;
            ans = pdt % q;
            pdt %= q;
        }

        return ans;
    }
}
