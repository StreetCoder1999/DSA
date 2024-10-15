import java.util.PriorityQueue;

public class Practice {
    public static void heapify(int idx,int arr[]){

    }
    public static void main(String[] args) {
        int arr[]={10,5,6,2,12,7,9};
       for(int i=arr.length/2 -1;i>=0;i++){
        heapify(i, arr);
       }
       for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
       }
    }
}
