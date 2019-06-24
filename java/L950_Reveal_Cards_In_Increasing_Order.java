import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L950_Reveal_Cards_In_Increasing_Order {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        // 使用双端队列存储数组下标
        Deque<Integer> index = new LinkedList<>();
        // 初始化下标
        for(int i = 0 ; i < N; i++) {
            index.add(i);
        }
        // 要返回的新数组
        int[] res = new int[N];
        // 排序数组
        Arrays.sort(deck);
        for(int i : deck) {
            res[index.pollFirst()] = i;
            // 数组不为空，模拟将下一张牌放在底下
            if(!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] a = {17,13,11,2,3,5,7};
        int[] res = deckRevealedIncreasing(a);
        System.out.println(res);
    }

}
