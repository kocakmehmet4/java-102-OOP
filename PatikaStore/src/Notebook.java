import java.util.PriorityQueue;


public class Notebook extends TechnologyDevices{
    int ram;

    public Notebook(int id, String productName, double price, String brand, int HDD, double screenInch,int ram) {
        super(id, productName, price, brand, HDD, screenInch);
        this.ram=ram;
    }


    public int getRam() {
        return ram;
    }



    public void setRam(int ram) {
        this.ram = ram;
    }
}
