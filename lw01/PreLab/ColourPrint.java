public class ColourPrint extends PrintJob{

    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    public int  calculateCharge(){
        int pages = getPages();
        int sum = 0;
        if(pages <= 10){
            sum = pages * 1500;
        }
        else{
            sum = (10 * 1500) + ((pages - 10) * 1000);
        }
        sum += 2000;
        return sum;
    }

    public String label() {
        return "Colour"; 
    }
}