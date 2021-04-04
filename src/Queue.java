import java.util.Arrays;

public class Queue {
    int a[]=new int[4];
    int head=-1;
    int tail=-1;
    public void enque(int data){
        if(head==-1){
            head++;
        }
        if(tail==a.length-1){
            System.out.println("Queue is full");
            return;
        }
        a[++tail]=data;
        System.out.println(data+ " added");
    }
    public void deque(){
        if(head==-1){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(a[head]+" deleted");
        head++;
    }

    @Override
    public String toString() {
        String Queue="";
        for (int i=head;i<=tail;i++)
            Queue+=a[i]+", ";
        return Queue;
    }
}
