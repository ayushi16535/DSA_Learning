public class Stack {
    public int top=-1;
    int a[]=new int[4];
    Stack(int a[]){
        this.a=a;
    }
    public void push(int data){
        if(this.top<this.a.length-1){
            this.top++;
            this.a[top]=data;
            System.out.println(data+" added");
        }
        else{
            System.out.println("Stack Overflow, cannot add "+data);
        }
    }

    public void print() {
        System.out.println("Stack is : ");
        int temp=this.top;
        while (temp!=-1){
            System.out.println("\t"+this.a[temp--]);
        }
    }

    public void pop() {
        if(this.top==-1){
            System.out.println("Stack Underflow");
        }
        else
        {
            System.out.println(this.a[top]+" deleted");
            this.top--;
        }
    }
    public void peek(){
        if(this.top==-1){
            System.out.println("Stack Underflow");
        }
        else
        {
            System.out.println(this.a[top]+" is on Top");
        }
    }
}
