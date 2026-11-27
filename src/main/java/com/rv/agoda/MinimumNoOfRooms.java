package com.rv.agoda;

import java.util.Arrays;

public class MinimumNoOfRooms {

    //Minimum Number of Meeting Rooms
    //Given meeting start/end times, determine the minimum number of rooms required.
    public int solve(int [][]meetings) {
        int ans = 0;
        int minimum = 0, maximum = 0;

        for (int []meeting: meetings) {
            minimum = Math.min(minimum, meeting[0]);
            maximum = Math.max(maximum, meeting[1]);
        }

        int []count = new int[maximum - minimum + 2];
        Arrays.fill(count, 0);
        for (int []meeting: meetings) {
            count[meeting[0] - minimum] += 1;
            count[meeting[1] - minimum] -= 1;
        }
        ans = count[0];
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
            ans = Math.max(ans, count[i]);
        }
        return ans;
    }
}
