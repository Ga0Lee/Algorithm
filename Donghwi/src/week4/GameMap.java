package week4;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameMap {
    private static int n;
    private static int m;
    private static int[][] visited;

    public void result() {
        int[][] map = new int[][] {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        System.out.println(solution(map));
    }

    private int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];

        return bfs(maps, 0, 0);
    }

    private int bfs(int[][] maps, int x, int y) {
        var dx = List.of(-1, 1, 0, 0);
        var dy = List.of(0, 0, -1, 1);

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cx = point.x;
            int cy = point.y;

            if(cx == n - 1 && cy == m - 1) {
                return visited[cx][cy];
            }

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx.get(k);
                int ny = cy + dy.get(k);

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = visited[cx][cy] + 1;
                }
            }
        }
        return -1;
    }
}
