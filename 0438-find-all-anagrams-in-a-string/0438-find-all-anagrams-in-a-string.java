class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    // 반환 객체 생성
    final List<Integer> indexes = new LinkedList<>();
    final int sLen = s.length(), pLen = p.length();
    // 윈도우의 크기가 비교 대상의 크기보다 크면 Empty List 반환
    if (pLen > sLen) {
      return indexes;
    }

    // 정답셋 생성
    final int[] source = new int[26];
    for (int i = 0; i < pLen; i++) {
      source[p.charAt(i) - 'a']++;
    }

    // length는 1부터 index는 0부터 시작이기 때문에 (len2 - len1)이 아닌 (len2 - len1 + 1)로 처리한다.
    // 해당 조건은 별도로 계산하면 for문은 깔끔해지나, 코드의 양이 더 늘기 때문에 아래와 같이 처리한다.
    for (int i = 0; i < sLen - pLen + 1; i++) {
      final int[] target = new int[26];
      for (int j = 0; j < pLen; j++) {
        target[s.charAt(i + j) - 'a']++;
      }
      if (checksArrayEqualization(source, target)) {
        indexes.add(i);
      }
    }

    return indexes;
  }

  /**
   * 두 int 배열이 동일한지 확인한다.
   *
   * @param source source
   * @param target target
   * @return boolean
   */
  private boolean checksArrayEqualization(final int[] source, final int[] target) {
    // 길이가 다를 경우 같지 않다고 판단한다.
    if (source.length - target.length != 0) {
      return false;
    }
    for (int i = 0; i < source.length; i++) {
      if (source[i] != target[i]) {
        return false;
      }
    }
    return true;
  }
}