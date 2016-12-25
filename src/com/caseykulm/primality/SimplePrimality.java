package com.caseykulm.primality;

import static com.caseykulm.MathUtils.isNaturalDivisor;

/**
 * https://en.wikipedia.org/wiki/Primality_test#Simple_methods
 */
public class SimplePrimality implements PrimalityStrategy {

  @Override
  public boolean isPrime(int checkInt) {
    if (checkInt<=1) {
      return false;
    } else if (checkInt <= 3) {
      return true;
    } else if (checkInt % 2 == 0 || checkInt % 3 == 0) {
      return false;
    } else {
      for (int i=3; i<=Math.sqrt(checkInt); i+=2) {
        if (isNaturalDivisor(checkInt, i)) {
          return false;
        }
      }
      return true;
    }
  }

}
