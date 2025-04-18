import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class slidingWindow {
    public static ArrayList<Integer> solve(int[] arr,int k){
        ArrayList<Integer>ans=new ArrayList<>();
        Deque<Integer> maxi=new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!maxi.isEmpty() && arr[maxi.getLast()]<=arr[i] ){
                maxi.removeLast();
            }
            maxi.addLast(i);
        }
        ans.add(arr[maxi.peek()]);

        for(int i=k;i<arr.length;i++){
            while(!maxi.isEmpty() && i-maxi.peek()>=k){
                maxi.pop();
            }
            while(!maxi.isEmpty() && arr[maxi.getLast()]<=arr[i] ){
                maxi.removeLast();
            }
            maxi.addLast(i);
            ans.add(arr[maxi.peek()]);

        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,1,4,5,2,3,6};
        ArrayList<Integer>ans=solve(arr,3);
        System.out.println(ans);
    }
}
