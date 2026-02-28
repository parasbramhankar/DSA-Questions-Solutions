package Array.Medium.KokoEatingBananas875;



import java.util.Arrays;

/*
 * LeetCode 875 – Koko Eating Bananas
 *
 * Problem:
 * Given an array `piles` where each element represents the number of bananas
 * in a pile, and an integer `h` representing total hours available,
 * return the minimum integer eating speed `k` such that Koko can finish
 * all bananas within `h` hours.
 *
 * ------------------------------------------------------------
 * APPROACH: Binary Search on Answer Space
 * ------------------------------------------------------------
 *
 * 1) Key Observation:
 *    - If Koko eats at speed k bananas/hour,
 *      time required for one pile = ceil(pile / k).
 *    - Total hours required = sum of ceil(pile / k) for all piles.
 *
 *    - If k increases → total hours decrease.
 *    - If k decreases → total hours increase.
 *
 *    This forms a MONOTONIC pattern.
 *    Hence, we can apply Binary Search.
 *
 * ------------------------------------------------------------
 * 2) Search Space:
 *
 *    Minimum possible speed = 1
 *    Maximum possible speed = max(piles)
 *
 *    Because:
 *    - She must eat at least 1 banana/hour.
 *    - If she eats at max(piles), she can finish the largest pile in 1 hour.
 *
 * ------------------------------------------------------------
 * 3) Binary Search Logic:
 *
 *    While low <= high:
 *        mid = possible eating speed
 *        totalH = total hours needed at speed mid
 *
 *        If totalH <= h:
 *            → Speed is valid
 *            → Try smaller speed (move left)
 *        Else:
 *            → Speed too slow
 *            → Increase speed (move right)
 *
 *    This ensures we find the MINIMUM valid speed.
 *
 * ------------------------------------------------------------
 * 4) Why long is used?
 *
 *    The sum of required hours can exceed Integer limit.
 *    Example:
 *    Large pile values (~10^9)
 *    Summing multiple such values may overflow int.
 *
 *    So we use long for totalH to avoid overflow.
 *
 * ------------------------------------------------------------
 * 5) Time Complexity:
 *
 *    Finding max pile        → O(n)
 *    Binary search iterations→ O(log(maxPile))
 *    Each iteration takes    → O(n)
 *
 *    Overall Time Complexity:
 *        O(n log m)
 *        where:
 *          n = number of piles
 *          m = maximum pile size
 *
 * ------------------------------------------------------------
 * 6) Space Complexity:
 *    O(1)  (No extra data structures used)
 *
 * ------------------------------------------------------------
 * Summary:
 * This problem is a classic example of:
 * Binary Search on Answer (Monotonic Function).
 *
 */

public class Solution {

    public static long calculateTotalH(int[]piles,int mid){
        long totalH=0;

        for(int i:piles){
            totalH+=(long)Math.ceil((double) i/mid);
        }

        return totalH;
    }

    public static int minimumEatingSpeed(int[]piles,int h){
        int maxPiles= Arrays.stream(piles).max().getAsInt();
        int ans=maxPiles;
        int low=1;
        int high=maxPiles;

        while(low<=high){
            int mid=low+(high-low)/2;

            long totalH=calculateTotalH(piles,mid);

            if(totalH<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] piles=new int[]{3,6,7,11};
        int h = 8;

        int k=minimumEatingSpeed(piles,h);

        System.out.println("The minimum eating speed: "+k);
    }

}
