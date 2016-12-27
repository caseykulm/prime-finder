package com.caseykulm;

import org.junit.Test;

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

  }

}