package com.caseykulm;

import com.caseykulm.primality.PrimalityStrategy;
import com.caseykulm.primality.SimplePrimality;

public class Main {

  public static void main(String[] args) {
    int limit = 100000000;
    PrimalityStrategy strategy = new SimplePrimality();
    long timeStart = System.currentTimeMillis();
    Utils.basicPrintPrimesToLimit(strategy, limit);
    long timeEnd = System.currentTimeMillis();
    Utils.logTime(timeStart, timeEnd);
  }

}
