package string;

public class ValidPalindrome3_e680 {
  public static boolean validPalindrome(String s) {
    for (int i = 0, j = s.length()-1; i < j ; i++, j--) {
      if (s.charAt(i) != s.charAt(j))
        return isPal(s.substring(i+1, j+1)) || isPal(s.substring(i, j));  
    }
    return true;  
  }
  public static boolean isPal(String s) {
    for (int i = 0, j = s.length()-1; i < j ; i++, j--) 
      if (s.charAt(i) != s.charAt(j)) return false;
    return true; 
  }
  public static void main(String[] args) {
    String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
    System.out.println(validPalindrome(s));
  }
}
