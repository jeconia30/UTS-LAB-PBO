package Jawaban3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LotreBoard game = new LotreBoard();

        game.generateBoard();

        System.out.println("Welcome to E-Lottery Gosok");

        while (!game.isGameOver()) {
            game.displayBoard();

            System.out.print("\nMasukkan tebakan anda (baris dan kolom): ");
            int row = input.nextInt();
            int col = input.nextInt();

            if (row < 0 || row >= 4 || col < 0 || col >= 5) {
                System.out.println("Input tidak valid!");
                continue;
            }

            boolean aman = game.guess(row, col);

            if (!aman) {
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                break;
            }
        }

        game.revealAll();
        game.displayBoard();

        // Cek menang
        if (!game.kenaBom && game.openedSafe == 18) {
            System.out.println("Selamat anda menang!");
        }

        input.close();
    }
}
