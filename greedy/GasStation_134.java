package greedy;

public class GasStation_134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int len = cost.length;
    for (int i = 0; i < len; i++) {
      int tank = 0;
      int j = i;
      while (tank + gas[j] - cost[j] >= 0) {
        tank = tank + gas[j] - cost[j];
        j = (j + 1) % len;
        if (j == i) return j;
      }
      if (j < i) return -1;
      i = j;
    }
    return -1;
  }
}
