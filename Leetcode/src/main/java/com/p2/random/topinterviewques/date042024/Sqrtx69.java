package com.p2.random.topinterviewques.date042024;

public class Sqrtx69 {

    public int mySqrt(int x) {
        int lo = 0;
        int hi = x;
        while(lo < hi) {

            long mid = (lo + hi)/2;
            long midSqr = mid * mid;
            if(midSqr == x) {
                return (int)mid;
            }

            if(midSqr < x) {
                lo = (int)mid + 1;
            } else {
                hi = (int)mid - 1;
            }
        }

        if(lo*lo <= x) {//This operation when lo == hi
            return lo;
        } else {
            return lo - 1;
        }
    }

    public static void main(String[] args) {
        Sqrtx69 sol = new Sqrtx69();
        System.out.println(sol.mySqrt(2147395599));
    }
}
