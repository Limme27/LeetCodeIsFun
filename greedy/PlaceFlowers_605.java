package greedy;

public class PlaceFlowers_605 {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int len = flowerbed.length;
    int[] temp = new int[len+2];
    for (int i = 0; i < len; i++) {
      temp[i+1] = flowerbed[i];
    }

    for(int i = 1; i < temp.length - 1; i++) {
      if (temp[i-1] == 0 && temp[i] == 0 && temp[i+1] == 0) {
        temp[i] = 1;
        n--;
      }
    }
    return n <= 0 ? true : false;        
  }
}
