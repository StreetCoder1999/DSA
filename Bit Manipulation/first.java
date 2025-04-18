

public class first {
    public static void oddEven(int n){
        int bitMask=1;
        if((n&bitMask)==0){
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }
    }

    public static void getIthBit(int n,int i){
        int bitMask=1<<i;
        if((n&bitMask)==0){
            System.out.println("ith bit is 0");
        }else{
            System.out.println("ith bit is 1");
        }
    }

    public static int setIthBit(int n,int i){
        int bitMask=1<<i;
        return n|bitMask;

    }
    public static int clearIthBit(int n,int i){
        int bitMask=~(1<<i);
        return (n & bitMask);
    }
    public static int updateIthBit(int n,int i,int newBit){
        //process 1
        // if(newBit==0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }

        //process 2
        n=clearIthBit(n, i);
        int bitMask=newBit<<i;
        return n|bitMask;

    }

    public static int clearLastIthBit(int n,int i){
        //int bitMask=(-1<<i);
        int bitMask=(~0)<<i;
        return (n & bitMask);
    }

    public static int clearBitInRange(int n,int i,int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitMask=a|b;
        return n & bitMask;
    }
    public static boolean isPowerOfTwo(int n){
        // if((n & n-1)==0){
        //     return true;
        // }else{
        //     return false;
        // }

        return (n & (n-1))==0;
        
    }

    public static int countSetBits(int n){
       int count=0;
       while(n!=0){
        if((n&1)!=0){
            count++;
        }
        n=n>>1;
       }
       return count;
    }

    public static int fastExponentiation(int a,int n){
        int ans=1;
        while(n>0){
            if((n&1)!=0){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        // for (int i = 0; i <=9; i++) {
        //     System.out.print(~i+",");
        // }

        // oddEven(3);
        // oddEven(6);
        // oddEven(9);
        // oddEven(5);

       // getIthBit(7, 2);
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(15, 2));
        // System.out.println(clearLastIthBit(15, 4));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearBitInRange(10,2,4));
        //System.out.println(countSetBits(16));
        System.out.println(fastExponentiation(5, 3));
        
    }
}
