package com.caseykulm.primality;

import org.junit.Test;

public class SimplePrimalityTest extends PrimalityStrategyTest {

  @Test
  public void isPrime() {
    SimplePrimality simplePrimality = new SimplePrimality();
    compareToFirstMillionPrimes(simplePrimality);
  }

}