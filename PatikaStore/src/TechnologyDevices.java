public abstract class TechnologyDevices implements Comparable<TechnologyDevices> {
    private String productName;
    private double price;
    private int HDD;
    private double screenInch;
    private static int brandsID=1;
    private String brandsName;

    public TechnologyDevices(int brandsID, String productName, double price, String brandsName, int HDD, double screenInch) {
        this.productName = productName;
        this.price = price;
        this.HDD = HDD;
        this.screenInch = screenInch;
        this.brandsID = brandsID;
        this.brandsName = brandsName;
    }





    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getHDD() {
        return HDD;
    }

    public double getScreenInch() {
        return screenInch;
    }

    public static int getBrandsID() {

        return brandsID++;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public void setScreenInch(double screenInch) {
        this.screenInch = screenInch;
    }


    public  String getBrandsName() {
        return brandsName;
    }
    public  void setBrandsName(String brandsName) {

        this.brandsName= brandsName;
    }

    @Override
    public int compareTo(TechnologyDevices o) {
        if(this.brandsName==null || o.brandsName==null) brandsName = "FALSE";
        return brandsName.compareTo(o.brandsName);
    }
}
