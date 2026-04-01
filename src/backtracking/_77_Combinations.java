package backtracking;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：剩余可选数字数量不足以凑满 k 个时直接返回
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);

        dfs(cur + 1, n, k);
    }
}
