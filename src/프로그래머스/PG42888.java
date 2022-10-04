package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class User {
    private String id, nickname;

    public User(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

class Command {
    char command;
    String userId;

    public Command(char command, String userId) {
        this.command = command;
        this.userId = userId;
    }
}

public class PG42888 {

    private static final String ENTER = "%s님이 들어왔습니다.";
    private static final String LEAVE = "%s님이 나갔습니다.";
    private static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        String[] re = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] solution = objectSolution(re);
        for (String s : solution) {
            System.out.println(s);
        }
    }

    public static String[] objectSolution(String[] record) {
        // id, UserInfo
        ArrayList<Command> result = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String action = st.nextToken();
            String id = st.nextToken();
            String newNickname = null;

            switch (action.charAt(0)) {
                case 'E':
                    newNickname = st.nextToken();
                    if (!users.containsKey(id)) {
                        users.put(id, new User(id, newNickname));
                    } else {
                        users.get(id).setNickname(newNickname);
                    }

                    result.add(new Command(action.charAt(0), id));
                    break;
                case 'C':
                    newNickname = st.nextToken();
                    users.get(id).setNickname(newNickname);
                    break;
                case 'L':
                    result.add(new Command(action.charAt(0), id));
                    break;
            }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).command == 'E') {
                answer[i] = users.get(result.get(i).userId).getNickname() + ENTER;
            } else {
                answer[i] = users.get(result.get(i).userId).getNickname() + LEAVE;
            }
        }
        return answer;

//        return result.stream()
//                .map(cmd -> String.format(cmd.command == 'E' ? ENTER : LEAVE, users.get(cmd.userId).getNickname()))
//                .toArray(ary -> new String[result.size()]);
    }

    public static String[] solution(String[] record) {
        // id, 닉네임
        HashMap<String, String> users = new HashMap<>();

        // 1. 마지막에 변경된 닉네임만 기록 (입장, 변경 시에만)
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String action = st.nextToken();
            String id = st.nextToken();

            if (!action.equals("Leave")) {
                String newNickname = st.nextToken();

                users.put(id, newNickname);
            }
        }

        // 2. 아이디, 행동 으로 아이디로 비교해서 닉네임 출력 (입장, 퇴장 시에만)
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String action = st.nextToken();
            String id = st.nextToken();

            if (action.equals("Enter")) {
                list.add(users.get(id) + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                list.add(users.get(id) + "님이 나갔습니다.");
            }
        }

        String[] answer = list.toArray(new String[0]);
        return answer;
    }


    public String[] badSolution(String[] record) {
        // id, 닉네임
        HashMap<String, String> users = new HashMap<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        String[] actionsArr = new String[record.length];

        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String action = st.nextToken();
            String id = st.nextToken();

            if (!action.equals("Leave")) {
                String newNickname = st.nextToken();

                if (!users.containsKey(id)) {
                    users.put(id, newNickname);
                }

                // 기존에 유저가 있었다면 닉넴 변경
                if (users.containsKey(id) && !users.get(id).equals(newNickname)) {
                    String removeNick = users.get(id);
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k).get(0).equals(id) && list.get(k).get(1).equals(removeNick)) {
                            list.get(k).set(1, newNickname);
                        }
                    }
                    users.put(id, newNickname);
                }
            }

            if (!action.equals("Change")) {
                list.add(new ArrayList<>());
                list.get(i).add(id);
                list.get(i).add(users.get(id));
                actionsArr[i] = action;
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (actionsArr[i].equals("Enter")) {
                answer[i] = list.get(i).get(1) + "님이 들어왔습니다.";
            } else if (actionsArr[i].equals("Leave")) {
                answer[i] = list.get(i).get(1) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
