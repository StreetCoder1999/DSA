import java.util.Arrays;

public class basic{
    public static void shortestPath(String str){
        int x=0;
        int y=0;
        float shortestDistance=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='E'){
                x++;
            }else if(str.charAt(i)=='W'){
                x--;
            }else if(str.charAt(i)=='N'){
                y++;
            }else{
                y--;
            }
        }

        shortestDistance=(float)Math.sqrt((Math.pow(x-0, 2))+(Math.pow(y-0, 2)));
        System.out.println(shortestDistance);

    }

    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder("");
        
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            char ch=str.charAt(i-1);
            if(ch==' '){
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
           
        }
        return sb.toString();
    }

    public static String compress(String str){
       //String newStr="";
       StringBuilder newstr=new StringBuilder("");
       for (int i = 0; i < str.length(); i++) {
        Integer count=1;
        while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
            count++;
            i++;
        }
        newstr.append(str.charAt(i));
        if(count>1){
            //newStr+=str.charAt(i)+count.toString(); 
            
            newstr.append(count.toString()); 
        }


       } 
       return newstr.toString();
    }

    public static void main(String[] args) {
        String str="NSESWWN";
        str.compareToIgnoreCase(str);

        String s="i am a very horny, type sexually disorder mentally fucked up boy ";
        //System.out.println(toUpperCase(s));
        String str1="aaabbcccdd";
        System.out.println(compress(str1));
        
        //shortestPath(str);
    }
}