class Solution {

    public int revNumber(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
            set.add(revNumber(n));
        }

        return set.size();
    }
}