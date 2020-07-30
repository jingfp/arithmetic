package leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 320 👎 0

import java.util.LinkedList;
import java.util.List;

public class J_77_Combinations {
    public static void main(String[] args) {
        Solution solution = new J_77_Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result;
        int n;
        int k;

        public List<List<Integer>> combine(int n, int k) {
            result = new LinkedList<>();
            this.n = n;
            this.k = k;
            back(1, new LinkedList<>());
            return result;
        }

        private void back(int idx, LinkedList<Integer> cur) {
            if (cur.size() == k) {
                result.add(new LinkedList<>(cur));
                return;
            }
            for (int temp = idx; temp < n + 1; temp++) {
                cur.add(temp);
                back(temp + 1, cur);
                cur.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


