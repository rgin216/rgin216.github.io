import java.util.ArrayList;
import java.util.List;

public class LastStrategy implements Strategy{
    List <Action> history = new ArrayList<>();
    public LastStrategy(List<Action> history){
        this.history = history;
    }

    @Override
    public Action getAction(){
        if (history.isEmpty()){
            return Action.PAPER;
        }
        return history.get(history.size()-1);
    }
    
}
