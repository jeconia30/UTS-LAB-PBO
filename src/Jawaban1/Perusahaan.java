package Jawaban1;

import java.util.ArrayList;

class Perusahaan {
    ArrayList<Karyawan> daftar = new ArrayList<>();

    // Cek ID
    private boolean idAda(String id) {
        for (Karyawan k : daftar) {
            if (k.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Cari karyawan
    private Karyawan cari(String id) {
        for (Karyawan k : daftar) {
            if (k.id.equals(id)) {
                return k;
            }
        }
        return null;
    }

    // 🔍 FITUR: Cari karyawan
    public void cariKaryawan(String id) {
        Karyawan k = cari(id);
        if (k != null) {
            System.out.println("Karyawan ditemukan:");
            k.tampil();
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    // Tambah
    public void tambah(Karyawan k) {
        if (idAda(k.id)) {
            System.out.println("ID sudah digunakan!");
            return;
        }
        if (k.gaji < 0) {
            System.out.println("Gaji tidak boleh negatif!");
            return;
        }
        daftar.add(k);
        System.out.println("Karyawan berhasil ditambahkan.");
    }

    // Hapus
    public void hapus(String id) {
        Karyawan k = cari(id);
        if (k != null) {
            daftar.remove(k);
            System.out.println("Karyawan berhasil dihapus.");
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    // Ubah posisi
    public void ubahPosisi(String id, String posisiBaru) {
        Karyawan k = cari(id);
        if (k != null) {
            k.posisi = posisiBaru;
            System.out.println("Posisi berhasil diubah.");
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    // Ubah gaji
    public void ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gaji tidak boleh negatif!");
            return;
        }

        Karyawan k = cari(id);
        if (k != null) {
            k.gaji = gajiBaru;
            System.out.println("Gaji berhasil diubah.");
        } else {
            System.out.println("Karyawan tidak ditemukan.");
        }
    }

    // Tampilkan semua
    public void tampilSemua() {
        if (daftar.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        for (Karyawan k : daftar) {
            k.tampil();
        }
    }

    // 📊 FITUR: Total gaji
    public void totalGaji() {
        double total = 0;
        for (Karyawan k : daftar) {
            total += k.gaji;
        }
        System.out.println("Total seluruh gaji: Rp" + total);
    }
}