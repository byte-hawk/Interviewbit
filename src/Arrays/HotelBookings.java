/*
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input Format
First argument is an integer array A containing arrival time of booking.
Second argument is an integer array B containing departure time of booking.
Third argument is an integer C denoting the count of rooms.

Output Format
Return True if there are enough rooms for N bookings else return False.
Return 0/1 for C programs.

Example Input
Input 1:
 A = [1, 3, 5]
 B = [2, 6, 8]
 C = 1

Example Output
Output 1:
 0

Example Explanation
Explanation 1:
 At day = 5, there are 2 guests in the hotel. But I have only one room.
 */

package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookings {

    /*
        Approach:
            1. Sort for arrival & departure times
            2. traverse both the array and compare arrival & departure value and their respective indices
            3. If arrival is less than or equal to departure, then 1 one guest has left and room's requirement can be reduced
            4. Else, rooms required needs to increased by 1.
            5. Once maximum required rooms has been calculated, we can check, whether its in limit or not
     */

    /**
     * Check, whether the hotel can accommodate bookings or not
     * @param arrival
     * @param departure
     * @param K
     * @return
     */
    public boolean hotel(ArrayList<Integer> arrival, ArrayList<Integer> departure, int K) {

        if(arrival == null || departure==null || arrival.size() != departure.size())    return true;
        Collections.sort(arrival);
        Collections.sort(departure);
        int n=arrival.size(), maxRoomsRequired= 1, roomsRequired = 1, arrivalIndex=1, departureIndex=0;

        while(arrivalIndex < n && departureIndex < n){
            if(arrival.get(arrivalIndex) < departure.get(departureIndex)){
                roomsRequired++;
                arrivalIndex++;
            }
            else {
                roomsRequired--;
                departureIndex++;
            }
            maxRoomsRequired = Math.max(maxRoomsRequired, roomsRequired);
        }

        return maxRoomsRequired <= K;
    }
}
