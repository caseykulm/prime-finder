package com.caseykulm.primality;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public abstract class PrimalityStrategyTest {

  private static final String FIRST_MILLION_PRIMES_FILE = "src/test/resources/primes_first_million.json";
  private static final int FIRST_PRIME = 2;
  private static final int MILLIONTH_PRIME = 15485863;
  private static final int AMOUNT_PRIMES_UP_TO_1_MILLION = 78498;
  private static final int AMOUNT_COMPOSITES_UP_TO_1_MILLION = 1000000 - AMOUNT_PRIMES_UP_TO_1_MILLION;
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

  protected void compareToFirstMillionPrimesDeterministic(PrimalityStrategy primalityStrategy) {
    int numPrimesSeen = 0;
    BigInteger potentialPrime = BigInteger.valueOf(FIRST_PRIME);
    while (potentialPrime.compareTo(BigInteger.valueOf(MILLIONTH_PRIME)) <= 0) {
      if (primalityStrategy.isPrime(potentialPrime)) {
        BigInteger expectedNextPrime = BigInteger.valueOf(firstMillionPrimes.primes.get(numPrimesSeen));
        BigInteger reportedNextPrime = potentialPrime;
        assertEquals(expectedNextPrime, reportedNextPrime);
        numPrimesSeen++;
      }
      potentialPrime = potentialPrime.add(BigInteger.ONE);
    }
    assertEquals(1000000, numPrimesSeen);
  }

  protected void compareToFirstMillionPrimesProbabilistic(PrimalityStrategy primalityStrategy) {
    int correctPrimeCount = 0;
    int incorrectPrimeCount = 0;
    int correctCompositeCount = 0;
    int incorrectCompositeCount = 0;
    BigInteger potentialPrime = BigInteger.valueOf(FIRST_PRIME);
    while (potentialPrime.compareTo(BigInteger.valueOf(MILLIONTH_PRIME)) <= 0) {
      boolean actuallyIsPrime = firstMillionPrimes.primes.contains(potentialPrime.intValue());
      boolean guessedPrime = primalityStrategy.isPrime(potentialPrime);

      if (guessedPrime && actuallyIsPrime) { // correct that it's prime
        correctPrimeCount++;
      }

      if (guessedPrime && !actuallyIsPrime) { // incorrect that it's prime
        incorrectPrimeCount++;
        System.out.println("false prime: " + potentialPrime);
      }

      if (!guessedPrime && actuallyIsPrime) { // incorrect that it's composite
        incorrectCompositeCount++;
        System.out.println("false composite: " + potentialPrime);
      }

      if (!guessedPrime && !actuallyIsPrime) { // correct that it's composite
        correctCompositeCount++;
      }
      potentialPrime = potentialPrime.add(BigInteger.ONE);
    }

    float correctPrimePercentage = (1f * correctPrimeCount) / 25 * 100;
    float correctCompositePercentage = (1f * correctCompositeCount) / 75 * 100;
    System.out.println("Correct Primes Percentage: " + correctPrimePercentage);
    System.out.println("Correct Composite Percentage: " + correctCompositePercentage);
    System.out.println("Incorrect number primes: " + incorrectPrimeCount);
    System.out.println("Incorrect number composites: " + incorrectCompositeCount);
  }

}