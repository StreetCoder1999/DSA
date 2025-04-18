import java.util.HashMap;
import java.util.HashSet;

public class medium {

    public static int trappingRainwater(int height[]) {

        int n = height.length;

        int totalWater = 0;
        if (n <= 2) {
            // if total bar is two.it is optional
            return totalWater;
        }
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        // calculate left max boundary
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // calculate right max boundary
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            totalWater += (waterLevel - height[i]);
        }
        return totalWater;

    }
    //One approach by me
    // public static int buyAndSellOneStocks(int prices[]) {
    //     int n = prices.length;
    //     int maxProfit = 0;
    //     int maxValue[] = new int[n];
    //     maxValue[n - 1] = prices[n - 1];
    //     // set the max value after current date or if i buy on index-th day, how much selling price  maxmimum i get after this day
    //     for (int i = n - 2; i >= 0; i--) {
    //         maxValue[i] = Math.max(maxValue[i + 1], prices[i]);
    //     }
    //     // loop for calulating maxProfit
    //     for (int i = 0; i < n; i++) {
    //         int profit = maxValue[i] - prices[i];
    //         maxProfit = Math.max(maxProfit, profit);
    //     }

    //     return maxProfit;
    // }
    //Another easy approach by me
    //this is easy one comparetively
    public static int buyAndSellOneStocks(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            buyPrice=Math.min(buyPrice, prices[i]);
            int profit=prices[i]-buyPrice;//current profit
            maxProfit=Math.max(profit,maxProfit);
        }
        return maxProfit;
    }


    public static boolean distinctElement(int nums[]){
        HashSet set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 3, 2, 5 };
       // System.out.println(trappingRainwater(height));
        int prices[] = { 7, 1,5,3,6,4};
        System.out.println(buyAndSellOneStocks(prices));
        int nums[]={1, 2, 3, 4};

        //System.out.println(distinctElement(nums));

    }
}
