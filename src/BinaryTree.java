import java.util.Scanner;

class TreeNode{
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data){
        this.data=data;
    }
}
public class BinaryTree {
    static Scanner sc;
    public static void main(String[] args) {
        sc= new Scanner(System.in);
        TreeNode root= create();
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }

    private static void postorder(TreeNode root) {
        //Left Right Root
        if(root!=null){
            postorder(root.leftChild);
            postorder(root.rightChild);
            System.out.print(root.data+" ");
        }
    }

    private static void inorder(TreeNode root) {
        //Left Root Right
        if(root!=null)
        {
            inorder(root.leftChild);
            System.out.print(root.data+" ");
            inorder(root.rightChild);
        }
    }

    private static void preorder(TreeNode root) {
        //Root Left Right
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }

    public static TreeNode create(){

        System.out.print("Enter Data : ");
        int data=sc.nextInt();
        if(data==-1)
            return null;
        TreeNode node=new TreeNode(data);
        System.out.println("Enter left for "+data);
        node.leftChild=create();
        System.out.println("Enter right for "+data);
        node.rightChild=create();

        return node;
    }
}
