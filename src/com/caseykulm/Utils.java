package com.caseykulm;

import com.caseykulm.primality.PrimalityStrategy;

public class Utils {

  public static void logTime(long startTime, long endTime) {
    float millisToFind = endTime - startTime;
    System.out.println("millis to find:\t\t" + millisToFind);
    float secondsToFind = millisToFind / 1000;
    System.out.println("seconds to find:\t" + secondsToFind);
    float minutesToFind = secondsToFind / 60;
    System.out.println("minutes to find:\t" + minutesToFind);
  }

  public static void basicPrintPrimesToLimit(PrimalityStrategy strategy, int limit) {
    for (int i=1; i<=limit; i++) {
      if (strategy.isPrime(i)) {
        System.out.println(i);
      }
    }
  }
}
