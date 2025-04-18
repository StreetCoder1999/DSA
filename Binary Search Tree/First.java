public class First{
    static class  Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            Node newNode=new Node(val);
            return newNode;
        }
        if(root.val>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.val==key){
            return true;
        }
        if(root.val>key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
         
        
    }
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root=null;
        for (int i = 0; i < values.length; i++) {
            root=insert(root, values[i]);
        }
        inorder(root);
        System.out.println(search(root, 8));
    }
}