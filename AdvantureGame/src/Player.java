import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private int health;
    private int defaultHealth;
    private int money;
    private Inventory inventory;
    private Scanner input=new Scanner(System.in);
    List<String> awardList= new ArrayList<>(3);

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }
    public void SelectChar(){
        GameChar [] characterList= {new Samurai(), new Archer(), new Knight()};
        System.out.println("The Characters: ");
        System.out.println("--------------------------------------------------------------------------------");
        for (GameChar gameChar:characterList) {
            System.out.println("ID:  "+gameChar.getId()+"\tCharacter: "+ gameChar.getName() +
                    " \t Damage: "+ gameChar.getDamage() +
                    " \t Health: "+ gameChar.getHealth() +
                    " \t Money: "+ gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Please select a character: ");
        int selectChar=input.nextInt();
        switch (selectChar){
            case 1:
                InItPlayer(new Samurai());
                break;
            case 2:
                InItPlayer(new Archer());
                break;
            case 3:
                InItPlayer(new Knight());
                break;
            default:
                System.out.print("Please enter a validate select");
                selectChar=input.nextInt();
        }
        System.out.println("Character: "+this.getName()+" , Damage: "+
                this.getDamage()+" , Health: "+this.getHealth()+
                " , Money: "+this.getMoney());
    }
    public void InItPlayer(GameChar gameChar){
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefaultHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());

    }
    public void PrintInfo(){
        System.out.println("Armors: "+this.getInventory().getArmors().getName() +
                " , Weapon: "+this.getInventory().getWeapons().getName()+
                " , Blocked: "+this.getInventory().getArmors().getBlock() +
                " , Damage: "+ this.getTotalDamage()+
                " , Health: "+this.getHealth()+
                " , Award: "+this.getAwardList()+
                " , Money: "+this.getMoney());
    }

    public List<String> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<String> awardList) {
        this.awardList = awardList;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getTotalDamage(){
        return this.damage+this.inventory.getWeapons().getDamage();
    }
    public void setHealth(int health){
        if (health<0){
            health=0;
        }
        this.health=health;
    }

    public int getHealth(){
        return this.health;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public int getMoney(){
        return this.money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
