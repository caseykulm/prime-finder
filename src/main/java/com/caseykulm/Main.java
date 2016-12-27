package com.caseykulm;

import com.caseykulm.primality.PrimalityStrategy;
import com.caseykulm.primality.SimplePrimality;

import static com.caseykulm.Utils.basicPrintPrimesToLimit;
import static com.caseykulm.Utils.logTime;

public class Main {

  public static void main(String[] args) {
    int limit = 100000000;
    PrimalityStrategy strategy = new SimplePrimality();
    long timeStart = System.currentTimeMillis();
    basicPrintPrimesToLimit(strategy, limit);
    long timeEnd = System.currentTimeMillis();
    logTime(timeStart, timeEnd);
  }

}
