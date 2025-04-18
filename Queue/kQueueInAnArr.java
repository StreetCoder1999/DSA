public class kQueueInAnArr {
    int n;
    int k;
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int freeSpot;
    kQueueInAnArr(int k,int n){
        this.k=k;
        this.n=n;
        this.arr=new int[n];
        this.front=new int[k];
        this.rear=new int[k];
        this.next=new int[n];
        for(int i=0;i<k;i++){
            front[i]=rear[i]=-1;
        }
        freeSpot=0;
        for (int i = 0; i <n-1; i++) {
            next[i]=i+1;
        }
        next[n-1]=-1;
    }

    public void enqueue(int data,int qn){
        if(freeSpot==-1){
            System.out.println("No empty space is present");
            return;
        }
        int index=freeSpot;
        freeSpot=next[index];
        if(front[qn-1]==-1){
            front[qn-1]=index;
        }else{
            next[rear[qn-1]]=index;
        }
        next[index]=-1;
        rear[qn-1]=index;
        arr[index]=data;
    }

    public int pop(int qn){
        if(front[qn-1]==-1){
            System.out.println("queue is empty");
            return -1;
        }
        int index=front[qn-1];
        int data=arr[index];
        front[qn-1]=next[index];
        next[index]=freeSpot;
        freeSpot=index;
        return data;
    }

    public static void main(String[] args) {
        kQueueInAnArr queue=new kQueueInAnArr(3, 10);
        queue.enqueue(1, 1);
        queue.enqueue(2, 2);
        queue.enqueue(3, 3);
        queue.enqueue(4, 1);
        queue.enqueue(5, 2);
        queue.enqueue(6, 3);
        queue.enqueue(6, 3);
        queue.enqueue(6, 3);
        queue.enqueue(6, 3);
        queue.enqueue(6, 3);
        queue.enqueue(6, 3);
        System.out.println(queue.pop(1));
        System.out.println(queue.pop(2));
        System.out.println(queue.pop(3));
        System.out.println(queue.pop(3));
        System.out.println(queue.pop(3));
        
    }
}
