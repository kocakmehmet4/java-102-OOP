import java.util.List;

public class threadsRace implements Runnable{
    List<Integer> checkNum;
    List<Integer> evenNum;
    List<Integer> oddNum;

    public threadsRace(List<Integer> checkNum, List<Integer> evenNum, List<Integer> oddNum) {
        this.checkNum = checkNum;
        this.evenNum = evenNum;
        this.oddNum = oddNum;
    }


    @Override
    public void run() {

        OrderNum();
    }
    public synchronized void OrderNum(){
        for (int num : checkNum) {
            if (num % 2 == 0) {
                evenNum.add(num);
            } else {
                oddNum.add(num);
            }
        }
    }


    public List<Integer> getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(List<Integer> checkNum) {
        this.checkNum = checkNum;
    }

    public List<Integer> getEvenNum() {
        return evenNum;
    }

    public void setEvenNum(List<Integer> evenNum) {
        this.evenNum = evenNum;
    }

    public List<Integer> getOddNum() {
        return oddNum;
    }

    public void setOddNum(List<Integer> oddNum) {
        this.oddNum = oddNum;
    }
}
