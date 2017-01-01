package com.caseykulm;

import java.util.LinkedList;
import java.util.List;

public class MathUtils {
  /**
   * @param checkNum Input natural number
   * @param otherNum Other natural number
   * @return true if checkNum / otherNum is a natural number
   */
  public static boolean isNaturalDivisor(double checkNum, double otherNum) {
    double result = checkNum / otherNum;
    double fractionBit = result % 1;
    return fractionBit == 0;
  }

  /**
   * Limit on laptop to keep under 1 second is ~2^41
   *
   * @param checkNum
   * @return true if there exist natural numbers m > 1, and k > 1 such that m^k = n
   */
  public static boolean isPerfectPower(double checkNum) {
    double exponentLimit = Math.log10(checkNum) / Math.log10(2);
    double baseLimit = Math.sqrt(checkNum);
    List<Double> divisors = getDivisors(checkNum);
    for (double m = 2; m <= baseLimit; m++) {
      for (double k = 0; k < divisors.size(); k++) {
        if (k > exponentLimit) {
          break; // move on to next value of m
        }
        double n = Math.pow(m, k);
        if (checkNum == n) {
          return true;
        }
      }
    }

    return false;
  }

  public static List<Double> getDivisors(double checkNum) {
    List<Double> divisors = new LinkedList<>();
    double sqrt = Math.sqrt(checkNum);
    for (double potentialDivisor=1; potentialDivisor <= sqrt; potentialDivisor++) {
      if (isNaturalDivisor(checkNum, potentialDivisor)) {
        divisors.add(potentialDivisor);
        if (potentialDivisor != sqrt) {
          double otherDivisor = checkNum / potentialDivisor;
          divisors.add(otherDivisor);
        }
      }
    }
    return divisors;
  }
}
