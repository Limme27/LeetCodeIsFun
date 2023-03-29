package string;

public class ShiftVowelToTheNext {
  String solution(String message) {
    StringBuilder sb = new StringBuilder();
    StringBuilder ans = new StringBuilder();
    for (char c : message.toCharArray()) if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') sb.append(c);
    int len = message.length();
    boolean isFirst = true;
    for (int i = 0; i < len; i++) {
      char a = message.charAt(i);
      if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
        if (isFirst) {
          isFirst = false;
          ans.append(a);
          continue;
        }
        a = sb.charAt(0);
        sb.deleteCharAt(0);
      }
      ans.append(a);
    }
    return ans.toString().replaceFirst("[aeiou]", sb.toString());
  }
}
