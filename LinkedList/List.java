public class List {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        Node newHead = new Node(data);
        size++;
        if (head == null) {
            head = tail = newHead;
            return;
        }
        newHead.next = head;
        head = newHead;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(tail==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

    public void addInIndex(int idx,int data){
        //corner case
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i< idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        
    }

    public int removeFirst(){
        if(size==0){
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        Node temp=head;
        if(size<=0){
            size--;
            return Integer.MIN_VALUE;
        }else if(size==1){
            size--;
            int val=head.data;
            head=tail=null;
            return val;
        }
        
        while(temp.next!=tail){
            temp=temp.next;
        }
        int val=temp.next.data;
        tail=temp;
        tail.next=null;
        size--;
        return val;
    }
    
    public int search(int key,Node temp,int ans){
        if(temp==null){
            // if(temp.data==key){
            //     return ans;
            // }
            return -1;
        }
        if(temp.data==key){
            return ans;
        }
        return search(key, temp.next,ans+1);

    }

    public Node reverseIterative(Node head){
        Node prevPtr=null;
        Node currPtr=head;
        while(currPtr!=null){
            Node nextPtr=currPtr.next;
            currPtr.next=prevPtr;
            prevPtr=currPtr;
            currPtr=nextPtr;

        }
        return prevPtr;
    }

    public Node reverseRecursive(Node curr,Node prev){
        if(curr==null){
            return prev;
        }
        Node newHead=reverseRecursive(curr.next, curr);
        curr.next=prev;
        return newHead;
    }

    public void deleteNthFromLast(int n){
        if(head.next==null){
            head=null;
            return;
        }
        Node temp=head;
        int sz=0;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        //if we have to delete head
        if(sz==n){
            head=head.next;
        }
        int prevPosition=1;
        Node prev=head;
        while(prevPosition<sz-n){
            prev=prev.next;
            prevPosition++;
        }

        prev.next=prev.next.next;
        return;

    }

    public boolean isPalindrome() {
        int number=0;
        Node temp=head;
        while(temp != null){
            number=(number*10)+temp.data;
            temp=temp.next;
        }
        int oldNumber=number;
        int revNumber=0;
        while(oldNumber != 0){
            revNumber=(revNumber*10)+ (oldNumber % 10);
            oldNumber=oldNumber/10;  
        }
         if(revNumber==number){
            return true;
         }else{
            return false;
         }
    }

    public void printList(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        List ll = new List();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        // ll.addLast(5);
        // ll.addFirst(0);
        //ll.addInIndex(0,10);
        ll.printList(head);
        System.out.println();
        //Node newHead=ll.reverseIterative(head);
        // Node curr=head;
        // Node prev=null;
        // Node newHead=ll.reverseRecursive(curr,prev);
        
    //    System.out.println(ll.removeLast());
    //    System.out.println(ll.removeLast());
    //    System.out.println(ll.removeLast());
    //    System.out.println(ll.removeLast());
    //    System.out.println(ll.removeLast());
    //    System.out.println(ll.removeLast());
       //ll.printList(newHead);
       //System.out.println();
    //    Node temp=head;
    //    System.out.println(ll.search(10, temp,0));

    System.out.println(ll.isPalindrome());
    }
}