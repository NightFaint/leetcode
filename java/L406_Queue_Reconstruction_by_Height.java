import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L406_Queue_Reconstruction_by_Height {
    /**
     * 1. Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
     * 2. For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
     * E.g.
     * input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * subarray after step 1: [[7,0], [7,1]]
     * subarray after step 2: [[7,0], [6,1], [7,1]]
     * ...
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : -a[0] + b[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
