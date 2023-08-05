import java.util.Scanner;

public class Store {
    private Scanner scanner= new Scanner(System.in);
    public void Start(){
        System.out.println("Welcome to Patika Store Product Managment Panel ! ");

        while(true){
            Brands brands= new Brands();
            System.out.println("-----------------------------");
            System.out.println("1 - Notebook Transactions");
            System.out.println("2 - Mobile Phone Transactions");
            System.out.println("3 - Brand List");
            System.out.println("4 - Add Product");
            System.out.println("0 - Exit");
            System.out.println("-----------------------------");
            System.out.println("Please enter your select: ");
            int select=scanner.nextInt();
            if(select==0){
                System.out.println("See you!");
                break;
            }

            switch (select){
                case 1:
                    //brands.notebookList();
                    brands.printNotebookList();
                    break;

                case 2:
                    brands.phoneList();
                    brands.printPhoneList();
                    break;
                case 3:
                    brands.MarkList();
                    break;
                case 4:
                    System.out.println("1-Notebook\n2-Phone");
                    int selectProduct=scanner.nextInt();

                    if(selectProduct==1){
                        brands.addNotebookList();
                        brands.printNotebookList();
                    }
                    else if(selectProduct==2){
                        brands.addPhoneList();
                        brands.printPhoneList();
                    }
                    else{
                        System.out.println("Invalid value!");
                        break;
                    }

                    break;
                default:
                    System.out.println("Invalid value! Please try again.");
                    break;
            }
        }

    }

}
