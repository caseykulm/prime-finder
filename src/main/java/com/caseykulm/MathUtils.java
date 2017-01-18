package com.caseykulm;

import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class MathUtils {
  /**
   * @param checkNum Input natural number
   * @param otherNum Other natural number
   * @return true if checkNum / otherNum is a natural number
   */
  public static boolean isNaturalDivisor(BigInteger checkNum, BigInteger otherNum) {
    return checkNum.remainder(otherNum).equals(BigInteger.ZERO);
  }

  /**
   * Limit on laptop to keep under 1 second is ~2^41
   *
   * @param checkNum
   * @return true if there exist natural numbers m > 1, and k > 1 such that m^k = n
   */
  public static boolean isPerfectPower(BigInteger checkNum) {
    int exponentLimit = BigIntegerMath.log2(checkNum, RoundingMode.FLOOR);
    BigInteger baseLimit = BigIntegerMath.sqrt(checkNum, RoundingMode.FLOOR);
    List<BigInteger> divisors = getDivisors(checkNum);
    BigInteger m = BigInteger.valueOf(2);
    while (m.compareTo(baseLimit) <= 0) {
      BigInteger k = BigInteger.ZERO;
      while (k.compareTo(BigInteger.valueOf(divisors.size())) <= 0) {
        if (k.compareTo(BigInteger.valueOf(exponentLimit)) > 0) {
          break; // move on to next value of m
        }
        BigInteger n = m.pow(k.intValue());
        if (checkNum.compareTo(n) == 0) {
          return true;
        }
        k = k.add(BigInteger.ONE);
      }
      m = m.add(BigInteger.ONE);
    }

    return false;
  }

  public static List<BigInteger> getDivisors(BigInteger checkNum) {
    List<BigInteger> divisors = new LinkedList<>();
    BigInteger sqrt = BigIntegerMath.sqrt(checkNum, RoundingMode.FLOOR);
    BigInteger potentialDivisor = BigInteger.ONE;
    while (potentialDivisor.compareTo(sqrt) <= 0) {
      if (isNaturalDivisor(checkNum, potentialDivisor)) {
        divisors.add(potentialDivisor);
        if (potentialDivisor.compareTo(sqrt) != 0) {
          BigInteger otherDivisor = BigIntegerMath.divide(checkNum, potentialDivisor, RoundingMode.UNNECESSARY);
          divisors.add(otherDivisor);
        }
      }
      potentialDivisor = potentialDivisor.add(BigInteger.ONE);
    }
    return divisors;
  }

  /**
   * @param base
   * @param exponent
   * @param mod
   * @return $base^$exponent mod $mod
   */
  public static BigInteger modularExponentiation(BigInteger base, BigInteger exponent, BigInteger mod) {
    //return basicModExp(base, exponent, mod);
    return guavaModExp(base, exponent, mod);
  }

  public static BigInteger basicModExp(BigInteger base, BigInteger exponent, BigInteger mod) {
    BigInteger answer = base;
    BigInteger timesToMultiply = exponent.subtract(BigInteger.ONE);
    BigInteger count = BigInteger.ZERO;
    while (count.compareTo(timesToMultiply) < 0) {
      answer = answer.multiply(base).mod(mod);
      count = count.add(BigInteger.ONE);
    }
    return answer;
  }

  public static BigInteger guavaModExp(BigInteger base, BigInteger exponent, BigInteger mod) {
    return base.modPow(exponent, mod);
  }


}
