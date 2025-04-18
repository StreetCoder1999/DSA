import java.util.*;

import org.w3c.dom.Node;

public class tree {
     static class node {
        int data;
        node right;
        node left;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static node buildTree(node root) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Data:");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        root = new node(data);

        System.out.println("Assign value to the left of" + data);
        root.left = buildTree(root.left);

        System.out.println("Assign value to right of" + data);
        root.right = buildTree(root.right);

        return root;
    }

    public static List<List<Integer>> levelOrder(node root) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            node temp = q.remove();

            if (temp == null) {
               // System.out.println("ans ="+ans);
                answer.add(new ArrayList (ans));
               // System.out.println("answer="+answer);
                ans.clear();
               // System.out.println("after clearing ans="+ans);
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            } else {
                //System.out.print(temp.data+",");
                ans.add(temp.data);

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
        return answer;

    }

    static int index=-1;
    public static node buildTreePreOrder(int[] nodes){
        index++;
        if(nodes[index]==-1){
            return null;
        }
        node root=new node(nodes[index]);
        root.left=buildTreePreOrder(nodes);
        root.right=buildTreePreOrder(nodes);
        return root;
    }

    public static void inorderTraversal(node root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+",");
        inorderTraversal(root.right);
        return;
    }

    public static void postorderTraversal(node root){
        if(root==null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+",");
        return;
    }
    public static void preorderTraversal(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+",");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
        return;
    }

    public static node buildTreeLevelOrder(node root){
        Scanner sc =new Scanner(System.in);
        Queue<node> q=new LinkedList<node>();
        System.out.println("Enter data for root:");
        int data=sc.nextInt();
        root=new node(data);
        q.add(root);
        while(!q.isEmpty()){
            node temp=q.remove();

            System.out.println("Enter left node data for-"+temp.data);
            int leftData=sc.nextInt();
            if(leftData!=-1){
                temp.left=new node(leftData);
                q.add(temp.left);
            }

            System.out.println("Enter right node data for-"+temp.data);
            int rightData=sc.nextInt();
            if(rightData!=-1){
                temp.right=new node(rightData);
                q.add(temp.right);
            }
        }
        return root;
    }
    
        static class answer{
        int diam;
        int height;
        answer(int diam,int height){
            this.diam=diam;
            this.height=height;
        }
    }
    
    public static answer solve(node root){
       answer left=solve(root.left);
       answer right=solve(root.right);
       int myHeight=Math.max(left.height,right.height)+1;
       int diam1=left.diam;
       int diam2=right.diam;
       int diam3=left.height+right.height+1;
       int myDiam=Math.max(diam1,Math.max(diam2,diam3));
       answer final1=new answer(0,0);
       final1.height=myHeight;
       final1.diam=myDiam;
       return final1;
       
    }
    static int diameter(node root) {
        // Your code here
        answer ans=new answer(0,0);
        ans=solve(root);
        return ans.diam;
    }


    public static void main(String[] args) {
        // node root = null;
        // root=buildTreeLevelOrder(root);

        //root = buildTree(root);
        int nodes[]={1, 3, 7, -1, -1 ,11, -1, -1, 5, 17, -1, -1, -1};
        node preorderoot=buildTreePreOrder(nodes);
        //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        System.out.println();
        System.out.println("the ans is -"+levelOrder(preorderoot));
       // postorderTraversal(preorderoot);
       //System.out.println("zigzag:-"+zigZagTraversal(preorderoot));
    }
}