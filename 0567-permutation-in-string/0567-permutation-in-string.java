class Solution {

  boolean checkInclusion(String s1, String s2) {
    final int len1 = s1.length(), len2 = s2.length();
    // 윈도우의 크기가 비교 대상의 크기보다 크면 false 반환
    if (len1 > len2) {
      return false;
    }

    final int[] counts = new int[26];
    // i가 len1보다 작을 때
    for (int i = 0; i < len1; i++) {
      counts[s1.charAt(i) - 'a']++;
      counts[s2.charAt(i) - 'a']--;
    }
    if (checkAllZero(counts)) return true;

    // i가 len1보다 크거나 같을 때
    for (int i = len1; i < len2; i++) {
      counts[s2.charAt(i) - 'a']--;
      counts[s2.charAt(i - len1) - 'a']++;
      if (checkAllZero(counts)) return true;
    }

    return false;
  }
  

  /**
   * 모든 배열의 값이 0인지 확인한다.
   *
   * @param counts int[]
   * @return allZero
   */
  private boolean checkAllZero(final int[] counts) {
    for (int i = 0; i < 26; i++) {
      if (counts[i] != 0) return false;
    }
    return true;
  }
}