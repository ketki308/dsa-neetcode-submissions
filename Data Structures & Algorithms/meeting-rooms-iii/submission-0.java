class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort by original start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Available rooms: smallest room number first
        PriorityQueue<Integer> available = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // Busy rooms: [endTime, roomNumber]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free all rooms that are available at 'start'
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                long[] room = busy.poll();
                available.offer((int) room[1]);
            }

            if (!available.isEmpty()) {

                // Use lowest numbered available room
                int room = available.poll();

                busy.offer(new long[]{end, room});
                count[room]++;

            } else {

                // No room available.
                // Take the room that becomes free earliest.
                long[] roomInfo = busy.poll();

                long freeTime = roomInfo[0];
                int room = (int) roomInfo[1];

                // Meeting is delayed until freeTime
                long newEnd = freeTime + duration;

                busy.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }

        // Find room with maximum meetings.
        // Iterating from 0 guarantees lowest room number on ties.
        int answer = 0;

        for (int room = 1; room < n; room++) {
            if (count[room] > count[answer]) {
                answer = room;
            }
        }

        return answer;
    }
}