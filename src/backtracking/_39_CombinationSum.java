class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, new ArrayList<Integer>(), 0, target, 0);
        return ans;
    }

    public void dfs(int[] candidates, List<Integer> ans_list, int sum, int target, int idx){
        if(idx >= candidates.length){
            return ;
        }

        if(sum > target){
            return ;
        }else if(sum == target){
            ans.add(new ArrayList<Integer>(ans_list));
        }else if(sum < target){
            // 直接跳过
            sum += candidates[idx];
            ans_list.add(candidates[idx]);
            dfs(candidates,ans_list,sum,target,idx);
            sum -= candidates[idx];
            ans_list.remove(ans_list.size()-1);

            dfs(candidates,ans_list,sum,target,idx+1);
        }
    }
}
