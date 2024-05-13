package com.p2.random.topinterviewques.date042024;

public class GasStation134 {

    /**
     * If Sum of gas[i]-cost[i] +ve, Then we have solution
     * It's stored in "total_surplus" .
     *
     * While computing "total_surplus" , if it becomes -ve, the start Index will be somewhere in future-index
     *
     * https://leetcode.com/problems/gas-station/solutions/1706142/java-c-python-an-explanation-that-ever-exists-till-now/?envType=study-plan-v2&envId=top-interview-150
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }
}
