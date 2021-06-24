package leetcode;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/24/21 11:13 AM
 */
public class T0036_IsValidSudoku {

    public static void main(String[] args) {
        T0036_IsValidSudoku t = new T0036_IsValidSudoku();
        char[][] b = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(t.isValidSudoku(b));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] t = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                //验证行是否只出现一次
                for (int k = j + 1; k < board[0].length; k++) {
                    if (board[i][j] == board[i][k]) {
                        return false;
                    }
                }
                //验证列是否只出现一次
                for (int k = i + 1; k < board.length; k++) {
                    if (board[k][j] == board[i][j]) {
                        return false;
                    }
                }
                //验证3x3内是否只出现了一次
                int f = i / 3;
                int e = j / 3;
                for (int w = 0; w < 3; w++) {
                    for (int m = 0; m < 3; m++) {
                        int s = w + f * 3;
                        int l = m + e * 3;
                        if (board[s][l] == '.' || (s == i && l == j)) {
                            continue;
                        } else if (board[s][l] == board[i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
