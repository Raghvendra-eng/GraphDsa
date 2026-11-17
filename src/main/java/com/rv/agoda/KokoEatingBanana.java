package com.rv.agoda;

public class KokoEatingBanana {

//    Koko has n piles of bananas. The i-th pile contains piles[i] bananas.
//
//    Koko has exactly h hours to eat all the bananas.
//
//    She chooses an integer eating speed k (bananas per hour).
//
//    For every hour:
//
//    Koko chooses one pile and eats up to k bananas from that pile.
//    If the pile contains fewer than k bananas, she eats all remaining bananas from that pile.
//    She cannot eat from another pile during that same hour.
//    She can choose a different pile in the next hour.
//
//    Your task is to find the minimum integer value of k such that Koko can finish all bananas within h hours.

    public int solve(int []piles, int hour) {
        int ans = Integer.MAX_VALUE;
        int n = piles.length;
        if (hour < n) {
            return -1;
        }
        int low = 1, high = 0, mid;
        for(int pile: piles) {
            high = Math.max(high, pile);
        }
        if (hour == n)
            return high;
        while (low <= high) {
            mid = low + (high - low)/2;
            int hourCount = calculateHour(piles, hour, mid);
            if (hourCount <= hour) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int calculateHour(int[] piles, int hour, int mid) {
        int count = 0;

        for (int pile: piles) {
            count += (pile + mid - 1)/mid;
        }
        return count;
    }
}
