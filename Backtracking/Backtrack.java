import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backtrack {

    public static void allSubset(int[] nums,List<List<Integer>> ans,ArrayList<Integer> currAns,int i){
        if(i==nums.length ){
            //System.out.println(currAns);
            ans.add(new ArrayList<Integer>(currAns));
            return;
        }
        allSubset(nums,ans,currAns,i+1);
        currAns.add(nums[i]);
        allSubset(nums,ans,currAns,i+1);
        currAns.remove(currAns.size()-1); 
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        ArrayList<Integer> currAns=new ArrayList<Integer>();
        allSubset(nums,ans,currAns,0);
        return ans;
    }


    public static void permutations(String s,String permuteString){
        //base case
        if(s.length()==0){
            System.out.println(permuteString);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char curr=s.charAt(i);
            String newStr=s.substring(0, i)+s.substring(i+1);
            permutations(newStr, permuteString+curr);
        }
    }


    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        
        ans=subsets(nums);
        System.out.println(ans);

        permutations("abc", "");
    }
}
