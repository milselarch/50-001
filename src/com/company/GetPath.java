package com.company;

import java.util.ArrayList;

public class GetPath {
    public static void showPath(ArrayList<Point> path, final int[][] grid) {
        for (Point point: path) {
            int x = point.x;
            int y = point.y;

            int value = grid[y][x];
            System.out.print(point);
            System.out.print(" value = ");
            System.out.println(value);
        }

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                Point point = new Point(x, y);
                System.out.print(point);
                System.out.print(" = ");
                int value = grid[y][x];
                System.out.println(value);
            }
        }
    }

    public static boolean getPath(
        int r, int c, ArrayList<Point> path, final int[][] grid
    ) {
        int x = 0;
        int y = 0;

        if (path.size() == 0) {
            path.add(new Point(0, 0));
        } else {
            Point lastPoint = path.get(path.size() - 1);
            x = lastPoint.x;
            y = lastPoint.y;
        }

        if ((r < 0) || (c < 0)) {
            return false;
        } else if ((y > r) || (x > c)) {
            return false;
        } else if ((y >= grid.length) || (x >= grid[0].length)) {
            return false;
        } else if (grid[y][x] == 1) {
            return false;
        } else if ((c==x) && (r==y)) {
            return true;
        }

        ArrayList<Point> subpath1 = new ArrayList<>(path);
        ArrayList<Point> subpath2 = new ArrayList<>(path);
        // ArrayList<Point> subpath3 = new ArrayList<>(path);

        subpath1.add(new Point(x, y+1));
        subpath2.add(new Point(x+1, y));
        // subpath3.add(new Point(x+1, y+1));

        if (GetPath.getPath(r, c, subpath1, grid)) {
            path.clear();
            path.addAll(new ArrayList<>(subpath1));
            return true;
        }

        if (GetPath.getPath(r, c, subpath2, grid)) {
            path.clear();
            path.addAll(new ArrayList<>(subpath2));
            return true;
        }

        return false;
    }
}
