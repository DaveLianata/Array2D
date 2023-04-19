package Tugas_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

   package kasir;
import java.util.*;
import java.io.*;
    public class Kasir {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Scanner inputa = new Scanner(System.in);


            String[][] barang = new String[10][3];
            barang[0][0] = "Sabun";
            barang[0][1] = "3000";
            barang[0][2] = "10";


            barang[1][0] = "Indomie Goreng";
            barang[1][1] = "2500";
            barang[1][2] = "10";

            barang[2][0] = "Le Minerale";
            barang[2][1] = "3000";
            barang[2][2] = "10";

            barang[3][0] = "SilverQueen";
            barang[3][1] = "14000";
            barang[3][2] = "20";

            barang[4][0] = "Sunslik 400ml";
            barang[4][1] = "20000";
            barang[4][2] = "10";


            while (true) {
                int index = 0;
                for (int i = 0; i < 10; i++) {
                    if (barang[i][0] == null) break;
                    index = i;
                }

                System.out.println("===TOKO===");
                System.out.println("1. List Barang\n"
                        + "2. Kasir/Transaksi\n"
                        + "3. Keluar\n");
                System.out.print("Masukkan Pilihan : ");
                int pilihan = inputa.nextInt();
                System.out.println();
                switch (pilihan) {
                    case 1:
                        System.out.println("++List Barang++");
                        for (int i = 0; i < 10; i++) {
                            if (barang[i][0] == null) break;
                            System.out.println((i+1)+". |"+barang[i][0]+" \t| Rp."+barang[i][1]+" \t| Stok : "+barang[i][2]);
                        }
                        break;

                    case 2:
                        System.out.println("++KASIR++");
                        try {
                            System.out.print("Nama Pelanggan \t: ");
                            String nama = input.nextLine();

                            String status = "", kalimat = "", nama_barang;
                            int total = 0, bayar = 0;
                            boolean ok = true;
                            kalimat += "DETAIL PEMBELIAN OLEH "+nama+" \r\n";
                            while (!"OK".equalsIgnoreCase(status)) {
                                int brp = 100, stok_barang = 0, stok_akhir = 0, harga_barang = 0, jumlah = 0;

                                System.out.print("Nama Barang \t: ");
                                nama_barang = input.nextLine();

                                for (int i = 0; i < 10; i++) {
                                    if (barang[i][0] == null) break;
                                    if (barang[i][0].equalsIgnoreCase(nama_barang)) {
                                        brp = i;
                                        harga_barang = Integer.parseInt(barang[i][1]);
                                        stok_barang = Integer.parseInt(barang[i][2]);
                                    }
                                }
                                if (brp == 100) {
                                    System.out.println("Nama Barang tidak ditemukan!");
                                    ok = false;
                                } else {
                                    ok = true;
                                }

                                if (ok) {
                                    System.out.print("Jumlah \t: ");
                                    jumlah = inputa.nextInt();

                                    stok_akhir = stok_barang-jumlah;
                                    if (stok_barang == 0 || stok_akhir < 0 || jumlah <= 0) {
                                        System.out.println("Stok barang tidak cukup!");
                                        ok = false;
                                    } else {
                                        barang[brp][2] = String.valueOf(stok_akhir);
                                        ok = true;
                                        total += jumlah*harga_barang;
                                    }
                                }

                                if (ok) {
                                    kalimat += nama_barang+" \t| "+jumlah+"pcs \t| Rp."+harga_barang+" \t|Rp."+(jumlah*harga_barang)+""+" \r\n";
                                    System.out.print("Sudah? : (ok)");
                                    status = input.nextLine();
                                }
                            }

                            System.out.println("TOTAL \t\t| Rp."+total);
                            while (bayar <= total) {
                                System.out.print("Jumlah Bayar \t| Rp.");
                                bayar = inputa.nextInt();
                            }
                            System.out.println("KEMBALI \t| Rp."+(bayar-total));

                            kalimat += " \r\n";
                            kalimat += "TOTAL \t\t\t\t\t| Rp."+total+" \r\n";
                            kalimat += "BAYAR \t\t\t\t\t| Rp."+bayar+" \r\n";
                            kalimat += "KEMBALI \t\t\t\t\t| Rp."+(bayar-total)+" \r\n";

                            if (ok) {
                                File yourFile = new File("D:\\Coba\\"+nama+".txt");
                                yourFile.createNewFile();
                                FileOutputStream tujuan = new FileOutputStream(yourFile, false);
                                PrintWriter p = new PrintWriter(tujuan);


                                p.print(kalimat);
                                p.close();

                                System.out.println("Transaksi Sukses!");
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        System.out.println("Terima Kasih!");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan Salah!");
                }
                System.out.println();
            }
        }

    }
