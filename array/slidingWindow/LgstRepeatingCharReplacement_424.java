package array.slidingWindow;

// 1004 -> 2024 -> 424
public class LgstRepeatingCharReplacement_424 {
  public int characterReplacement(String s, int k) {
		char[] arr = s.toCharArray();

    int maxLen = 0;
    for (char c = 'A'; c <= 'Z'; c++) {
      int r = 0;
      int numFlipLeft = k;
      for (int l = 0; l < arr.length; l++) {
        while (r < arr.length && (arr[r] == c || numFlipLeft > 0)) {
          if (arr[r] != c) numFlipLeft--;
          r++;
        }
        maxLen = Math.max(maxLen, r - l);
        if (arr[l] != c) numFlipLeft++;
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    LgstRepeatingCharReplacement_424 l = new LgstRepeatingCharReplacement_424();
    System.out.println(l.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF",
    4));    
  }
}
