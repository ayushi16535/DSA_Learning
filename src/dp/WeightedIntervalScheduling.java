//https://www.techiedelight.com/weighted-interval-scheduling-problem-using-lis/
package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Job{
    int startTime;
    int endTime;
    int profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return startTime+" "+endTime+" "+profit;
    }
}

public class WeightedIntervalScheduling {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job( 0, 6, 60 ),
                new Job( 5, 9, 50 ),
                new Job( 1, 4, 30 ),
                new Job( 5, 7, 30 ),
                new Job( 3, 5, 10 ),
                new Job( 7, 8, 10 )
        );
        System.out.println(maxProfit(jobs));
    }

    private static int maxProfit(List<Job> jobs) {
        Collections.sort(jobs,(j1,j2)->j1.startTime-j2.startTime);

        int n=jobs.size();
        int maxProfit[]=new int[n];
        for (int i = 0 ; i < n ; i++) {
            maxProfit[i]=0;
            for (int j = 0 ; j < i ; j++) {
                if(jobs.get(j).endTime <= jobs.get(i).startTime && maxProfit[i]<maxProfit[j])
                    maxProfit[i]=maxProfit[j];
            }
            maxProfit[i] += jobs.get(i).profit;
        }
        return Arrays.stream(maxProfit).max().getAsInt();
    }
}
