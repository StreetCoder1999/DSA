import java.util.ArrayList;
import java.util.Arrays;

public class First{
    public static int assignCookies(int[] greedy,int[] size){

        int n=greedy.length;
        int m=size.length;
        int l=0;
        int r=0;
        Arrays.sort(greedy);
        Arrays.sort(size);
        while(l<m && r<n){
            if(greedy[r]<=size[l]){
                r=r+1;
            }
            l=l+1;
        }
        return r;     
    }
    public static boolean lemonadeChange(int[] bills){
        // Arrays.sort(bills);
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five+=1;
            }else if(bills[i]==10){
                if(five>0){
                    five-=1;
                    ten+=1;
                }else{
                    return false;
                }
            }else{
                if(five>0 && ten>0){
                    ten-=1;
                    five-=1;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;

    }

    public static ArrayList<Integer> candyStore(int candies[],int N,int K){
        ArrayList<Integer> ans=new ArrayList<>();

        Arrays.sort(candies);
        int mini=0;
        int buy=0;
        int free=N-1;
        while(buy<=free){
            mini+=candies[buy];
            buy++;
            free-=K;
        }
        int maxi=0;
        buy=N-1;
        free=0;
        while(free<=buy){
            maxi+=candies[buy];
            buy--;
            free+=K;
        }
        ans.add(mini);
        ans.add(maxi);
        return ans;
    }




    public static void main(String args[]){ 

        int greedy[]={1,5,3,3,4};
        int size[]={4,2,1,2,1,3};
        System.out.println(assignCookies(greedy,size));
        int[] bills={5,5,10,10,20};
        System.out.println(lemonadeChange(bills)); 
        int candies[]={3,2,1,4};
        System.out.println(candyStore(candies,4,2));
        int start[]={1,3,0,5,8,5};     
        int end[]={2,4,6,7,9,9};     
    }
}