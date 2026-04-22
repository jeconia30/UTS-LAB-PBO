package jawaban2;

public class Kendaraan {
    String jenis;
    int durasi; // dalam jam

    public Kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
    }

    // Method overloading 1 → input langsung durasi
    public double hitungBiaya(int durasi) {
        this.durasi = durasi;
        return hitung();
    }

    // Method overloading 2 → dari jam masuk & keluar
    public double hitungBiaya(int jamMasuk, int jamKeluar) {
        this.durasi = jamKeluar - jamMasuk;
        return hitung();
    }

    // Method utama untuk hitung biaya
    private double hitung() {
        double tarif = 0;

        switch (jenis) {
            case "motor":
                tarif = 2000;
                break;
            case "mobil":
                tarif = 5000;
                break;
            case "truk":
                tarif = 8000;
                break;
            default:
                System.out.println("Jenis kendaraan tidak valid!");
        }

        double total = tarif * durasi;

        // Diskon 10% jika > 5 jam
        if (durasi > 5) {
            total *= 0.9;
        }

        return total;
    }

    public void tampilkan(double totalBiaya) {
        System.out.println("\n=== RINGKASAN ===");
        System.out.println("Jenis Kendaraan: " + jenis);
        System.out.println("Durasi: " + durasi + " jam");
        System.out.println("Total Biaya: Rp" + totalBiaya);
    }
}
