package com.caseykulm.primality.deterministic;

import com.caseykulm.primality.PrimalityStrategy;
import java.math.BigInteger;

import static com.caseykulm.MathUtils.isPerfectPower;

/**
 * https://en.wikipedia.org/wiki/AKS_primality_test
 */
public class AksPrimality implements PrimalityStrategy {

  public boolean isPrime(BigInteger checkInt) {
    /**
     * Step 1: Check if n is a perfect power:
     * if n = a^b for integers a > 1 and b > 1,
     * output composite.
     */
    if (isPerfectPower(checkInt)) {
      return false;
    }

    /**
     * Step 2: Find the smallest r such that
     * ord_r(n) > (log2 n)2. (if r and n are not
     * coprime, then skip this r)
     *
     * n^k = 1 (mod r)
     *
     * k=1 to 10000
     * if (n^k + 1) % r == 1
     *   if (r and n are not co prime)
     *     skip this r
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
