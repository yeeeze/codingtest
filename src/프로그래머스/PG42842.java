package 프로그래머스;

public class PG42842 {
    /**
     * 수학 문제인 것 같다..
     *
     * 나머지가 0일 때 = 나누어떨어질 때만
     * 계산해야한다는걸 놓쳤음
     */

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {
            int row = i;
            if (yellow % row != 0) {
                continue;
            }
            int col = yellow / row;

            int nRow = row + 2;
            int nCol = col + 2;

            if ((nRow * nCol) - yellow == brown) {
                answer[0] = nCol;
                answer[1] = nRow;
                break;
            }
        }

        return answer;
    }

}
