package array.slidingWindow;

// 1004 -> 2024 -> 424
public class MaxConfusionOfAnExam_2024 {
  public int maxConsecutiveAnswers(String answerKey, int k) {
    char[] arr = answerKey.toCharArray();
    int maxLen = 0;
    
    int r = 0;
    int numFlipLeft = k;
    for (int l = 0; l < arr.length; l++) {
      while (r < arr.length && (arr[r] == 'T' || numFlipLeft > 0)) {
        if (arr[r] != 'T') numFlipLeft--;
        r++;
      }
      maxLen = Math.max(maxLen, r - l);
      if (arr[l] != 'T') numFlipLeft++;
    }
    
    r = 0;
    numFlipLeft = k;
    for (int l = 0; l < arr.length; l++) {
      while (r < arr.length && (arr[r] == 'F' || numFlipLeft > 0)) {
        if (arr[r] != 'F') numFlipLeft--;
        r++;
      }
      maxLen = Math.max(maxLen, r - l);
      if (arr[l] != 'F') numFlipLeft++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    MaxConfusionOfAnExam_2024 m = new MaxConfusionOfAnExam_2024();
    System.out.println(m.maxConsecutiveAnswers("TFFT", 1));
  }
}
