
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         Map<Integer, Integer> next = new HashMap<>(nums2.length * 2);
        Deque<Integer> st = new ArrayDeque<>(); 

        for (int i = nums2.length - 1; i >= 0; i--) {
            int x = nums2[i];
            while (!st.isEmpty() && st.peek() <= x) st.pop();
            int ng = st.isEmpty() ? -1 : st.peek(); // single branch
            next.put(x, ng);
            st.push(x);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = next.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
