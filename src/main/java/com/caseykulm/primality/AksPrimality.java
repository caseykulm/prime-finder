package com.caseykulm.primality;

import com.caseykulm.MathUtils;

import static com.caseykulm.MathUtils.isPerfectPower;

/**
 * https://en.wikipedia.org/wiki/AKS_primality_test
 */
public class AksPrimality implements PrimalityStrategy {

  public boolean isPrime(int checkInt) {
    /**
     * Step 1: Check if n is a perfect power:
     * if n = ab for integers a > 1 and b > 1,
     * output composite.
     */
    if (isPerfectPower(checkInt)) {
      return false;
    }

    /**
     * Step 2: Find the smallest r such that
     * ordr(n) > (log2 n)2. (if r and n are not
     * coprime, then skip this r)
     */

    /**
     * Step 3: For all 2 ≤ a ≤ min(r, n−1),
     * check that a does not divide n: If a|n
     * for some 2 ≤ a ≤ min(r, n−1), output
     * composite.
     */

    /**
     * Step 4: If n ≤ r, output prime.
     */

    /**
     * Step 5: For a = 2 to floor(sqrt(phi(r))) * log_2(n)) do
     * if (X+a)^n != X^n+a * (mod X^r − 1,n), output composite
     */

    /**
     * Step 6: Else output prime
     */
    return true;
  }
}
