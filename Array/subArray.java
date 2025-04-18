public class subArray {

    public static void maxSubArraySum(int numbers[]){
     //brute force apporoach   
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            
            for (int j = i; j < numbers.length; j++) {
                int sum=0;
                for (int j2 = i; j2 <=j; j2++) {
                    sum+=numbers[j2];
                }
                if(max<sum){
                    max=sum;
                }
                if(min>sum){
                    min=sum;
                }
               
            }
             
        }
        System.out.println(max+" "+min);
    }


    public static void maxSubArrayPrefixSum(int numbers[]){
        int max=Integer.MIN_VALUE;
        int currSum=0;
        int prefixSum[]=new int[numbers.length];
        prefixSum[0]=numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            prefixSum[i]=prefixSum[i-1]+numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                
                currSum = i==0? prefixSum[j] : prefixSum[j]-prefixSum[i-1];
                if(currSum>max){
                    max=currSum;
                }

            }
        }

        System.out.println(max);
    }

    public static void maxSubArrayKedaneSum(int numbers[]){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int si=0;
        int ei=0;

        for (int i = 0; i < numbers.length; i++) {
            
            currSum+=numbers[i];
            if(currSum<0){
                currSum=0;
                si=ei=i+1;
            }
            
            if(currSum>maxSum){
                maxSum=currSum;
                ei=i;
            }
        }
        //if all the numbers are negetive 
        if(maxSum==0){
            maxSum=numbers[0];
            si=ei=0;
            for (int i = 1; i < numbers.length; i++) {
                if(maxSum<numbers[i]){
                    maxSum=numbers[i];
                    si=ei=i;
                }
            }
        }
        System.out.println(maxSum+" "+si+" "+ei);
    }

    public static void main(String[] args) {
        int numbers[] = { -2,-3,4,-1,-2,1,5,-3};
        maxSubArrayKedaneSum(numbers);
        
    }
}
