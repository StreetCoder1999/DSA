import java.util.Collections;

public class first{
    public static void printDec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }
    public static void printInc(int n){
        if(n==0){
            return;
        }
        printInc(n-1);
        System.out.println(n);
       
    }
    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=n*factorial(n-1);
        return ans;

    }

    public static int calculateSum(int n){
        if(n==1){
            return 1;
        }
        return (n+calculateSum(n-1));

    }

    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static boolean isSorted(int[] arr,int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]<=arr[i+1]){
            return isSorted(arr, i+1);
        }else{
            return false;
        }
    }

    public static int firstOccurance(int[] arr,int i,int key){
        if(i==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccurance(arr, i+1, key);
    }
    // public static int lastOccurance(int[] arr,int i,int key){
    //     if(i==0){
    //         return -1;
    //     }
    //     if(arr[i]==key){
    //         return i;
    //     }
    //     return lastOccurance(arr, i-1, key);
    // }

    public static int lastOccurance(int[] arr,int i,int key){
        if(i==arr.length-1){
            return -1;
        }
        int isFound=lastOccurance(arr, i+1, key);
        if(isFound==-1 && arr[i]==key ){
            return i;

        }
        return isFound;
    }

    public static long power(int R,long N){
        long answer=1;
        while(R>0){
            if((R&1)==1){
                answer=answer*N;
            }
            N=N*N;
            R=R>>1;
        }
        return answer%1000000007;
    }

    public static long  powerFast(int x,int n){
        if(n==0){
            return 1;
        }
        long halfPower=powerFast(x, n/2);
        if(n%2==0){
            // return powerFast(x, n/2)*powerFast(x, n/2);
            return halfPower*halfPower;
        }else{
            // return x*powerFast(x, n/2)*powerFast(x,n/2);
            return x*halfPower*halfPower;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,4,8};
        //printDec(8);
        //printInc(10);
       //System.out.println(calculateSum(5));
       //System.out.println(fibonacci(44));
       //System.out.println(isSorted(arr, 0));
       System.out.println(lastOccurance(arr, 0, 4));
       System.out.println(power(21, 12));
    }
}