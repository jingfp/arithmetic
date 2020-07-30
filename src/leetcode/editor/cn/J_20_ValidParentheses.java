package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1728 👎 0

public class J_20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new J_20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("[sadf]["));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            char[] temp = new char[chars.length];
            int idx = 0;
            for (int i = 0; i < chars.length; i++) {
                switch (chars[i]) {
                    case '}':
                        if (idx == 0) {
                            return false;
                        }
                        if (temp[idx - 1] == '{') {
                            idx--;
                            break;
                        } else {
                            return false;
                        }
                    case ']':
                        if (idx == 0) {
                            return false;
                        }
                        if (temp[idx - 1] == '[') {
                            idx--;
                            break;
                        } else {
                            return false;
                        }
                    case ')':
                        if (idx == 0) {
                            return false;
                        }
                        if (temp[idx - 1] == '(') {
                            idx--;
                            break;
                        } else {
                            return false;
                        }
                    case '[':
                    case '{':
                    case '(':
                        temp[idx++] = chars[i];
                        break;
                }
            }

            return idx == 0 ? true : false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


