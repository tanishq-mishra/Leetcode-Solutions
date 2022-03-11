class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        HashSet<List<Integer>> finalResult = new HashSet<>();
        permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
        return new ArrayList(finalResult);
    }

    private void permuteRecur(int[] nums, HashSet<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            currResult.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }
}