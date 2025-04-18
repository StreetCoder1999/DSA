public class quicksort {

    public static int pivotIdx(int arr[],int si,int ei){
        int pivotElement=arr[ei];
        int idx=si-1;//this index keeps track the right index of pivot
        for (int i = si; i < ei; i++) {
            //pivot se chota element ko pivot k aage lana hay
            if(arr[i]<pivotElement){
                idx++;
                //swap between arr[i] & arr[idx]
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
            }
        }
        idx++;
        int temp=arr[ei];
        arr[ei]=arr[idx];
        arr[idx]=temp;
        return idx;

    }
    public static void quick(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pidx=pivotIdx(arr,si,ei);
        quick(arr, si, pidx-1);
        quick(arr, pidx+1, ei);
    }
    public static void main(String[] args) {
        int arr[]={6,3,9,8,2,5,-2};
        quick(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
