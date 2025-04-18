import java.util.*;

public class practice {
    // public static Queue<Integer> reverse(Queue<Integer> q){
    //     Stack<Integer> st=new Stack<>();
    //     while(!q.isEmpty()){
    //         st.push(q.remove());
    //     }
    //     while(!st.isEmpty()){
    //         q.add(st.pop());
    //     }
    //     return q;

    // }

    public static int sumOfMinMax(int arr[],int k){
        Deque<Integer> mini=new LinkedList<>();
        Deque<Integer> maxi=new LinkedList<>();
        int ans=0;
        for(int i=0;i<k;i++){
            while(!maxi.isEmpty()&&arr[maxi.getLast()]<=arr[i]){
                maxi.removeLast();
            }
            while(!mini.isEmpty()&&arr[mini.getLast()]>=arr[i]){
                mini.removeLast();
            }
            maxi.addLast(i);
            mini.addLast(i);
        }
        ans+=arr[maxi.peek()]+arr[mini.peek()];
        for (int i = k; i < arr.length; i++) {
            
            while (!maxi.isEmpty()&&(i-maxi.peek()>=k)) {
                maxi.pop();
            }
            while(!mini.isEmpty()&&(i-mini.peek())>=k){
                mini.pop();
            }

            while(!maxi.isEmpty()&&arr[maxi.getLast()]<=arr[i]){
                maxi.removeLast();
            }
            while(!mini.isEmpty()&&arr[mini.getLast()]>=arr[i]){
                mini.removeLast();
            }
            maxi.addLast(i);
            mini.addLast(i);
            ans+=arr[maxi.peek()]+arr[mini.peek()];
        }
        return ans;
    }
    public static void main(String args[]){
       int arr[]={2,5,-1,7,-3,-1,-2};
       System.out.println(sumOfMinMax(arr, 4));
    }
}
