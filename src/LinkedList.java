class Node
{
    int data;
    Node nextNode;

    Node(int data){
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "data=" + data;
    }
}
public class LinkedList<I extends Number> {

    private Node head;

    public void addNodeAtHead(int n){
        Node newNode=new Node(n);
        newNode.setNextNode(this.head);
        this.head=newNode;
    }

    public int getLength(){
        Node current=this.head;
        int length=0;
        while(current!=null){
            length+=1;
            current=current.getNextNode();
        }
        return length;
    }

    public void deleteHead(){
        Node current=this.head;
        if(current!=null){
            this.head=current.getNextNode();
        }
    }

    public int search(int value){
        int pos=0;
        Node current=this.head;
        while (current!=null){
            pos++;
            if(current.getData()==value)
            {
                break;
            }
            current=current.getNextNode();
        }
        if(current==null)
            pos=-1;
        return pos;
    }

    public void insertInSorted(int data){
        Node current=this.head;
        Node prev=current;
        while (current!=null) {
            if(current.getData()<data){
                System.out.println(current.getData());
                Node newNode= new Node(data);
                prev.setNextNode(newNode);
                newNode.setNextNode(current);
                break;
            }
            prev=current;
            current=current.getNextNode();
        }
        }

    @Override
    public String toString() {
        String list="{";
        Node current=this.head;
        while(current!=null){
            list+=current.toString()+",";
            current=current.getNextNode();
        }
        list+="}";
        return list;
    }
}


