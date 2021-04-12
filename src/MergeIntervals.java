//https://www.interviewbit.com/problems/merge-intervals/

import java.util.ArrayList;
public class MergeIntervals {

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
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }

        int i=0;
        while(i<intervals.size())
        {
            Interval current=intervals.get(i);
            if(current.end<newInterval.start)
            {
                i++;
                continue;

            }
            else if(current.start>newInterval.end){
                intervals.add(i,newInterval);
                break;
            }
            else{
                newInterval.start=Math.min(current.start,newInterval.start);
                newInterval.end=Math.max(current.end,newInterval.end);
                intervals.remove(i);
            }
        }
        if(i==intervals.size())
            intervals.add(newInterval);
        return intervals;
    }
    public static void main(String[] args) {

        //intervals are sorted by default on basis of start time

        ArrayList<Interval> intervals=new ArrayList<Interval>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));


        insert(intervals,new Interval(4,9));

        for (Interval interval : intervals
        ) {
            System.out.println(interval);

        }
    }
}
