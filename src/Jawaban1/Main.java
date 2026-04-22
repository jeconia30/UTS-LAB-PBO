package Jawaban1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Perusahaan p = new Perusahaan();

        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua");
            System.out.println("6. Cari Karyawan");
            System.out.println("7. Total Gaji");
            System.out.println("8. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("ID: ");
                    String id = input.nextLine();

                    System.out.print("Nama: ");
                    String nama = input.nextLine();

                    System.out.print("Posisi: ");
                    String posisi = input.nextLine();

                    System.out.print("Gaji: ");
                    double gaji = input.nextDouble();
                    input.nextLine();

                    p.tambah(new Karyawan(id, nama, posisi, gaji));
                    break;

                case 2:
                    System.out.print("ID yang dihapus: ");
                    p.hapus(input.nextLine());
                    break;

                case 3:
                    System.out.print("ID: ");
                    String idPos = input.nextLine();
                    System.out.print("Posisi baru: ");
                    String posBaru = input.nextLine();
                    p.ubahPosisi(idPos, posBaru);
                    break;

                case 4:
                    System.out.print("ID: ");
                    String idGaji = input.nextLine();
                    System.out.print("Gaji baru: ");
                    double gajiBaru = input.nextDouble();
                    input.nextLine();
                    p.ubahGaji(idGaji, gajiBaru);
                    break;

                case 5:
                    p.tampilSemua();
                    break;

                case 6:
                    System.out.print("Masukkan ID: ");
                    p.cariKaryawan(input.nextLine());
                    break;

                case 7:
                    p.totalGaji();
                    break;

                case 8:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 8);

        input.close();
    }
}