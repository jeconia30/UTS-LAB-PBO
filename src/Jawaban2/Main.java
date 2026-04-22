package jawaban2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalKendaraan = 0;
        double totalSemuaBiaya = 0;
        char lanjut = 'y';

        do {
            System.out.println("==== Selamat Datang di Area ParkirChan ====");
            System.out.println("Jenis kendaraan (motor/mobil/truk): ");
            String jenis = input.nextLine();

            Kendaraan k = new Kendaraan(jenis);

            System.out.println("Pilih cara input durasi:");
            System.out.println("1. Input langsung (jam)");
            System.out.println("2. Input jam masuk & keluar");
            System.out.print("Pilihan: ");
            int pilihan = input.nextInt();

            double biaya = 0;

            if (pilihan == 1) {
                System.out.print("Masukkan durasi (jam): ");
                int durasi = input.nextInt();
                biaya = k.hitungBiaya(durasi);
            } else if (pilihan == 2) {
                System.out.print("Jam masuk: ");
                int masuk = input.nextInt();

                System.out.print("Jam keluar: ");
                int keluar = input.nextInt();

                biaya = k.hitungBiaya(masuk, keluar);
            } else {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            k.tampilkan(biaya);

            totalKendaraan++;
            totalSemuaBiaya += biaya;

            input.nextLine();
            System.out.print("\nTambah kendaraan lagi? (y/n): ");
            lanjut = input.nextLine().toLowerCase().charAt(0);

        } while (lanjut == 'y' || lanjut == 'Y');

        System.out.println("\n=== TOTAL AKHIR ===");
        System.out.println("Total kendaraan: " + totalKendaraan);
        System.out.println("Total semua biaya: Rp" + totalSemuaBiaya);
    }
}