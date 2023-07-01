import java.util.Random;

public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int price;
    private int defaultHealth;

    public Obstacle(int id, String name, int damage, int health,int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.price = price;
        this.defaultHealth=health;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health=health;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
