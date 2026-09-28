package Lw02.Unguided;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> buku = new LinkedList<>();
        LinkedList<String[]> member = new LinkedList<>();
        Queue<String[]> q = new LinkedList<>();
        Stack<String[]> gagal = new Stack<>();
        Queue<String[]> sukses = new LinkedList<>();
        buku.add(new String[] {"Kalkulus", "2"});
        buku.add(new String[] {"Fisika", "1"});
        buku.add(new String[] {"Statistika", "2"});
        
        while(sc.hasNext()){
            String nama = sc.next();
            String book = sc.next();
            String[] s = {nama, book};
            request.add(s);

            boolean cek = false;

            for(String[] i : member){
                if(i[0].equals(nama)){
                    cek = true;
                    break;
                }
            }

            if (!cek) {
                String[] p = {nama, "0" };
                member.add(p);
            }
        }

        
        for (int i = 0; i < request.size(); i++) {
            q.add(request.get(i));
        }
        

        while(!q.isEmpty()){
            //define permintaan nya 
            String[] s = q.poll();
            String nama = s[0];
            String permintaan = s[1];
            
            //cari member 
            for(String[] i : member){
                if(i[0].equals(nama)){
                    //cek apakah member masih bisa pinjem
                    int quota = Integer.parseInt(i[1]);
                    if(quota == 2){
                        gagal.push(new String[] {nama, permintaan});
                    }
                    else{
                        //jmlh buku sisa
                        for(String[] j : buku){
                            if(j[0].equals(permintaan)){ 
                                int sisa_buku = Integer.parseInt(j[1]);
                                
                                if(sisa_buku == 0){ 
                                    gagal.push(new String[] {nama, permintaan});
                                } 
                                else { 
                                    sisa_buku--;
                                    j[1] = sisa_buku + "";

                                    quota++;
                                    i[1] = quota + "";
                                    
                                    sukses.add(new String[] {nama, permintaan});
                                }
                                break; 
                            }
                        }
                        
                    }
                    break;
                }

            }

        }

        System.out.println("=== Successfully Processed Requests ===");
        while (!sukses.isEmpty()) {
            String[] i = sukses.poll();
            System.out.println(i[0] + " " + i[1]);
        }

        System.out.println("=== Remaining Book Stock ==="); 
        for(String[] i : buku){
            System.out.println(i[0] + " : " + i[1]); 
        }

        System.out.println("=== Failed Requests ===");
        while (!gagal.isEmpty()) {
            String[] i = gagal.pop();
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
