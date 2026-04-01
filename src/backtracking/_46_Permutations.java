package backtracking;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        dfs(nums.length, temp, used, nums);
        return ans;
    }

    public void dfs(int n, List<Integer> temp, boolean[] used, int[] nums) {
        if (temp.size() == n) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(n, temp, used, nums);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
