package com.code.array;

public class MyGasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minSpare = Integer.MAX_VALUE;
        int spare = 0;
        int minIndex = 0;
        for (int i = 0; i < gas.length; ++i) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % cost.length;
    }

}
