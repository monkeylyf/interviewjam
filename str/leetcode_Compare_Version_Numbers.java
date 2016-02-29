/**
 * leetcode_Compare_Version_Numbers.
 *
 * Compare two version numbers version1 and version1.
 * If version1 is larger than  version2 return 1, if version1 is smaller than
 * version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits
 * and the '.' character.
 * The '.' character does not represent a decimal point and is used to separate
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37
 */


public class leetcode_Compare_Version_Numbers {

  public static void main(String[] args) {
    leetcode_Compare_Version_Numbers solution = new leetcode_Compare_Version_Numbers();
    solution.test();
  }

  public void test() {
    System.out.println(compareVersion("1.2", "1.13") == -1);
    System.out.println(compareVersion("0.1", "1.1") == -1);
    System.out.println(compareVersion("1.1", "1.2") == -1);
    System.out.println(compareVersion("1.2", "13.37") == -1);
    System.out.println(compareVersion("1.2.1", "1.2") == 1);
    System.out.println(compareVersion("1.0", "1") == 0);
  }

  public int compareVersion(String version1, String version2) {
    if (version1.equals(version2)) {
      return 0;
    }

    String[] splittedVersion1 = version1.split("\\.");
    String[] splittedVersion2 = version2.split("\\.");

    int i = 0;
    while (i < splittedVersion1.length && i < splittedVersion2.length) {
      int subVersion1 = Integer.parseInt(splittedVersion1[i]);
      int subVersion2 = Integer.parseInt(splittedVersion2[i]);

      if (subVersion1 > subVersion2) {
        return 1;
      }

      if (subVersion1 < subVersion2) {
        return -1;
      }

      i += 1;
    }

    if (i < splittedVersion1.length) {
      if (restAreAllZeros(splittedVersion1, i)) {
        return 0;
      } else {
        return 1;
      }
    }

    if (i < splittedVersion2.length) {
      if (restAreAllZeros(splittedVersion2, i)) {
        return 0;
      } else {
        return -1;
      }
    }

    return 0;
  }

  private boolean restAreAllZeros(String[] splittedVersion, int i) {
    for (; i < splittedVersion.length; ++i) {
      int subVersion = Integer.parseInt(splittedVersion[i]);
      if (subVersion != 0) {
        return false;
      }
    }

    return true;
  }
}
