package com.p2.random.topinterviewques;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker {

    private Map<Integer, Integer> numVsCount;
    private Map<Integer, Integer> freqVsFreqCount;

    public FrequencyTracker() {
        numVsCount = new HashMap<>();
        freqVsFreqCount = new HashMap<>();
    }

    public void add(int number) {
        Integer numCount = numVsCount.getOrDefault(number, 0);
        numVsCount.put(number, numCount + 1);

        Integer freqCount = freqVsFreqCount.getOrDefault(numCount, 0);
        if (freqCount == 0) {
            Integer temp = freqVsFreqCount.getOrDefault(numCount + 1, 0);
            freqVsFreqCount.put(numCount + 1, temp + 1);
        } else if (freqCount == 1) {
            freqVsFreqCount.remove(numCount);
            Integer temp = freqVsFreqCount.getOrDefault(numCount + 1, 0);
            freqVsFreqCount.put(numCount + 1, temp + 1);
        } else {
            freqVsFreqCount.put(numCount, freqCount - 1);
            Integer temp = freqVsFreqCount.getOrDefault(numCount + 1, 0);
            freqVsFreqCount.put(numCount + 1, temp + 1);
        }
    }

    public void deleteOne(int number) {
        Integer numCount = numVsCount.getOrDefault(number, 0);
        if (numCount == null || numCount == 0) {
            return;
        }
        if (numCount == 1) {
            numVsCount.remove(number);
        } else {
            numVsCount.put(number, numCount - 1);
        }

        Integer freqCount = freqVsFreqCount.get(numCount);
        if (freqCount == 1) {
            freqVsFreqCount.remove(numCount);
        } else {
            freqVsFreqCount.put(numCount, freqCount - 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqVsFreqCount.containsKey(frequency);
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(5);
        frequencyTracker.add(4);
        frequencyTracker.deleteOne(6);
        frequencyTracker.deleteOne(4);
        frequencyTracker.hasFrequency(1);
    }
}
