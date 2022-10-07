package etcSite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Hacker_Climbing_the_Leaderboard {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(5, 25, 50, 120));

        StringTokenizer sb = new StringTokenizer("295 294 291 287 287 285 285 284 283 279 277 274 274 271 270 268 268 268 264 260 259 258 257 255 252 250 244 241 240 237 236 236 231 227 227 227 226 225 224 223 216 212 200 197 196 194 193 189 188 187 183 182 178 177 173 171 169 165 143 140 137 135 133 130 130 130 128 127 122 120 116 114 113 109 106 103 99 92 85 81 69 68 63 63 63 61 57 51 47 46 38 30 28 25 22 15 14 12 6 4");
        int i1 = sb.countTokens();
        for (int i = 0; i < i1; i++) {
            a.add(Integer.parseInt(sb.nextToken()));
        }

        sb = new StringTokenizer("5 5 6 14 19 20 23 25 29 29 30 30 32 37 38 38 38 41 41 44 45 45 47 59 59 62 63 65 67 69 70 72 72 76 79 82 83 90 91 92 93 98 98 100 100 102 103 105 106 107 109 112 115 118 118 121 122 122 123 125 125 125 127 128 131 131 133 134 139 140 141 143 144 144 144 144 147 150 152 155 156 160 164 164 165 165 166 168 169 170 171 172 173 174 174 180 184 187 187 188 194 197 197 197 198 201 202 202 207 208 211 212 212 214 217 219 219 220 220 223 225 227 228 229 229 233 235 235 236 242 242 245 246 252 253 253 257 257 260 261 266 266 268 269 271 271 275 276 281 282 283 284 285 287 289 289 295 296 298 300 300 301 304 306 308 309 310 316 318 318 324 326 329 329 329 330 330 332 337 337 341 341 349 351 351 354 356 357 366 369 377 379 380 382 391 391 394 396 396 400");
        int i2 = sb.countTokens();
        for (int i = 0; i < i2; i++) {
            b.add(Integer.parseInt(sb.nextToken()));
        }

        List<Integer> integers = climbingLeaderboard(a, b);
        for (int d : integers) {
            System.out.println(d);
        }
    }

    /**
     * list의 원소 비교할 때는 == 말고 equals를 쓰자
     *
     * 오름차순으로 데이터가 들어오니까 값을 갱신할 필요가 없네!!
     * 다음 탐색 값들은 갱신이 안되는 앞쪽 원소들만 해당되니까...
     *
     * <시간초과 났던 이유>
     * 랭크 리스트에 player 점수를 직접 추가를 해주는 작업을 추가로 해서 시간초과가 났다 (안 해도 되는 작업)
     * list의 메소드들을 많이 사용했더니 시초 발생함
     * contains(), indexOf() 등...
     * 그냥 이진탐색으로 인덱스들만 탐색하고 정답 리스트에 인덱스 숫자만 넣어주면 됨
     */
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // 순위 저장한다 200,000
        // 넣고 (이진탐색 LogN 200,000 -> 17)

        // n(20만)개의 리스트에서 m개(20만)의 데이터를 탐색해서 인덱스 얻기 -> n * m -> 40억..

        // 중복제거하면서 현재 순위값 계산
        ArrayList<Integer> list = new ArrayList<>();
        list.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                list.add(ranked.get(i));
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            // 이미 있으면 랭크 순위 add
//            if (list.contains(player.get(i))) {
//                answer.add(list.indexOf(player.get(i)) + 1);
//                continue;
//            }

            // 넣을 인덱스를 이진탐색으로 찾음
            int left = 0;
            int right = list.size() - 1;
            int target = player.get(i);
            int index = 0;
//            boolean flag = false;
            while (left <= right) {
                int mid = (left + right) / 2;

//                if (target == list.get(mid)) {
//                    answer.add(mid + 1);
//                    flag = true;
//                    break;
//                }

                if (target < list.get(mid)) {
                    left = mid + 1;
                    index = left;
                } else {
                    right = mid - 1;
                    index = mid;
                }
            }

//            if (flag) {
//                continue;
//            }

//            if (index == -1) {
//                index = 0;
//            }
            // list.add(index, target);  -> 값 직접 갱신할 필요 없음
            answer.add(index + 1);
        }

        return answer;
    }
}
