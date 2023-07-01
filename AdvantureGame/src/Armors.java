public class Armors {
    private int id;
    private String name;
    private int block;
    private int money;

    public Armors(int id, String name, int block, int money) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.money = money;
    }

    public static Armors[] armors(){
        Armors [] armorsList=new Armors[3];
        armorsList[0]=new Armors(1,"Slight",1,15);
        armorsList[1]=new Armors(2,"Middle",3,25);
        armorsList[2]=new Armors(3,"Hard",5,40);
        return armorsList;
    }
    public static Armors getArmorsObjID(int id){
        for (Armors s: Armors.armors()){
            if(s.getId()==id){
                return s;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
