package com.caseykulm;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MathUtilsTest {

  @Test
  public void isNaturalDivisor() {
    assertTrue(MathUtils.isNaturalDivisor(BigInteger.valueOf(4), BigInteger.valueOf(2)));
    assertTrue(MathUtils.isNaturalDivisor(BigInteger.valueOf(6), BigInteger.valueOf(3)));
    assertTrue(MathUtils.isNaturalDivisor(BigInteger.valueOf(333), BigInteger.valueOf(111)));
    assertTrue(MathUtils.isNaturalDivisor(BigInteger.valueOf(2199023255552l), BigInteger.ONE));

    assertFalse(MathUtils.isNaturalDivisor(BigInteger.valueOf(3), BigInteger.valueOf(2)));
    assertFalse(MathUtils.isNaturalDivisor(BigInteger.valueOf(13), BigInteger.valueOf(8)));
    assertFalse(MathUtils.isNaturalDivisor(BigInteger.valueOf(91969), BigInteger.valueOf(345)));
  }

  @Test
  public void isPerfectPower() {
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(4))); // 2^2
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(8))); // 2^3
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(9))); // 3^2
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(121))); // 11^2
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(1024))); // 2^10
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(1764))); // 42^2
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(1048576))); // 2^20
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(1073741824))); // 2^30
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(1099511627776l))); // 2^40
    assertTrue(MathUtils.isPerfectPower(BigInteger.valueOf(2199023255552l))); // 2^41

    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(5)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(6)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(10)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(122)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(1025)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(1765)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(1048577)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(1073741825)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(1099511627777l)));
    assertFalse(MathUtils.isPerfectPower(BigInteger.valueOf(2199023255553l)));
  }

  @Test
  public void testGetDivisors() {
    List<BigInteger> expectedDivisors1764 = new LinkedList<>(Arrays.asList(
        BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(6), BigInteger.valueOf(7), BigInteger.valueOf(9), BigInteger.valueOf(12), BigInteger.valueOf(14), BigInteger.valueOf(18),
        BigInteger.valueOf(21), BigInteger.valueOf(28), BigInteger.valueOf(36), BigInteger.valueOf(42), BigInteger.valueOf(49), BigInteger.valueOf(63), BigInteger.valueOf(84), BigInteger.valueOf(98),
        BigInteger.valueOf(126), BigInteger.valueOf(147), BigInteger.valueOf(196), BigInteger.valueOf(252), BigInteger.valueOf(294), BigInteger.valueOf(441), BigInteger.valueOf(588),
        BigInteger.valueOf(882), BigInteger.valueOf(1764)
    ));
    testGetDivisors(BigInteger.valueOf(1764), expectedDivisors1764);

    List<BigInteger> expectedDivisors98423098 = new LinkedList<>(Arrays.asList(
        BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(17), BigInteger.valueOf(34), BigInteger.valueOf(79), BigInteger.valueOf(158), BigInteger.valueOf(1343), BigInteger.valueOf(2686),
        BigInteger.valueOf(36643), BigInteger.valueOf(73286), BigInteger.valueOf(622931), BigInteger.valueOf(1245862), BigInteger.valueOf(2894797),
        BigInteger.valueOf(5789594), BigInteger.valueOf(49211549), BigInteger.valueOf(98423098)
    ));
    testGetDivisors(BigInteger.valueOf(98423098), expectedDivisors98423098);

    List<BigInteger> expectedDivisors2199023255552 = new LinkedList<>(Arrays.asList(
        BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(8), BigInteger.valueOf(16), BigInteger.valueOf(32), BigInteger.valueOf(64), BigInteger.valueOf(128), BigInteger.valueOf(256),
        BigInteger.valueOf(512), BigInteger.valueOf(1024), BigInteger.valueOf(2048), BigInteger.valueOf(4096), BigInteger.valueOf(8192), BigInteger.valueOf(16384),
        BigInteger.valueOf(32768), BigInteger.valueOf(65536), BigInteger.valueOf(131072), BigInteger.valueOf(262144), BigInteger.valueOf(524288),
        BigInteger.valueOf(1048576), BigInteger.valueOf(2097152), BigInteger.valueOf(4194304), BigInteger.valueOf(8388608),
        BigInteger.valueOf(16777216), BigInteger.valueOf(33554432), BigInteger.valueOf(67108864), BigInteger.valueOf(134217728),
        BigInteger.valueOf(268435456), BigInteger.valueOf(536870912), BigInteger.valueOf(1073741824),
        BigInteger.valueOf(2147483648l), BigInteger.valueOf(4294967296l), BigInteger.valueOf(8589934592l),
        BigInteger.valueOf(17179869184l), BigInteger.valueOf(34359738368l), BigInteger.valueOf(68719476736l),
        BigInteger.valueOf(137438953472l), BigInteger.valueOf(274877906944l), BigInteger.valueOf(549755813888l),
        BigInteger.valueOf(1099511627776l), BigInteger.valueOf(2199023255552l)
    ));
    testGetDivisors(BigInteger.valueOf(2199023255552l), expectedDivisors2199023255552);
  }

  private void testGetDivisors(BigInteger checkNum, List<BigInteger> expectedDivisors) {
    List<BigInteger> actualDivisors = MathUtils.getDivisors(checkNum);
    Collections.sort(expectedDivisors);
    Collections.sort(actualDivisors);
    System.out.println("expected: " + expectedDivisors.toString());
    System.out.println("actual: \t" + actualDivisors.toString());
    assertEquals(expectedDivisors.size(), actualDivisors.size());
  }

}