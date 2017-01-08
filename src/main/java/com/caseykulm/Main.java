package com.caseykulm;

import com.caseykulm.primality.PrimalityStrategy;
import com.caseykulm.primality.deterministic.SimplePrimality;
import com.caseykulm.primality.probabilistic.FermatPrimality;
import java.math.BigInteger;

import static com.caseykulm.Utils.basicPrintPrimesToLimit;
import static com.caseykulm.Utils.logTime;

public class Main {

  public static void main(String[] args) {
    //BigInteger limit = BigInteger.valueOf(10000000);
    PrimalityStrategy strategy = new FermatPrimality(BigInteger.valueOf(100));
    long timeStart = System.currentTimeMillis();
    //basicPrintPrimesToLimit(strategy, limit);
    strategy.isPrime(BigInteger.valueOf(14161487));
    long timeEnd = System.currentTimeMillis();
    logTime(timeStart, timeEnd);
  }

}
