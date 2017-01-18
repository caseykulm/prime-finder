package com.caseykulm.primality.probabilistic;

import com.caseykulm.MathUtils;
import com.caseykulm.primality.PrimalityStrategy;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.util.Random;

public class FermatPrimality implements PrimalityStrategy {

  private BigInteger numTimesToCheck;
  private Random die;

  public FermatPrimality(BigInteger numTimesToCheck) {
    this.numTimesToCheck = numTimesToCheck;
    die = new Random();
  }

  @Override
  public boolean isPrime(BigInteger checkInt) {
    if (checkInt.compareTo(BigInteger.valueOf(2)) == 0) {
      return false;
    } else if (checkInt.compareTo(BigInteger.valueOf(4)) < 0) {
      return true;
    } else if (checkInt.compareTo(BigInteger.valueOf(4)) == 0) {
      return false;
    }

    BigInteger i = BigInteger.ZERO;
    while (i.compareTo(numTimesToCheck) < 0) {
      int random = 2 + die.nextInt(checkInt.subtract(BigInteger.valueOf(4)).intValue());
      BigInteger modularExponent = MathUtils.modularExponentiation(
          BigInteger.valueOf(random), checkInt.subtract(BigInteger.ONE), checkInt);

      if (modularExponent.compareTo(BigInteger.ONE) != 0) {
        return false; // definitely composite
      }
      i = i.add(BigInteger.ONE);
    }

    return true; // probably prime
  }

}
