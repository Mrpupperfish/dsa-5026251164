package Lw03.PreLab;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        List <String> nama_lagu = new ArrayList<>(); //simpen lagu

        //kasus 1 
        while(sc1.hasNextLine()){
            
            //setup
            int idx = -1;
            String comand = sc1.next();
            //khusus insert 
            if(comand.equalsIgnoreCase("insert")){
                String dummy  = sc1.next();
                idx = Integer.parseInt(dummy);
            }

            String lagu = sc1.nextLine();
            

            //process
            if(comand.equalsIgnoreCase("add")){
                nama_lagu.add(lagu);
            }
            else if(comand.equalsIgnoreCase("insert") && idx != -1){
                nama_lagu.add(idx, lagu);
            }
            else if(comand.equalsIgnoreCase("remove")){
                for(int i = 0; i < nama_lagu.size(); i++){
                    if(nama_lagu.get(i).equals(lagu)){
                        nama_lagu.remove(i);
                        break;
                    }
                }
            }
           

        }
        //output
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + nama_lagu.size());
        for(int i = 0; i < nama_lagu.size(); i++){
            System.out.println((i+1) + " : " + nama_lagu.get(i));
        }

        //kasus 2
        List<String> nama = new ArrayList<>();
        Set <String> answ = new LinkedHashSet<>();
        while(sc2.hasNext()){
            String dummy = sc2.next();
            if(!answ.contains(dummy)){
                // System.out.println(dummy);
                answ.add(dummy);
            }
            nama.add(dummy);
        }
        
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + answ.size());
        int x = 1;
        for(String s : answ){
            System.out.println(x + ". " + s);
            x++;
        }
        System.out.println("Duplicate registrations: " + (nama.size()-(answ.size())));

        

        //kasus 3 
        Map<String, Integer> m = new LinkedHashMap<>();
        int gagal = 0;

        while(sc3.hasNext()){
            String perintah = sc3.next();
            String barang = sc3.next();
            int jumlah = Integer.parseInt(sc3.next());

            if(perintah.equalsIgnoreCase("ADD")){
                if(m.containsKey(barang)){
                    m.put(barang, m.get(barang)+jumlah );
                }
                else{
                    m.put(barang, jumlah);
                }
            }
            else if(perintah.equalsIgnoreCase("SELL")){
                if(!m.containsKey(barang)){
                    gagal++;
                    continue;
                }
                int stock = m.get(barang);
                if(stock < jumlah){
                    gagal++;
                }
                else{
                    m.put(barang, stock-jumlah);
                }
            }
        }

        System.out.println("===== Problem 3 =====");
        for(Map.Entry<String, Integer> i : m.entrySet()) {
            String key = i.getKey();
            int val = i.getValue();
            System.out.println(key + ": " + val);
        }
        System.out.println("Failed sales: " + gagal);
    }
}
