class Solution {
    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchsticks);

        int[] sides = new int[4];

        return backtrack(
            matchsticks,
            matchsticks.length - 1,
            sides,
            target
        );
    }

    private boolean backtrack(int[] sticks, int index,
                              int[] sides, int target) {

        if (index < 0) {
            return true;
        }

        int stick = sticks[index];

        for (int i = 0; i < 4; i++) {

            if (sides[i] + stick > target) {
                continue;
            }

            sides[i] += stick;

            if (backtrack(sticks, index - 1, sides, target)) {
                return true;
            }

            sides[i] -= stick;
        }

        return false;
    }
}