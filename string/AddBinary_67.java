package string;

public class AddBinary_67 {
  public String addBinary(String a, String b) {
    StringBuilder s = new StringBuilder();
    
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int num1 = i >= 0 ? a.charAt(i) - '0' : 0;
      int num2 = j >= 0 ? b.charAt(j) - '0' : 0;
      
      int sum = num1 + num2 + carry;
      s.insert(0, sum % 2);
      carry = sum / 2;
      
      i--;
      j--;
    }
    if (carry != 0) s.insert(0, carry);

    return s.toString();
  }
  // #66 Plus One
  public int[] plusOne(int[] digits) {
    StringBuilder s = new StringBuilder();
    int carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      if (i == digits.length - 1) sum++;
      if (sum > 9) {
        s.insert(0, 0);
        carry = 1;
      }
      else {
        s.insert(0, sum);
        carry = 0;
      }
    }
    if (carry != 0) s.insert(0, carry);
    String ansStr = s.toString();
    int len = ansStr.length();
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) ans[i] = ansStr.charAt(i) - '0';
    return ans; 
  }
}
