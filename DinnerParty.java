public class DinnerParty extends Party{
    private int dinnerChoice;
    public void setDinnerChoice(int dinnerChoice){
        this.dinnerChoice = dinnerChoice;
    }
    public String getDinnerChoice(){
        if(dinnerChoice == 1){
            return("Steak, mashed potatoes, and asparagus will be served.");
        }else if(dinnerChoice == 2){
            return("Grilled chicken, fresh chop salad, and mushrooms will be served.");
        }
        return("Invalid input");

    }
}
