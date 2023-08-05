public class Phone extends TechnologyDevices {
    double cameraPixel;

    public Phone(int id, String productName, double price, String brand, int HDD, double screenInch, double cameraPixel) {
        super(id, productName, price, brand, HDD, screenInch);
        this.cameraPixel = cameraPixel;

    }

    public double getCameraPixel() {
        return cameraPixel;
    }

    public void setCameraPixel(double cameraPixel) {
        this.cameraPixel = cameraPixel;
    }
}
