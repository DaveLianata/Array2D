package Tugas_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nota_pembelian {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] dataBarang = new String[5][4];


        dataBarang[0][0] = "sabun";
        dataBarang[0][1] = "1";
        dataBarang[0][2] = "3000";
        dataBarang[1][0] = "indomie goreng";
        dataBarang[1][1] = "2";
        dataBarang[1][2] = "2500";
        dataBarang[2][0] = "le minerale";
        dataBarang[2][1] = "2";
        dataBarang[2][2] = "3000";
        dataBarang[3][0] = "silverqueen";
        dataBarang[3][1] = "1";
        dataBarang[3][2] = "14000";
        dataBarang[4][0] = "sunsilk 400ml";
        dataBarang[4][1] = "1";
        dataBarang[4][2] = "20000";


        int jumlah = 0;
        int total = 0;


        System.out.println("=====================================================");
        System.out.printf("%-25s %-10s %-10s %-10s\n", "Nama Barang", "Jumlah", "Harga Jual", "Total");
        System.out.println("=====================================================");

        // Menampilkan data barang
        for (int i = 0; i < dataBarang.length; i++) {
            // Menghitung total untuk setiap barang yang dibeli
            total = Integer.parseInt(dataBarang[i][1]) * Integer.parseInt(dataBarang[i][2]);

            // Menampilkan data barang dan total harga
            System.out.printf("%-25s %-10s %-10s %-10s\n", dataBarang[i][0], dataBarang[i][1], dataBarang[i][2], total);

            // Menambahkan total harga
            jumlah += total;
        }

        // Menampilkan grand total beserta uang yang di bayarkan
        System.out.println("=====================================================");
        System.out.printf("%-25s %-10s\n", "Grand Total : ", jumlah);
        System.out.print("Tunai : ");
        int uangDibayarkan = Integer.parseInt(br.readLine());

        // Menghitung kembalian
        int kembali = uangDibayarkan - jumlah;

        // Untuk menampilkan kembalian
        System.out.printf("%-25s %-10s\n", "Kembali : ", kembali);
    }
}

