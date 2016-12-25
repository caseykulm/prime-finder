package com.caseykulm;

public class MathUtils {
  /**
   * @param checkInt Input natural number
   * @param otherInt Other natural number
   * @return true if checkInt / otherInt is a natural number
   */
  public static boolean isNaturalDivisor(int checkInt, int otherInt) {
    double checkDouble = 1.0 * checkInt;
    double resultDouble = checkDouble / otherInt;
    int intResult = checkInt / otherInt;
    double finalResult = resultDouble - intResult;
    return finalResult == 0;
  }

  public static boolean isPerfectPower(int checkInt) {
    return false;
  }
}
