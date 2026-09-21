package Lw01.Prelab;
public abstract class PrintJob implements Chargeable{

    private String id;
    private int pages;
    public PrintJob(String id, int pages){
        if(pages <= 0){
                throw new IllegalArgumentException("Jumlah harus positif"); 
            }
        this.id = id;
        this.pages = pages;

    }

    public String getId(){
        return id;
    }

    public int getPages(){
        return pages;
    }

    public abstract int calculateCharge();


    public int calculateCharge(int copies){
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
         return id + " | " + label() + " | " + calculateCharge();
    }


}