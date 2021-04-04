class DoubleNode{
    int data;
    DoubleNode nextNode;
    DoubleNode prevNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(DoubleNode prevNode) {
        this.prevNode = prevNode;
    }

    DoubleNode(int data){
        this.data=data;
    }

    @Override
    public String toString() {
        return "data=" + data+",";
    }
}
public class DoublyLinkedList {
    DoubleNode head;
    public void insertAtHead(int value){
        DoubleNode node = new DoubleNode(value);
        if(head==null){
            head=node;
        }
        else {
            head.setPrevNode(node);
            node.setNextNode(this.head);
            this.head = node;
        }
    }

    @Override
    public String toString() {
        String list="{";
        DoubleNode current=this.head;
        while (current!=null){
            list+=current;
            current=current.getNextNode();
        }
        list+="}";
        return list;
    }
}
