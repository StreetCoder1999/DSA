import java.util.Arrays;
import java.util.Collections;

public class second {

    static int tilingProblem(int n) {
        
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        //horizontal way + vertical way
        return tilingProblem(n-2)+tilingProblem(n-1);
    }


    public static void removeDuplicate(String str,StringBuilder s,boolean[] map,int i){
        if(i==str.length()){
            char temp[]=s.toString().toCharArray();
            Arrays.sort(temp);
            
            System.out.println(temp);
            return;
        }
        char currChar=str.charAt(i);
        if(map[currChar-'a']!=true){
            map[currChar-'a']=true;
            s.append(currChar);  
        }
        removeDuplicate(str,s, map, i+1);
        
    }

    public static int friendsPairing(int n){
        if(n==1 ||n==2){
            return n;
        }
        return friendsPairing(n-1) +(n-1)*friendsPairing(n-2);
    }
    public static void printBinaryStrings(int n,int lastPlace,String ans){
        if(n==0){
            System.out.println(ans);
            return;
        }
        // if(lastPlace==0){
        //     printBinaryStrings(n-1, 0, ans+"0");
        //     printBinaryStrings(n-1, 1, ans+"1");
        // }else{
        //     printBinaryStrings(n-1, 0, ans+"0");
        // }
        printBinaryStrings(n-1, 0, ans+"0");
        if(lastPlace==0){
            printBinaryStrings(n-1, 1, ans+"1");
        }

    }


   
    public static void generateSubstring(String word) {
        if (word.length() == 1) {
            System.out.println(word);
            return;
        }else{
            System.out.println(word);
            generateSubstring(word.substring(0, word.length()-1)); 
            generateSubstring(word.substring(1, word.length())); 
        }

    }

    public static void mySubstring (String s,int i,int j){
        if(i==s.length()){
            return;
        }
        if(j==s.length()){
            mySubstring(s, i+1, i+1);
        }else{
            System.out.print(s.substring(i, j+1)+",");
            mySubstring(s, i, j+1);
        }
    }

    
    public static void main(String[] args) {
       //System.out.println(tilingProblem(5));
       String str="cbacdcbc";
       //removeDuplicate(str,new StringBuilder(""), new boolean[26], 0);
       //printBinaryStrings(3, 0, "");
       //subString("abc", "",0);
       //printAllSubstrings("abcaab");
       //generateSubstring("abc");
       mySubstring("abc", 0, 0);

    }
}
