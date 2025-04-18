public class merge {



    static int ans=0;
    public static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        merge(arr, si, mid, ei);

    }
        public static void merge(int[] arr, int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int count=0;
        while(i<=mid && j<=ei){
            if(arr[i]>arr[j]){
               merged[count++]=arr[j++];
                ans+=mid-i+1;//count inversion//
            }else{
                merged[count++]=arr[i++];
            }
        }
        while(i<=mid){
            merged[count++]=arr[i++];
            
        }
        while (j<=ei) {
            merged[count++]=arr[j++];
        }
        i = si;
        for (count=0; count <=merged.length-1;count++) {
            arr[i++]=merged[count];
        }

    }

    public static void main(String[] args) {

        int arr[] = {2, 4, 1, 3, 5};
        divide(arr, 0, arr.length - 1);
        System.out.println(ans);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        
    }
}