package Lw01.Unguided;

public abstract class Rental implements Chargeable{
    private int days;
    private String id;

    public Rental(String id,  int days){
        if(days <= 0){
            throw new IllegalArgumentException("Harus positif");
        }
        this.id = id;
        this.days = days;
    }
    public int getDays(){
        return days;
    }
    
    public String getId(){
        return id;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units){
        return units * calculateCharge();
    }

    public String label(){
        return "Rental";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}