import java.util.*;

public class practice {

    public static boolean compare(String a, String b) {
        if (a.compareTo(b) < 1) {
            return true;
        }
        return false;
    }

    public static void merge(String[] arr, int si, int mid, int ei) {
        String[] merged = new String[ei - si + 1];
        int low = si;
        int high = mid + 1;
        int count = 0;
        while (low <= mid && high <= ei) {
            if (compare(arr[low], arr[high])) {
                merged[count++] = arr[low++];
            } else {
                merged[count++] = arr[high++];
            }
        }

        while (low <= mid) {
            merged[count++] = arr[low++];
        }
        while (high <= ei) {
            merged[count++] = arr[high++];
        }
        low = si;
        for (count = 0; count < merged.length; count++) {
            arr[low++] = merged[count];
        }
    }

    public static void sort(String[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        sort(arr, si, mid);
        sort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        String[] arr = { "sun", "earth", "mars", "mercury" };
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
