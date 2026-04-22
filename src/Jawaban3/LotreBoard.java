package Jawaban3;

import java.util.Random;

class LotreBoard {
    char[][] board = new char[4][5];
    boolean[][] revealed = new boolean[4][5];
    int[][] data = new int[4][5]; // 0 = aman, 1 = bom

    int openedSafe = 0;
    boolean kenaBom = false;

    public void generateBoard() {
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = 0;
                revealed[i][j] = false;
            }
        }

        int bom = 0;
        while (bom < 2) {
            int r = rand.nextInt(4);
            int c = rand.nextInt(5);

            if (data[r][c] == 0) {
                data[r][c] = 1;
                bom++;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (!revealed[i][j]) {
                    System.out.print("* ");
                } else {
                    if (data[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            kenaBom = true;
            return false;
        } else {
            openedSafe++;
            System.out.println("Kotak Aman");
            return true;
        }
    }

    public boolean isGameOver() {
        if (kenaBom) return true;
        if (openedSafe == 18) return true;
        return false;
    }

    public void revealAll() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                revealed[i][j] = true;
            }
        }
    }
}
