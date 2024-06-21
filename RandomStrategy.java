

import java.util.Random;

public class RandomStrategy implements Strategy{
    public RandomStrategy(){
    }
    
    @Override
    public Action getAction(){
        int randomResult = Utils.random.nextInt(2);//Results either 0, 1, or 2
        switch (randomResult){
            case 0:
                return Action.PAPER;
            case 1:
                return Action.SCISSORS;
            case 2:
                return Action.ROCK;
            default:
                return null;
        }
    }
}
