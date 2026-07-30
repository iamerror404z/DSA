class Solution {

    // Computes water trapped between the current tall bar (rightBar) and the
    // next-taller bar remaining in the stack, minus the volume already
    // occupied by shorter bars we pop along the way.
    private int amountOfWater(Stack<Integer> stack, int[] heights, int rightBarIndex) {
        int rightBar = heights[rightBarIndex];
        int occupiedVolume = 0;
        int leftBarIndex = rightBarIndex; // will be overwritten before use

        while (!stack.isEmpty() && rightBar > heights[stack.peek()]) {
            int barIndex = stack.pop();
            int barHeight = heights[barIndex];

            // width this bar occupies up to whatever's now on top of the stack
            int nextIndex = stack.isEmpty() ? barIndex : stack.peek();
            occupiedVolume += (nextIndex - barIndex) * barHeight;

            leftBarIndex = barIndex;
        }

        // If a taller bar remains, it's the real left wall of this pool.
        if (!stack.isEmpty()) {
            leftBarIndex = stack.peek();
        }

        int leftBar = heights[leftBarIndex];
        int width = leftBarIndex - rightBarIndex - 1;
        int capacity = width * Math.min(rightBar, leftBar);

        return Math.max(0, capacity - occupiedVolume);
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int totalWater = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            int topHeight = height[stack.peek()];
            if (height[i] > topHeight) {
                totalWater += amountOfWater(stack, height, i);
            }
            stack.push(i);
        }

        return totalWater;
    }
}