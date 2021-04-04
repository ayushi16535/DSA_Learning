class TreeNode{
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data){
        this.data=data;
        this.leftChild=null;
        this.rightChild=null;
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        create();
    }
    public static  void  create(){
        TreeNode root=new TreeNode(4);
        root.leftChild=new TreeNode(1);
        root.rightChild=new TreeNode(5);
        root.leftChild.leftChild=new TreeNode(0);
        System.out.println(root.leftChild.leftChild.data);
    }
}
