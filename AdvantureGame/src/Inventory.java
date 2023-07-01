public class Inventory {

    private Weapons weapons;
    private Armors armors;
    private String awards;

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public Inventory() {
        this.weapons= new Weapons("Fist",-1,0,0);
        this.armors= new Armors(-1,"None",0,0);
    }

    public Armors getArmors() {
        return armors;
    }

    public void setArmors(Armors armors) {
        this.armors = armors;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }
}
