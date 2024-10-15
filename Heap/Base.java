import java.util.*;

public class Base{
    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void insert(int data){
            arr.add(data);

            int x=arr.size()-1;
            int parent =(x-1)/2;
            while(parent>=0 && arr.get(parent)>arr.get(x)){
                //swap
                int temp=arr.get(x);
                arr.set(x,arr.get(parent));
                arr.set(parent,temp);
                x=parent;
                parent=(x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int idx){
            int leftIdx=2*idx+1;
            int rightIdx=2*idx+2;
            int minIdx=idx;
            if(leftIdx<arr.size() && arr.get(minIdx)>arr.get(leftIdx)){
                minIdx=leftIdx;
            }
            if(rightIdx<arr.size() && arr.get(minIdx)>arr.get(rightIdx)){
                minIdx=rightIdx;
            }
            if(minIdx!=idx){
                //swap
                int temp=arr.get(idx);
                arr.set(idx,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            int data=arr.get(0);
            //step 1-swap first and last
            arr.set(0,arr.size()-1);
            //delete last
            arr.remove(arr.size()-1);
            heapify(0);
            return data;
        }

        public void print(){
            for(int i=0;i<=arr.size()-1;i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       Heap h=new Heap();
       h.insert(1);
       h.insert(2);
       h.insert(3);
       h.insert(4);
       h.insert(-1);
       h.print();
    }
}