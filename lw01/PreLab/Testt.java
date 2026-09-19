import java.lang.*;
import java.util.*;

public class Testt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Testt.class.getResourceAsStream("jobs.txt"));
        List<PrintJob> p = new ArrayList<>();
        while(sc.hasNext()){
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();
            sc.nextLine();
            
            if (type.equals("MONO")){
                p.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                p.add(new ColourPrint(id, pages));
            }    
        }

        for (PrintJob job : p) {
            System.out.println(job.summary());
        }
    }
}
