package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProfitJobScheduling_1235 {
    public static class Job implements Comparable {
        private int startTime;
        private int endTime;
        private int profit;
        
        public Job(int startTime, int endTime, int profit) {
          this.startTime = startTime;
          this.endTime = endTime;
          this.profit = profit;
        }
    
        @Override
        public int compareTo(Object o) {
          return this.endTime > ((Job)o).endTime ? 1 : -1;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < len; i++) {
          jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
  
        Collections.sort(jobs);
        
        List<Integer> dp = new ArrayList<Integer>(Collections.nCopies(len, 0));
        dp.set(0, jobs.get(0).profit);
        for (int i = 1; i < len; i++) {
          dp.set(i, Math.max(jobs.get(i).profit, dp.get(i - 1)));
          for (int j = i - 1; j >= 0; j--) {
            if (jobs.get(j).endTime <= jobs.get(i).startTime) {
              dp.set(i, Math.max(dp.get(i), dp.get(j) + jobs.get(i).profit));
              break;
            }
          }
        }
          
        return Collections.max(dp);
    }    
}
