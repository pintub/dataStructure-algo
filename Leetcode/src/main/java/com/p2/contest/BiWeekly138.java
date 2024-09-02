package com.p2.contest;

/**
 *
 *
 *
 *
 *
 */
public class BiWeekly138 {

    public int generateKey(int num1, int num2, int num3) {
        int tenMultiplier = 10;
        int result = 0;
        for(int bit = 0; bit <= 3; bit++) {
            result += Math.pow(10, bit)  * Math.min(Math.min(num1 % tenMultiplier, num2 % tenMultiplier), num3 % tenMultiplier);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
            if(num1 == 0 && num2 == 0 && num3 ==0){
                break;
            }
        }

        System.out.println(result);
        return result;
    }

    public String stringHash(String s, int k) {
        int sLen = s.length();

        StringBuilder resultSb= new StringBuilder() ;

        int subStringCharCount = 0;
        int subStringSum = 0;

        int aInt = (int)'a';
        for(int index = 0; index < sLen; index++) {
            char currChar = s.charAt(index);
            subStringSum += currChar - 'a';
            ++subStringCharCount;
            if(subStringCharCount == k) {
                resultSb.append((char)(subStringSum % 26 + aInt) + "");
                subStringSum=0;
                subStringCharCount=0;
            }
        }

        System.out.println(resultSb.toString());
        return resultSb.toString();
    }


    public long minDamage(int power, int[] damage, int[] health) {
        int totalDamage = 0;
        for(int aDamage : damage) {
            totalDamage += aDamage;
        }
        int temp = recursion(power, totalDamage, damage, health);
        System.out.println(temp);

        return temp;
    }

    int recursion(final int power, int totalDamage, final int[] damage, int[] health) {
        if(totalDamage == 0)
            return 0;

        int currResult = Integer.MAX_VALUE;

        for(int idx = 0; idx < health.length; idx++) {
            if(health[idx] <= 0) {
                continue;
            }
            //idx-th enemy choosen
            int tempHealth = health[idx];
            int noOfAttacks = (int) Math.ceil((double) tempHealth / (double) power);

            health[idx] = 0;

            int temp = totalDamage * noOfAttacks + recursion(power, totalDamage - damage[idx], damage, health);
            currResult = Math.min(currResult, temp);
            health[idx] = tempHealth;
        }

        return currResult;
    }

    public static void main(String[] args) {
        BiWeekly138 sol = new BiWeekly138();
        sol.minDamage(4, new int[]{1,2,3,4}, new int[]{4,5,6,8});
        //sol.minDamage(1, new int[]{1,1,1,1}, new int[]{1,2,3,4});
     //sol.minDamage(8, new int[]{40}, new int[]{59});
   //     System.out.println((int) Math.ceil((double) 59 /(double) 8));
    }
}
