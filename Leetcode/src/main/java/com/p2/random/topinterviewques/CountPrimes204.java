package com.p2.random.topinterviewques;

/**
 * Look-ahead memory concept
 */
public class CountPrimes204 {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];//ALL False
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {//Means Prime
                count++;
                for (int j = 2; i * j < n; j++) {//A Prime number multiplies with other numbers to form more non-primes
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes204 sol = new CountPrimes204();
        System.out.println(sol.countPrimes(499979));
    }
}
