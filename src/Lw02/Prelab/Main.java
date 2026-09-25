package Lw02.Prelab;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        LinkedList<String[]> transaksi = new LinkedList<>();
        LinkedList<String[]> data = new LinkedList<>();
        Queue<String[]> q = new LinkedList<>();
        Stack<String[]> gagal = new Stack<>();

        while (sc.hasNext()) {
            String nama = sc.next();
            String type = sc.next();
            String amount = sc.next();
            String[] s = { nama, type, amount };
            transaksi.add(s);

            boolean cek = false;
            // PERBAIKAN 1: Cek nama ke list 'data' pelanggannya, bukan ke transaksi
            for (String[] i : data) {
                if (i[0].equals(nama)) {
                    cek = true;
                    break;
                }
            }

            if (!cek) {
                String[] p = { nama, "0" };
                data.add(p);
            }
        }

        for (int i = 0; i < transaksi.size(); i++) {
            q.add(transaksi.get(i));
        }

        // PERBAIKAN 2: Gunakan while untuk menguras Queue
        while (!q.isEmpty()) {
            String[] dummy = q.poll();
            String nama = dummy[0];
            String tipe = dummy[1];
            int angka = Integer.parseInt(dummy[2]);

            // Cari pelanggan yang cocok di list 'data'
            for (String[] customer : data) {
                if (customer[0].equals(nama)) {
                    int saldo = Integer.parseInt(customer[1]);

                    if (tipe.equals("DEPOSIT")) {
                        customer[1] = (saldo + angka) + "";
                    } else {
                        // PERBAIKAN 3: Cek kecukupan saldo sebelum ditarik
                        if (angka > saldo) {
                            String[] habibi = { nama, angka + "" };
                            gagal.push(habibi);
                        } else {
                            customer[1] = (saldo - angka) + "";
                        }
                    }
                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] i : data) {
            // PERBAIKAN 4: Saldo ada di indeks 1, bukan 2
            System.out.println(i[0] + " : " + i[1]);
        }

        System.out.println("\n=== Failed Transactions ===");
        // PERBAIKAN 5: Cetak dari Stack 'gagal' menggunakan pop()
        while (!gagal.isEmpty()) {
            String[] i = gagal.pop();
            System.out.println(i[0] + ": " + i[1]);
        }
    }
}