package Lw03.Unguided;

import java.lang.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map <String, Integer> m = new LinkedHashMap<>();
        int failed = 0;
        List < Map<String, Integer>> l = new LinkedList<>();
        System.out.println("===== Enrollment Checks =====");
        while(sc.hasNext()){
            String perintah = sc.next();
            String code = sc.next();

            if(perintah.equalsIgnoreCase("CHECK")){
                // System.out.println("aoidha");
                if(m.containsKey(code)){
                    System.out.println(code + " : " + m.get(code));
                }
                else{
                    System.out.println(code + " : Not Found");
                }
                continue;
            }

            int jumlah = sc.nextInt();
            sc.nextLine();

            if(perintah.equals("REGISTER")){
                if(!m.containsKey(code)){
                    m.put(code, jumlah);
                }
                else{
                    int sum = m.get(code);
                    sum+= jumlah;
                    m.put(code, sum);
                }
            }
            else if(perintah.equals("WITHDRAW")){
                if(m.get(code) == null){
                    failed++;
                }
                else if(m.get(code) < jumlah){
                    failed++;
                }
                else{
                    m.put(code, m.get(code) - jumlah);
                }
            }
        }
        System.out.println();

        System.out.println("===== Final Enrollment =====");
        for(Map.Entry<String, Integer> i : m.entrySet()) {
            String key = i.getKey();
            int val = i.getValue();
            System.out.println(key + ": " + val + " students");
        }
    }
}
