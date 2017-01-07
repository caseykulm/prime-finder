package com.caseykulm.primality;

import java.math.BigInteger;

/**
 * Interface following strategy pattern:
 * https://sourcemaking.com/design_patterns/strategy
 * defining a strategy that determines whether
 * an input number is prime or not
 */
public interface PrimalityStrategy {
  /**
   * @param checkInt Number to analyze
   * @return true if prime, false if composite
   */
  boolean isPrime(BigInteger checkInt);
}
