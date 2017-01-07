package com.caseykulm.primality.deterministic;

import com.caseykulm.primality.PrimalityStrategyTest;
import org.junit.Test;

public class SimplePrimalityTest extends PrimalityStrategyTest {

  @Test
  public void isPrime() {
    SimplePrimality simplePrimality = new SimplePrimality();
    compareToFirstMillionPrimesDeterministic(simplePrimality);
  }

}