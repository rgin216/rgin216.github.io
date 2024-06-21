import java.util.ArrayList;
import java.util.List;

public class RockPaperScissorsGame {

    private void printReady() {
      System.out.print("Ready?");
      try {
        Thread.sleep(50);
        for (int i = 1; i <= 3; i++) {
          System.out.print(i);
          Thread.sleep(50);
          for (int k = 0; k < 5; k++) {
            System.out.print(".");
            Thread.sleep(50);
          }
        }
        System.out.println("GO!");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    private int getResult(Action hAction, Action cAction){
      if (hAction.equals(cAction)){
        return 0;
      }
      if (hAction.equals(Action.ROCK) && cAction.equals(Action.SCISSORS)||hAction.equals(Action.PAPER) && cAction.equals(Action.ROCK)||hAction.equals(Action.SCISSORS) && cAction.equals(Action.PAPER)){
        System.out.println("Human wins");
        return 1;
      } else {
        System.out.println("CPU wins");
        return -1;
      }
    }
  
    public void play() {
      List<Action> history = new ArrayList<>();
      int consecutiveWin = 0;
      String res;
      Human human = new Human();
      Strategy tempStrategy = new LastStrategy(history);
      CPU cpu = new CPU(new CycleStrategy(), history);
      do {
        printReady();
        // get result
        Action humanHand = human.play();
        Action cpuHand = cpu.play(consecutiveWin, history);
        history.add(humanHand);
        System.out.println("human: " + humanHand.toString() + " cpu: " + cpuHand.toString());
        int result = getResult(humanHand, cpuHand);
        if (result == 1){
          consecutiveWin++;
        } else {
          consecutiveWin = 0;
        }
        //same as below: if results == 1, consecutive++ else 0
        //consecutiveWin = result == 1 ? consecutiveWin + 1 : 0;

        System.out.println("Do you want to play again?");
        res = Utils.scanner.next();
        while (!res.equals("yes") && !res.equals("no")) {
          System.out.println("Wrong input! please type either \"yes\" or \"no\"");
          res = Utils.scanner.next();
        }
      } while (res.equals("yes"));
      Utils.scanner.close();
    }
  }
  