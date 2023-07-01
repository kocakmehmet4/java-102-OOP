import java.util.Scanner;
public class Game {
    private Scanner input= new Scanner(System.in);
    public void Start(){
        System.out.println("Welcome the Adventure Game!");
        System.out.print("Please enter the name: ");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println(player.getName()+" Welcome!");
        System.out.println("Now, Select your game Character!");
        player.SelectChar();
        Location location=null;
        while(true){
            player.PrintInfo();
            System.out.println();
            System.out.println("#######Regions#######");
            System.out.println();
            System.out.println("1- Safe House --> This is a safe area for you, none enemy ! ");
            System.out.println("2- Store --> You can buy Weapon or Armor !");
            System.out.println("3- Cave --> Enter the Cave , Award <Food>, Be careful, Zombie may come !");
            System.out.println("4- River --> Enter the River , Award <Water>, Be careful, Bear may come !");
            System.out.println("5- Forest --> Enter the Forest , Award <Wood>, Be careful, Vampire may come !");
            System.out.println("6- Mine --> Enter the Mine , Award <Money,Weapon or Armor>, Be careful, Snake may come !");
            System.out.println("0- Exit --> Game End !");
            System.out.println("Please select the region you want to go to");
            int selectReg=input.nextInt();
            switch (selectReg){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    if (!location.onLocation()){
                        location=null;
                    }
                    break;
                case 2:
                    location= new ToolStore(player);
                    break;
                case 3:
                    location= new Cave(player);
                    break;
                case 4:
                    location= new River(player);
                    break;
                case 5:
                    location= new Forest(player);
                    break;
                case 6:
                    location=new Mine(player);
                    break;
                default:
                    location=new SafeHouse(player);
                    break;
            }
            if (location==null){
                System.out.println("The Game is Finished , See you later!");
                break;
            }

            if(!location.onLocation()){
                System.out.println("GAME OVER! YOU ARE DEAD");
                break;
            }
        }



    }
}
