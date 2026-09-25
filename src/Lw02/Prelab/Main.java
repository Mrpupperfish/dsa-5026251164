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

        while (!q.isEmpty()) {
            String[] dummy = q.poll();
            String nama = dummy[0];
            String tipe = dummy[1];
            int angka = Integer.parseInt(dummy[2]);

            for (String[] customer : data) {
                if (customer[0].equals(nama)) {
                    int saldo = Integer.parseInt(customer[1]);

                    if (tipe.equals("DEPOSIT")) {
                        customer[1] = (saldo + angka) + "";
                    } else {
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
            System.out.println(i[0] + " : " + i[1]);
        }

        System.out.println("\n=== Failed Transactions ===");
        while (!gagal.isEmpty()) {
            String[] i = gagal.pop();
            System.out.println(i[0] + ": " + i[1]);
        }
    }
}