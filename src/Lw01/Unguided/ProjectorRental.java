package Lw01.Unguided;

public class ProjectorRental extends Rental{

    public ProjectorRental(String id, int days){
        super(id,days);
    }

    public int calculateCharge(){
        int x = getDays();
        if(x <= 3){
            return (x * 60000) + 20000;
        }
        else{
            return (3 * 60000) + ((x-3) * 45000) + 20000;
        }
    }
    public String label(){
        return "Projector";
    }

}