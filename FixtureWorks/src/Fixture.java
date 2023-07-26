import java.util.*;

public class Fixture {

    private List<String> teamList =new ArrayList<>();
    private Scanner input= new Scanner(System.in);
    private int teamSize;
    public void print(){

        System.out.println("Please enter Team size:");
        teamSize=input.nextInt();
        for (int i=0;i<teamSize;i++){
            teamList.add(input.next());
        }
        for (int i = 0; i < teamSize; i++) {
            if ((i & (i + 1)) == 0 && i != 0) {
                System.out.println();
            }
            System.out.print("-" + teamList.get(i) + " ");
        }
        System.out.println();
        CreateFixture();

    }
    public void CreateFixture(){

        if(teamSize%2!=0){
            teamList.add("Bay");
            teamSize++;
        }
        Collections.shuffle(teamList, new Random());

        for(int i=0;i<teamSize-1;i++){
            System.out.println((i+1)+" Week Matches");
            for(int j=0;j<teamSize/2;j++){
                String home= teamList.get(j);
                String away = teamList.get(teamSize-j-1);
                if(!away.equals("Bay")){
                    System.out.println(home+" vs "+ away);
                }
            }
            Collections.rotate(teamList.subList(1, teamSize), 1);

        }


    }

}
