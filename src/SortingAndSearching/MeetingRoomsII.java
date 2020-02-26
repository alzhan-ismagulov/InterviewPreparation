/*
Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:

Input: [[7,10],[2,4]]
Output: 1

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
   Hide Hint #1
Think about how we would approach this problem in a very simplistic way. We will allocate rooms to meetings that occur
earlier in the day v/s the ones that occur later on, right?
   Hide Hint #2
If you've figured out that we have to sort the meetings by their start time, the next thing to think about is how do we
do the allocation?
There are two scenarios possible here for any meeting. Either there is no meeting room available and a new one has to
be allocated, or a meeting room has freed up and this meeting can take place there.
   Hide Hint #3
An important thing to note is that we don't really care which room gets freed up while allocating a room for the
current meeting. As long as a room is free, our job is done.

We already know the rooms we have allocated till now and we also know when are they due to get free because of the end
times of the meetings going on in those rooms. We can simply check the room which is due to get vacated the earliest
amongst all the allocated rooms.
   Hide Hint #4
Following up on the previous hint, we can make use of a min-heap to store the end times of the meetings in various rooms.

So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that
would be the room that would get free the earliest out of all the other rooms currently occupied.

If the room we extracted from the top of the min heap isn't free, then no other room is. So, we can save time here and
simply allocate a new room.
 */
package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
    //Approach 2: Chronological Ordering
    class Solution2 {
        public int minMeetingRooms(int[][] intervals) {

            // Check for the base case. If there are no intervals, return 0
            if (intervals.length == 0) {
                return 0;
            }

            Integer[] start = new Integer[intervals.length];
            Integer[] end = new Integer[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }

            // Sort the intervals by end time
            Arrays.sort(
                    end,
                    new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                            return a - b;
                        }
                    });

            // Sort the intervals by start time
            Arrays.sort(
                    start,
                    new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                            return a - b;
                        }
                    });

            // The two pointers in the algorithm: e_ptr and s_ptr.
            int startPointer = 0, endPointer = 0;

            // Variables to keep track of maximum number of rooms used.
            int usedRooms = 0;

            // Iterate over intervals.
            while (startPointer < intervals.length) {

                // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
                if (start[startPointer] >= end[endPointer]) {
                    usedRooms -= 1;
                    endPointer += 1;
                }

                // We do this irrespective of whether a room frees up or not.
                // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
                // remain the same in that case. If no room was free, then this would increase used_rooms
                usedRooms += 1;
                startPointer += 1;

            }

            return usedRooms;
        }
    }
}
