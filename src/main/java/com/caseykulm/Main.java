package com.caseykulm;

import com.caseykulm.primality.PrimalityStrategy;
import com.caseykulm.primality.deterministic.SimplePrimality;
import com.caseykulm.primality.probabilistic.FermatPrimality;
import java.math.BigInteger;

import static com.caseykulm.Utils.basicPrintPrimesToLimit;
import static com.caseykulm.Utils.logTime;

public class Main {

  public static void main(String[] args) {
    PrimalityStrategy strategy = new FermatPrimality(BigInteger.valueOf(10));
    runUpTo(BigInteger.valueOf(1000), strategy);
    runUpTo(BigInteger.valueOf(10000), strategy);
    runUpTo(BigInteger.valueOf(100000), strategy);
    runUpTo(BigInteger.valueOf(1000000), strategy);
    runUpTo(BigInteger.valueOf(10000000), strategy);
    runUpTo(BigInteger.valueOf(100000000), strategy);
  }

  private static void runUpTo(BigInteger limit, PrimalityStrategy strategy) {
    System.out.println("Test for limit: " + limit.toString());
    long timeStart = System.currentTimeMillis();
    basicPrintPrimesToLimit(strategy, limit);
    long timeEnd = System.currentTimeMillis();
    logTime(timeStart, timeEnd);
    System.out.println();
  }

}
