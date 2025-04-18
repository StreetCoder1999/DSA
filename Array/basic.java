

import java.lang.reflect.Array;
import java.util.*;

public class basic {

    public static int linearSearch(int numbers[], int key) {

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(String numbers[], String key) {

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static int largestNum(int numbers[]) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > ans) {
                ans = numbers[i];
            }
        }

        return ans;
    }

    public static int binarySearch(int numbers[], int si, int ei, int key) {
        if (si > ei) {
            return -1;
        }
        int mid = ei - (ei - si) / 2;
        if (numbers[mid] == key) {
            return mid;
        } else if (numbers[mid] < key) {
            return binarySearch(numbers, mid + 1, ei, key);
        } else {
            return binarySearch(numbers, si, mid - 1, key);
        }
    }

   
    public static void reverse(int numbers[], int si, int ei) {

        if (si > ei) {
            return;
        }
        int temp = numbers[si];
        numbers[si] = numbers[ei];
        numbers[ei] = temp;
        si++;
        ei--;
        reverse(numbers, si, ei);

    }

    public static void pairs(int numbers[]){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                System.out.println("{"+numbers[i]+","+numbers[j]+"}");
            }
        }
    }

    public static void subArrays(int numbers[]){
        
       
        for (int i = 0; i < numbers.length; i++) {
            // System.out.println(numbers[i]);
            for (int j = i; j < numbers.length; j++) {
                
                
                for (int j2 = i; j2 <=j; j2++) {
                    
                    
                    System.out.print(numbers[j2] +",");
                }
               
                System.out.println();
            }
            
        }
        
    }

    public static void main(String[] args) {
        int numbers[] = { 9,10, 1,2,4,6, 7,8};
        String things[] = { "ball", "bat", "wicket", "pad", "gloves", "guard" };
        int key = 18;
        String val = "wicket";
        // System.out.println(linearSearch(things, val));

        // System.out.println(largestNum(numbers));
        // System.out.println(binarySearch(numbers, 0, 7, key));
        // reverse(numbers, 0, numbers.length -1);
        // for (int i = 0; i < numbers.length; i++) {
        //     System.out.print(numbers[i] + " ");
        // }
        //pairs(numbers);
        //subArrays(numbers);

    }
}
