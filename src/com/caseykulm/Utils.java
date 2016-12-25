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

  /**
   * If returns true then the number is not prime because
   * some number other than 1 and itself is divisible wholly
   *
   * @param checkInt checking if this is prime
   * @param otherInt in the range of 2 to (checkInt-1)
   * @return true if checkInt / otherInt is a whole number
   */
  public static boolean isDivisibleWhole(int checkInt, int otherInt) {
    double checkDouble = 1.0 * checkInt;
    double resultDouble = checkDouble / otherInt;
    int intResult = checkInt / otherInt;
    double finalResult = resultDouble - intResult;
    return finalResult == 0;
  }

  public static void basicPrintPrimesToLimit(PrimalityStrategy strategy, int limit) {
    for (int i=1; i<=limit; i++) {
      if (strategy.isPrime(i)) {
        System.out.println(i);
      }
    }
  }
}
