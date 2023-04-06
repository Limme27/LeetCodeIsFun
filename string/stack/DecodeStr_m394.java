package string.stack;

import java.util.*;

public class DecodeStr_m394 {
  public static String decodeString(String s) {
    Stack<String> words = new Stack<>();
    Stack<Integer> nums = new Stack<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char curr = s.charAt(i);
      if (Character.isDigit(curr)) {
        String num = ""+curr;
        int j = i+1;
        while (Character.isDigit(s.charAt(j))) {
          num += s.charAt(j);
          j++;
        }
        nums.push(Integer.parseInt(num));
        i = j-1;
      } else if (curr == ']') {
        String word = "";
        while (!words.peek().equals("[")) word = words.pop() + word;
        words.pop(); // pop '[' from words
        int repet = nums.pop();
        for (int multi = 0; multi < repet; multi++) words.push(word);
      } else {
        words.push(Character.toString(curr));
      }
    }
    String ans = "";
    while (!words.empty()) ans = words.pop() + ans;
    return ans;
  }
  public static void main(String[] args) {
    System.out.println(decodeString("3[a]2[bc]"));
    System.out.println(decodeString("ab"));

  }
}
