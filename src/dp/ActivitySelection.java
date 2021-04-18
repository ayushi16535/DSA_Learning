package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Activity{
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start+" "+end;
    }
}
public class ActivitySelection {
    public static void main(String[] args) {
        List<Activity> list = (Arrays.asList(new Activity(1, 2), new Activity(3, 5), new Activity(0, 6), new Activity(5, 6), new Activity(3, 8), new Activity(5, 9), new Activity(6, 8), new Activity(8, 11), new Activity(8, 12), new Activity(10, 14), new Activity(10, 13)));
        Collections.sort(list,(a1,a2)->a1.start-a2.start);
        System.out.println(maxActivity(list));
    }

    private static int maxActivity(List<Activity> list) {
        int n=list.size();
        int count[] = new int[n];
        for (int i = 0; i < n; i++) {
            count[i]=0;
            int temp=0;
            for (int j = 0; j <i ; j++) {
                if(list.get(i).start >= list.get(j).end &&count[i]<count[j])
                {
                    count[i]=count[j];
                }
            }
            count[i] += 1;
        }
        list.forEach(System.out::println);
        Print.printArray(count);
        return count[n-1];
    }
}
