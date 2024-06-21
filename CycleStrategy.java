

public class CycleStrategy implements Strategy{
    private int counter;
    CycleStrategy(){
        counter = 0;
    }
    @Override
    public Action getAction(){
        if(counter == 0){
            counter++;
            return Action.ROCK;
        }
        else if(counter == 1){
            counter++;
            return Action.SCISSORS;
        }
        else{
            counter = 0;
            return Action.PAPER;
        }
    }
    
}
