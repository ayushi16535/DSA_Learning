import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

    public static void sortbyColumn(int arr[][], int col)
    {
    Arrays.sort(arr, new Comparator<int[]>() {

        @Override
        // Compare values according to columns
        public int compare(final int[] entry1,
        final int[] entry2) {

            // To sort in descending order revert
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        }
    });  // End of function call sort().
    }

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return start+" "+end;
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new sortByStartTime());
        if(intervals.size()<2)
            return intervals;
        int i=1;
        while(i<intervals.size()){
            Interval current=intervals.get(i);
            if(current.start<=intervals.get(i-1).end){
                intervals.get(i-1).start=Math.min(current.start,intervals.get(i-1).start);
                intervals.get(i-1).end=Math.max(current.end,intervals.get(i-1).end);
                intervals.remove(i);
            }
            else
                i++;
        }
        return intervals;
    }

    public static void main(String[] args) {
//        int a[][]={{1,3},{2,6},{15,18},{8,10}};
//        sortbyColumn(a,0);
//        Print.print2DArray(a);

        ArrayList<Interval> intervals=new ArrayList<Interval>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(9,18));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,15));
        intervals.add(new Interval(18,18));
        merge(intervals);


        for (Interval interval : intervals
             ) {
            System.out.println(interval);

        }
    }

     static class sortByStartTime implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
}
