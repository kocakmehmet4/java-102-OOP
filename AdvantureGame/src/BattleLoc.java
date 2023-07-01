import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String awards;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String awards, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.maxObstacle=maxObstacle;
        this.awards=awards;
    }
    @Override
    public boolean onLocation(){
        for (int i=0;i<this.getPlayer().getAwardList().size();i++){
            if (this.getPlayer().getInventory().getAwards()==this.getAwards() || this.getPlayer().getAwardList().get(i).equals(this.getAwards())){
                System.out.println("You have successfully completed the task, you cannot log in again. You are blocked.\n ");
                return true;
            }
        }

        int obsNum=RandomObstacleNumber();
        System.out.println("You are here right now! "+ this.getName());
        if(this.getObstacle().getName().equals("Snake")){
            obsNum=RandomSnakeNumber();
        }
        System.out.println("Be careful! "+obsNum+ " "+this.getObstacle().getName()+" living here !");

        System.out.print("Which one <F>ight or <E>scape: ");
        String selectBattle=input.nextLine();
        selectBattle=selectBattle.toUpperCase();
        if(selectBattle.equals("F") && combat(obsNum)){
            System.out.println("You won all of "+this.getObstacle().getName());
            return true;

        }else if(selectBattle.equals("E")){
            //Escape
            System.out.println("Escape!");
        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("You are death.");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNum){

        for(int i=1;i<=obsNum;i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
            playerStatus();
            ObstacleStatus(i);
            int whoFirst=RandomFirstAttack();
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<F>ight or <E>scape");
                String selectedCombat = input.nextLine().toUpperCase();
                if (selectedCombat.equals("F")) {
                    FirstAttack(whoFirst);
                }else if(selectedCombat.equals("E")){
                    return false;
                }
            }
            if(this.getPlayer().getHealth()>this.getObstacle().getHealth()){
                System.out.println("You defeated the enemy!");

                if (this.getObstacle().getName().equals("Snake")){
                    SnakeDropItem();
                }
                else{
                    System.out.println("You earned "+this.getObstacle().getPrice()+" coins");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getPrice());
                }

            }else{
                return false;
            }
        }
        if(this.getPlayer().getHealth()>this.getObstacle().getHealth()){
            System.out.println("Congratulations ! You have successfully completed this task");
            System.out.println("You Won some "+this.getAwards());
            this.getPlayer().getInventory().setAwards(this.getAwards());
            this.getPlayer().getAwardList().add(this.getPlayer().getInventory().getAwards());
        }
        System.out.flush();
        return true;
    }
    public void afterHit() {
        System.out.println("Health: " +this.getPlayer().getHealth());
        System.out.println( this.getObstacle().getName()+" Health: "+this.getObstacle().getHealth());
        System.out.println( "Monster Damage: "+this.getObstacle().getDamage());
        System.out.println("-------------------------------------------");
    }
    public void playerStatus(){
        System.out.println();
        System.out.println("Player Values");
        System.out.println("-----------------------------------------------");
        System.out.println("Health : "+this.getPlayer().getHealth());
        System.out.println("Weapon : "+this.getPlayer().getInventory().getWeapons().getName());
        System.out.println("Silah : "+this.getPlayer().getInventory().getArmors().getName());
        System.out.println("Damage : "+this.getPlayer().getTotalDamage());
        System.out.println("Money : "+this.getPlayer().getMoney());
        System.out.println("Block : "+this.getPlayer().getInventory().getArmors().getBlock());

        System.out.println();
    }


    public void ObstacleStatus(int i){
        if(this.getObstacle().getName().equals("Snake")){
            this.getObstacle().setDamage(RandomSnakeAttack());
        }
        System.out.println(i+". "+this.getObstacle().getName()+" Values");
        System.out.println("-----------------------------------------------");

        System.out.println("Health : "+this.getObstacle().getHealth());
        System.out.println("Damage : "+this.getObstacle().getDamage());
        System.out.println("Money : "+this.getObstacle().getPrice());
    }

    public void FirstAttack(int whoFirst){
        if(this.getObstacle().getName().equals("Snake")){
            this.getObstacle().setDamage(RandomSnakeAttack());
        }
        if(whoFirst==1){
            System.out.println("You are FIRST attacked.");
            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
            afterHit();
            if (this.getObstacle().getHealth() > 0) {
                System.out.println();
                System.out.println("Monster is attacked you ");
                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmors().getBlock();
                if (obstacleDamage < 0) {
                    obstacleDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                afterHit();
            }
        }else{
            if (this.getObstacle().getHealth() > 0) {
                System.out.println();
                System.out.println("Monster is FIRST attacked you ");
                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmors().getBlock();
                if (obstacleDamage < 0) {
                    obstacleDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                afterHit();
            }
            System.out.println("You are attacked.");
            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
            afterHit();
        }
    }
    public void SnakeDropItem(){

        double weaponPossibility = 0.15; // Weapon
        double riflePossibility= 0.20;
        double swordPossibility= 0.30;
        double gunPossibility=0.50;

        double armorPossibility  = 0.15; //Armor
        double hardArmorPossibility= 0.20;
        double middleArmorPossibility= 0.30;
        double slightArmorPossibility= 0.50;

        double moneyPossibility  = 0.25; //Money
        double tenMoneyPossibility= 0.20;
        double fiveMoneyPossibility= 0.30;
        double oneMoneyPossibility= 0.30;

        double nothingPossibility  = 0.45; // nothing

        Random random = new Random();
        double randomNum = random.nextDouble();
        double InventoryNum= random.nextDouble();


        if (randomNum < weaponPossibility) {
            Weapons weapons;
            if (InventoryNum<riflePossibility){
                System.out.println("You are won Rifle!");
                weapons = Weapons.getWeaponObjID(3);
                Weapons.getWeaponObjID(3).setMoney(0);
                this.getPlayer().getInventory().setWeapons(weapons);
            }else if(InventoryNum<riflePossibility+swordPossibility){
                System.out.println("You are won Sword!");
                weapons = Weapons.getWeaponObjID(2);
                Weapons.getWeaponObjID(2).setMoney(0);
                this.getPlayer().getInventory().setWeapons(weapons);
            }
            else{
                System.out.println("You are won Gun!");
                weapons = Weapons.getWeaponObjID(1);
                Weapons.getWeaponObjID(1).setMoney(0);
                this.getPlayer().getInventory().setWeapons(weapons);
            }
            this.getPlayer().getAwardList().add(weapons.getName());

        } else if (randomNum < weaponPossibility + armorPossibility) {
            Armors armors;
            if(InventoryNum<hardArmorPossibility){
                System.out.println("You are won Hard Armor!");
                armors=Armors.getArmorsObjID(3);
                Armors.getArmorsObjID(3).setMoney(0);
                this.getPlayer().getInventory().setArmors(armors);
            }else if(InventoryNum< hardArmorPossibility+middleArmorPossibility){
                System.out.println("You are won Middle Armor!");
                armors=Armors.getArmorsObjID(2);
                Armors.getArmorsObjID(2).setMoney(0);
                this.getPlayer().getInventory().setArmors(armors);
            }
            else{
                System.out.println("You are won Slight Armor!");
                armors=Armors.getArmorsObjID(1);
                Armors.getArmorsObjID(1).setMoney(0);
                this.getPlayer().getInventory().setArmors(armors);
            }
            this.getPlayer().getAwardList().add(armors.getName());

        } else if (randomNum <  weaponPossibility + armorPossibility + moneyPossibility) {
            if(InventoryNum< tenMoneyPossibility){
                System.out.println("You are won 10 coins!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
            }else if(InventoryNum<tenMoneyPossibility+fiveMoneyPossibility){
                System.out.println("You are won 5 coins!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
            }
            else{
                System.out.println("You are won 1 coins!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
            }
        } else {
            System.out.println("You didn't win anything .");
        }
    }




    public int RandomObstacleNumber(){
        Random r= new Random();
        return r.nextInt(3)+1;
    }
    public int RandomSnakeNumber(){
        Random r= new Random();
        return r.nextInt(6)+1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }
    public int RandomFirstAttack(){
        Random r= new Random();
        return r.nextInt(2)+1;
    }
    public int RandomSnakeAttack(){
        Random r= new Random();
        int i= r.nextInt(3)+3;
        this.getObstacle().setDamage(i);
        return i;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAwards() {
        return this.awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}


