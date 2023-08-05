import java.util.*;

public class Brands extends TechnologyDevices {
    private  TreeSet treeSet;
    public Scanner scanner= new Scanner(System.in);
    private List<Notebook> notebookList;
    private Notebook notebook;
    private List<Phone> phoneList;
    private Phone phone;


    public Brands() {
        super(1,null,0,null,0,0);
        treeSet= new TreeSet();
        notebookList= new LinkedList<>();
        phoneList= new LinkedList<>();
        notebook=new Notebook(1,null,0,null,0,0,0);
        phone=new Phone(1,null,0,null,0,0,0);
        notebookList();

    }

    public void phoneList(){

        phoneList.add(new Phone(getBrandsID(),"SAMSUNG GALAXY A51  ", 7000.0, BrandNamesUpdate("Samsung"),128,6.5, 32));
        phoneList.add(new Phone(getBrandsID(),"iPhone 11 64 GB ", 3699.0, BrandNamesUpdate("Apple"),64 ,6.1, 5));
        phoneList.add(new Phone(getBrandsID(),"Redmi Note 10 Pro 8GB  ", 8199.0, BrandNamesUpdate("Xiaomi"),128 ,6.5, 35));
    }
    public void addPhoneList(){
        System.out.println("Please enter you want to add product Name:");
        setProductName(scanner.nextLine());
        System.out.println("Please enter you want to add product Price:");
        setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.println("Please enter you want to add product Brand Name:");
        String brandName=scanner.nextLine();
        setBrandsName(BrandNamesUpdate(brandName));
        System.out.println("Please enter you want to add product HDD:");
        setHDD(Integer.parseInt(scanner.nextLine()));
        System.out.println("Please enter you want to add product Screen Inch:");
        setScreenInch(Double.parseDouble(scanner.nextLine()));
        System.out.println("Please enter you want to add product Camera:");
        phone.setCameraPixel(Double.parseDouble(scanner.nextLine()));
        phoneList.add(new Phone(getBrandsID(),getProductName(),getPrice(),getBrandsName(),getHDD(),getScreenInch(),phone.getCameraPixel()));


    }

    public void printPhoneList(){
        System.out.format("%-3s| %-25s| %-9s| %-9s| %-5s| %-10s| %s%n",
                "ID", "Product Name", "Price", "Brand", "HDD", "Screen", "Camera Pixel");

        for (Phone phone : phoneList) {
            System.out.format("%-3d| %-25s| %-9.2f| %-9s| %-5d| %-10.1f| %.2f%n",
                    phone.getBrandsID(),
                    phone.getProductName(),
                    phone.getPrice(),
                    phone.getBrandsName(),
                    phone.getHDD(),
                    phone.getScreenInch(),
                    phone.getCameraPixel());
        }
    }

    public void notebookList(){

        notebookList.add(new Notebook(getBrandsID(),"HUAWEI Matebook 14 ", 7000.0, BrandNamesUpdate("Huawei"),512,14.0, 16));
        notebookList.add(new Notebook(getBrandsID(),"LENOVO V14 IGL ", 3699.0, BrandNamesUpdate("Lenovo"),1024 ,14.0, 8));
        notebookList.add(new Notebook(getBrandsID(),"ASUS Tuf Gaming  ", 8199.0, BrandNamesUpdate("Asus"),2048 ,15.6, 32));

    }
    public void addNotebookList(){
        System.out.println("Please enter you want to add product Name:");
        setProductName(scanner.nextLine());
        System.out.println("Please enter you want to add product Price:");
        setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.println("Please enter you want to add product Brand Name:");
        String brandName=scanner.nextLine();
        setBrandsName(BrandNamesUpdate(brandName));
        System.out.println("Please enter you want to add product HDD:");
        setHDD(Integer.parseInt(scanner.nextLine()));
        System.out.println("Please enter you want to add product Screen Inch:");
        setScreenInch(Double.parseDouble(scanner.nextLine()));
        System.out.println("Please enter you want to add product RAM:");
        notebook.setRam(Integer.parseInt(scanner.nextLine()));
        notebookList.add(new Notebook(getBrandsID(),getProductName(),getPrice(),getBrandsName(),getHDD(),getScreenInch(), notebook.getRam()));


    }

    public void printNotebookList(){
        System.out.format("%-3s| %-25s| %-9s| %-9s| %-5s| %-10s| %s%n",
                "ID", "Product Name", "Price", "Brand", "HDD", "Screen", "RAM");

        for (Notebook notebook : notebookList) {
            System.out.format("%-3d| %-25s| %-9.2f| %-9s| %-5d| %-10.1f| %d%n",
                    notebook.getBrandsID(),
                    notebook.getProductName(),
                    notebook.getPrice(),
                    notebook.getBrandsName(),
                    notebook.getHDD(),
                    notebook.getScreenInch(),
                    notebook.getRam());
        }
    }


    public String BrandNamesUpdate(String brandsName) {
        if(treeSet.contains(brandsName)){
            return brandsName;
        }
        return brandsName;
    }

    public void MarkList(){

        treeSet.add("Apple");
        treeSet.add("Casper");
        treeSet.add("HP");
        treeSet.add("Huawei");
        treeSet.add("Asus");
        treeSet.add("Xiaomi");
        treeSet.add("Samsung");
        treeSet.add("Monster");
        treeSet.add("Lenovo");

        System.out.println("Brands");
        System.out.println("-----------------------------");
        Iterator iterator= treeSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }




}
