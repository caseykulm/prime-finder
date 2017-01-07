package com.caseykulm.primality.probabilistic;

import com.caseykulm.primality.PrimalityStrategyTest;
import java.math.BigInteger;
import org.junit.Test;

public class FermatPrimalityTest extends PrimalityStrategyTest {

  @Test
  public void isPrime() {
    FermatPrimality fermatPrimality = new FermatPrimality(BigInteger.valueOf(1000));
    compareToFirstMillionPrimesProbabilistic(fermatPrimality);
  }
}