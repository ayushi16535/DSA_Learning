public class LinkedListDemo
{
    public static void main(String[] args)
    {
        LinkedList<Number> list=new LinkedList<Number>();
        list.addNodeAtHead(5);
        list.addNodeAtHead(10);
        list.addNodeAtHead(15);
        list.addNodeAtHead(20);
        list.addNodeAtHead(25);

        System.out.println(list.toString()+"\n"+"length = "+list.getLength());
        list.deleteHead();
        System.out.println("Length after deleting : "+list.getLength());
        System.out.println("Found at : "+list.search(20));
        list.insertInSorted(17);
        System.out.println(list.toString());
    }
}
