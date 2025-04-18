package Decimal;

public class deci {

    public static String deciToBin(int decimal){
        String ans="";
        StringBuilder str=new StringBuilder("");
        while(decimal!=0){
            int rem=decimal%2;
            decimal/=2;
            ans=ans+(""+rem);
            str.append(""+rem);

        }
        
        str.append(""+decimal);
        str.reverse();

        return str.toString();
    }

    public static int deciToBin2 (int decimal){
        int ans=0;
        int pow=0;
        while (decimal!=0) {
            int rem=decimal%2;
            ans=ans+rem*(int)Math.pow(10, pow++);
            decimal/=2;
        }
        return ans;
    }
    public static int binToDeci(int n){
        int ans=0;
        int pow=0;
        while (n!=0) {
            int rem=n%10;
            
            ans+=rem*(int) Math.pow(2,pow++ );
            n=n/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt(deciToBin(15)));
        System.out.println(binToDeci(1111));
        System.out.println(deciToBin2(15));
    }
    
} 