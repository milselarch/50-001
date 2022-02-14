package com.company;

import java.util.ArrayList;

public class TestRobot {
    public static void test() {
        final int[][] grid0 = {
            {0, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 0, 0}
        };

        ArrayList<Point> path = new ArrayList<>();
        boolean success = GetPath.getPath(3, 2, path, grid0);

        System.out.println(success);
        if (success) {
            System.out.println("GRID1");
            System.out.println(path);
        }

        System.out.println("\nSTART GRID2\n");
        path.clear();

        final int[][] grid = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0}
        };

        success = GetPath.getPath(3, 2, path, grid);
        System.out.println(success);

        if (success) {
            System.out.println("GRID2");
            System.out.println(path);
        }

        path.clear();

        System.out.println("\nSTART GRID3\n");

        final int[][] grid2 = {
                {1}
        };

        success = GetPath.getPath(0, 0, path, grid2);
        System.out.println(success);

        if (success) {
            System.out.println("GRID3");
            System.out.println(path);
        }

        path.clear();
    }
}
