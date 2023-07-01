
public class ToolStore extends NormalLoc{
    ToolStore(Player player){
        super(player,"Tool Store");
    }
    @Override
    public boolean onLocation(){
        System.out.println("---------Welcome the Store!---------");

        boolean showMenu=true;

        while (showMenu){

            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Exit");
            int selectItem=input.nextInt();

            switch (selectItem){
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("I'll see you back!");
                    showMenu=false;
                    break;
                default:
                    System.out.print("Invalid enter! Please try again: ");
                    selectItem=input.nextInt();

            }
        }

        return true;
    }

    private void printArmors() {
        System.out.println("-----------Armors-----------");
        System.out.println();
        for (Armors s: Armors.armors()){
            System.out.println("ID: "+s.getId()+"-"+s.getName()+ " <Price: "+s.getMoney()+" , Damage: "+s.getBlock()+">");
        }
        System.out.println("0- Exit");

    }
    private void buyArmor(){
        System.out.println("Please Select Armor:");
        int SelectArmorID=input.nextInt();
        while (SelectArmorID < 0 || SelectArmorID > Armors.armors().length){
            System.out.println("Invalid value, try again");
            SelectArmorID=input.nextInt();
        }
        if(SelectArmorID!=0){
            Armors SelectArmor=Armors.getArmorsObjID(SelectArmorID);
            if(SelectArmor!=null){
                if(SelectArmor.getMoney()>this.getPlayer().getMoney()){
                    System.out.println("Insufficient balance");
                }else{
                    int balance= this.getPlayer().getMoney()-SelectArmor.getMoney();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmors(SelectArmor);
                    System.out.println("Your Balance: "+this.getPlayer().getMoney());

                }
            }
        }

    }

    public void printWeapons(){
        System.out.println("-----------Weapons-----------");
        System.out.println();
        for (Weapons w: Weapons.weapons()){
            System.out.println("ID: "+w.getId()+"-"+w.getName()+ " <Price: "+w.getMoney()+" , Damage: "+w.getDamage()+">");
        }
        System.out.println("0- Exit");


    }
    public void buyWeapon(){
        System.out.print("Please select a Weapon: ");
        int selectWeaponID= input.nextInt();
        while (selectWeaponID<0 || selectWeaponID>Weapons.weapons().length){
            System.out.println("Invalid value, try again:");
            selectWeaponID= input.nextInt();

        }
        if(selectWeaponID!=0){
            Weapons selectedWeapon=Weapons.getWeaponObjID(selectWeaponID);
            if(selectedWeapon!=null){
                if(selectedWeapon.getMoney()> this.getPlayer().getMoney()){
                    System.out.println("Insufficient balance");
                }else{
                    System.out.println(selectedWeapon.getName()+ " successfully is bought.");
                    int balance= this.getPlayer().getMoney()-selectedWeapon.getMoney();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your Balance: "+this.getPlayer().getMoney());
                    System.out.println("Previous Weapon: "+ this.getPlayer().getInventory().getWeapons().getName());
                    this.getPlayer().getInventory().setWeapons(selectedWeapon);
                    System.out.println("Now Weapon: "+ this.getPlayer().getInventory().getWeapons().getName());
                }

            }
        }

    }
}
