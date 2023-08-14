import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<10000;i++){
            arrayList.add(i);

        }
        int checkSize=arrayList.size()/4;
        List<Integer> evenNumber=new ArrayList<>();
        List<Integer> oddNumber= new ArrayList<>();

        List<Thread> threads= new ArrayList<>();

        for(int i=0;i<4;i++){
            int startNum=i*checkSize;
            int endNum=(i+1)*checkSize;
            List<Integer>checkNum =arrayList.subList(startNum,endNum);
            Thread thread= new Thread(new threadsRace(checkNum,evenNumber,oddNumber));
            threads.add(thread);
            thread.start();

        }
        for (Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Even numbers: " + evenNumber);
        System.out.println("Odd numbers: " + oddNumber);

    }
}
