import java.util.HashSet;
import java.util.Set;

public class L874_Walking_Robot_Simulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int distance = 0;
        int cur = 0;
        // direction = 0, 北；1，东；2，南；3，西
        int direction = 0;
        for (int command : commands) {
            if (command == -2) {
                direction -= 1;
                if (direction == -1) {
                    direction = 3;
                }
            } else if (command == -1) {
                direction += 1;
                if (direction == 4) {
                    direction = 0;
                }
            } else {
                switch (direction) {
                    case 0:
                        while (command > 0) {
                            y++;
                            if (!canMove(obstacles, x, y)){
                                y--;
                                break;
                            }
                            command--;
                        }
                        break;
                    case 1:
                        while (command > 0) {
                            x++;
                            if (!canMove(obstacles, x, y)){
                                x--;
                                break;
                            }
                            command--;
                        }
                        break;
                    case 2 :
                        while (command > 0) {
                            y--;
                            if (!canMove(obstacles, x, y)){
                                y++;
                                break;
                            }
                            command--;
                        }
                        break;
                    case 3:
                        while (command > 0) {
                            x--;
                            if (!canMove(obstacles, x, y)) {
                                x++;
                                break;
                            }
                            command--;
                        }
                        break;
                }
                cur = x*x + y*y;
                if (cur > distance){
                    distance = cur;
                }
            }
        }
        return distance;
    }

    public boolean canMove(int[][] obstacles, int x, int y) {
        for (int[] obs : obstacles) {
            if (obs[0] == x && obs[1] == y) {
                return false;
            }
        }
        return true;
    }

    /**
     * 前面解法每次判断是否有障碍物都要遍历obstacles，效率较低
     * 可将obstacles存入hashset中，每次判断时只要O（1）时间
     */
    public int robotSim2(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int ans = 0;
        int x = 0, y = 0, di = 0;
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            int ox = obstacle[0] + 30000;
            int oy = obstacle[1] + 30000;
            set.add((ox << 16) + oy);
        }
        for (int command : commands) {
            if (command == -2) {
                di = (di + 3) % 4;
            } else if (command == -1) {
                di = (di + 1) % 4;
            } else {
                while (command > 0) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    int code = ((nx + 30000) << 16) + (ny + 30000);
                    if (!set.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                    command--;
                }
            }
        }
        return ans;
    }
}
