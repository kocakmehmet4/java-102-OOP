public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }
    @Override
    public boolean onLocation(){
        System.out.println("---------You are a Safe House!---------");
        System.out.println("Your Health Power is a full ");
        this.getPlayer().setHealth(getPlayer().getDefaultHealth());


        for(int i=0;i<this.getPlayer().getAwardList().size();i++){
            if(this.getPlayer().getAwardList().get(i).equals("Water") && this.getPlayer().getAwardList().size()>3){
                System.out.println("Congratulations ! You have successfully completed the GAME!");
                return false;
            }
        }



        return true;
    }

}
