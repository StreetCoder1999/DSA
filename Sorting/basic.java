public class basic{

    public static void sortByMe(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void bubbleSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            int miniIndex=i;
            //bring the index of the minimum value and store it in minindex
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[miniIndex]){
                    miniIndex=j;
                }
            }
            //swap arr[i] and arr[miniIndex]
            int temp=arr[miniIndex];
            arr[miniIndex]=arr[i];
            arr[i]=temp;
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int curr=arr[i];
            int prev=i-1;
            while(prev >=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insert curr into its correct position
            arr[prev+1]=curr;
        }
    }
    public static void countingSort(int[] arr){
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        int countingArray[]=new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            countingArray[arr[i]]++;
        }
        int count=0;
        for (int i = 0; i < countingArray.length; i++) {
            int counter=countingArray[i];
                while(counter>0){
                    arr[count++]=i;
                    counter--;
                }
            
        }
    }



    public static void main(String[] args) {
        int[] arr={3,6,2,1,8,7,4,5,3,1};
        //bubbleSort(arr);
        //selectionSort(arr);
      //insertionSort(arr);
      //countingSort(arr);
        
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]+", ");
        // }

       

    }
}