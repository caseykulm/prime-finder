package com.caseykulm.primality;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public abstract class PrimalityStrategyTest {

  private static final String FIRST_MILLION_PRIMES_FILE = "src/test/resources/primes_first_million.json";
  private static final int FIRST_PRIME = 2;
  private static final int MILLIONTH_PRIME = 15485863;
  private static PrimeList firstMillionPrimes;

  @BeforeClass
  public static void classSetup() {
    Gson gson = new Gson();
    try {
      FileReader fileReader = new FileReader(FIRST_MILLION_PRIMES_FILE);
      firstMillionPrimes = gson.fromJson(fileReader, PrimeList.class);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  protected void compareToFirstMillionPrimes(PrimalityStrategy primalityStrategy) {
    int numPrimesSeen = 0;
    for (int potentialPrime=FIRST_PRIME; potentialPrime<=MILLIONTH_PRIME; potentialPrime++) {
      if (primalityStrategy.isPrime(potentialPrime)) {
        int expectedNextPrime = firstMillionPrimes.primes.get(numPrimesSeen);
        int reportedNextPrime = potentialPrime;
        assertEquals(expectedNextPrime, reportedNextPrime);
        numPrimesSeen++;
      }
    }
    assertEquals(1000000, numPrimesSeen);
  }

}