package com.caseykulm;

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
    assertTrue(MathUtils.isNaturalDivisor(4, 2));
    assertTrue(MathUtils.isNaturalDivisor(6, 3));
    assertTrue(MathUtils.isNaturalDivisor(333, 111));

    assertFalse(MathUtils.isNaturalDivisor(3, 2));
    assertFalse(MathUtils.isNaturalDivisor(13, 8));
    assertFalse(MathUtils.isNaturalDivisor(91969, 345));
  }

  @Test
  public void isPerfectPower() {
    assertTrue(MathUtils.isPerfectPower(4)); // 2^2
    assertTrue(MathUtils.isPerfectPower(8)); // 2^3
    assertTrue(MathUtils.isPerfectPower(9)); // 3^2
    assertTrue(MathUtils.isPerfectPower(121)); // 11^2
    assertTrue(MathUtils.isPerfectPower(1024)); // 2^10
    assertTrue(MathUtils.isPerfectPower(1764)); // 42^2
    assertTrue(MathUtils.isPerfectPower(1048576)); // 2^20
    assertTrue(MathUtils.isPerfectPower(1073741824)); // 2^30
    assertTrue(MathUtils.isPerfectPower(1099511627776d)); // 2^40
    assertTrue(MathUtils.isPerfectPower(2199023255552d)); // 2^41

    assertFalse(MathUtils.isPerfectPower(5));
    assertFalse(MathUtils.isPerfectPower(6));
    assertFalse(MathUtils.isPerfectPower(10));
    assertFalse(MathUtils.isPerfectPower(122));
    assertFalse(MathUtils.isPerfectPower(1025));
    assertFalse(MathUtils.isPerfectPower(1765));
    assertFalse(MathUtils.isPerfectPower(1048577));
    assertFalse(MathUtils.isPerfectPower(1073741825));
    assertFalse(MathUtils.isPerfectPower(1099511627777d));
    assertFalse(MathUtils.isPerfectPower(2199023255553d));
  }

  @Test
  public void testGetDivisors() {
    List<Double> expectedDivisors1764 = new LinkedList<>(Arrays.asList(
        1d, 2d, 3d, 4d, 6d, 7d, 9d, 12d, 14d, 18d,
        21d, 28d, 36d, 42d, 49d, 63d, 84d, 98d,
        126d, 147d, 196d, 252d, 294d, 441d, 588d,
        882d, 1764d
    ));
    testGetDivisors(1764d, expectedDivisors1764);

    List<Double> expectedDivisors98423098 = new LinkedList<>(Arrays.asList(
        1d, 2d, 17d, 34d, 79d, 158d, 1343d, 2686d,
        36643d, 73286d, 622931d, 1245862d, 2894797d,
        5789594d, 49211549d, 98423098d
    ));
    testGetDivisors(98423098, expectedDivisors98423098);
  }

  private void testGetDivisors(double checkNum, List<Double> expectedDivisors) {
    List<Double> actualDivisors = MathUtils.getDivisors(checkNum);
    Collections.sort(expectedDivisors);
    Collections.sort(actualDivisors);
    System.out.println("expected: " + expectedDivisors.toString());
    System.out.println("actual: \t" + actualDivisors.toString());
    assertEquals(expectedDivisors.size(), actualDivisors.size());
  }

}