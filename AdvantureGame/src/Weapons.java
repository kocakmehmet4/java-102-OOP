public class Weapons {
    private String name;
    private int id;
    private int damage;
    private int money;

    public Weapons(String name, int id, int damage, int money) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.money = money;
    }
    public static Weapons [] weapons(){
        Weapons [] weaponList= new Weapons[3];
        weaponList[0]= new Weapons("Gun",1,2,15);
        weaponList[1]= new Weapons("Sword",2,3,35);
        weaponList[2]= new Weapons("Rifle",3,7,45);
        return weaponList;
    }
    public static Weapons getWeaponObjID(int id){
        for (Weapons w: Weapons.weapons()){
            if(w.getId()==id){
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
