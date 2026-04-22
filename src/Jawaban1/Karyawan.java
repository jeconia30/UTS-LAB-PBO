package Jawaban1;

class Karyawan {
    String id;
    String nama;
    String posisi;
    double gaji;

    // Constructor
    public Karyawan(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    // Tampilkan data
    public void tampil() {
        System.out.println("ID: " + id +
                ", Nama: " + nama +
                ", Posisi: " + posisi +
                ", Gaji: Rp" + gaji);
    }
}