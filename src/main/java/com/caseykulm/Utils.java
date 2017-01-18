package com.caseykulm;

import com.caseykulm.primality.PrimalityStrategy;
import java.math.BigInteger;

public class Utils {

  public static void logTime(long startTime, long endTime) {
    float millisToFind = endTime - startTime;
    System.out.println("millis to find:\t\t" + millisToFind);
    float secondsToFind = millisToFind / 1000;
    System.out.println("seconds to find:\t" + secondsToFind);
    float minutesToFind = secondsToFind / 60;
    System.out.println("minutes to find:\t" + minutesToFind);
  }

  public static void basicPrintPrimesToLimit(PrimalityStrategy strategy, BigInteger limit) {
    BigInteger i = BigInteger.ONE;
    while (i.compareTo(limit) <= 0) {
      if (strategy.isPrime(i)) {
        //System.out.println(i);
      }
      i = i.add(BigInteger.ONE);
    }
  }
}
