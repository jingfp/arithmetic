package leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 480 👎 0

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        System.out.println(solution.solveNQueens(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        List<List<String>> result;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            result = new ArrayList<>();
            backtrace(1, new LinkedList<>());
            return result;
        }

        private void backtrace(int row, LinkedList<String> idxSeleted) {
            if (idxSeleted.size() == n) {
                result.add(new LinkedList<>(idxSeleted));
                return;
            }
            for (int i = 1; i < n + 1; i++) {
                if (!valid(i, idxSeleted)) {
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int tx = 0; tx < n; tx++) {
                    if (tx == i-1) {
                        stringBuilder.append('Q');
                    } else {
                        stringBuilder.append('.');
                    }
                }
                idxSeleted.add(stringBuilder.toString());
                backtrace(i, idxSeleted);
                idxSeleted.removeLast();
            }
        }

        private boolean valid(int index, LinkedList<String> idxSeleted) {
            if (idxSeleted.isEmpty()) {
                return true;
            }
            for (int i = 0; i < idxSeleted.size(); i++) {
                if (idxSeleted.get(i).indexOf("Q") == index -1) {
                    return false;
                }
            }
            for (int i = 0;i < idxSeleted.size();i++) {
                // 不能出现坐标位置边距相等的
                if (Math.abs(idxSeleted.size()  - i) == Math.abs(idxSeleted.get(i).indexOf("Q")+1 - index)) {
                    return false;
                }
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    class SolutionTwo {
        int n;
        List<List<Integer>> result;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            result = new ArrayList<>();
            backtrace(1, new LinkedList<>());
            System.out.println(result);
            return translate();
        }

        private void backtrace(int path, LinkedList<Integer> idxSeleted) {
            if (idxSeleted.size() == n) {
                result.add(new LinkedList<>(idxSeleted));
                return;
            }
            for (int i = 1; i < n + 1; i++) {
                if (!valid(i, idxSeleted)) {
                    continue;
                }
                idxSeleted.add(i);
                backtrace(i, idxSeleted);
                idxSeleted.removeLast();
            }
        }

        private boolean valid(int index, LinkedList<Integer> idxSeleted) {
            if (idxSeleted.isEmpty()) {
                return true;
            }
            if (idxSeleted.contains(index)) {
                // 不能包含同列的
                return false;
            }
            for (int i = 0;i < idxSeleted.size();i++) {
                // 不能出现坐标位置边距相等的
                if (Math.abs(idxSeleted.size()  - i) == Math.abs(idxSeleted.get(i) - index)) {
                    return false;
                }
            }
            return true;
        }

        private List<List<String>> translate() {
            List<List<String>> temp = new ArrayList<>();
            for (List<Integer> idx : result) {
                List<String> temp2 = new ArrayList<>();
                for (Integer content : idx) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < idx.size(); i++) {
                        if (i == content - 1) {
                            builder.append("Q");
                        } else {
                            builder.append(".");
                        }
                    }
                    temp2.add(builder.toString());
                }
                temp.add(temp2);
            }
            return temp;
        }
    }

}