public class QueueDemo {
    public static void main(String[] args) {
        Queue queue=new Queue();
        queue.enque(8);
        queue.enque(10);
        queue.enque(18);
        queue.enque(20);
        queue.enque(23);
        System.out.println(queue);
        queue.deque();
        queue.deque();
        System.out.println(queue);
    }
}
