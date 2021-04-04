public class StackDemo {
    public static void main(String[] args) {
        int a[]=new int[4];
        Stack stack=new Stack(a);
        stack.push(1);
        stack.push(5);
        stack.push(10);
        stack.peek();
        stack.push(15);
        stack.push(20);
        stack.print();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.print();
    }
}

