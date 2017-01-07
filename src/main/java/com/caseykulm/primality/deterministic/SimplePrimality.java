package com.caseykulm.primality.deterministic;

import com.caseykulm.primality.PrimalityStrategy;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;

import static com.caseykulm.MathUtils.isNaturalDivisor;

/**
 * https://en.wikipedia.org/wiki/Primality_test#Simple_methods
 */
public class SimplePrimality implements PrimalityStrategy {

  @Override
  public boolean isPrime(BigInteger checkInt) {
    if (checkInt.compareTo(BigInteger.ONE) <= 0) {
      return false;
    } else if (checkInt.compareTo(BigInteger.valueOf(3)) <= 0) {
      return true;
    } else if (checkInt.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0
        || checkInt.mod(BigInteger.valueOf(3)).compareTo(BigInteger.ZERO) == 0) {
      return false;
    } else {
      BigInteger i = BigInteger.valueOf(3);
      while (i.compareTo(BigIntegerMath.sqrt(checkInt, RoundingMode.FLOOR)) <= 0) {
        if (isNaturalDivisor(checkInt, i)) {
          return false;
        }
        i = i.add(BigInteger.valueOf(2));
      }
      return true;
    }
  }

}
