

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.StartTlsRequest;

public class CPU {
	private Strategy strategy;
	private List<Action> history = new ArrayList<>();

	public CPU(Strategy strategy, List<Action> history) {
		this.strategy = strategy;
		this.history = history;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Action play(int consecutiveWins, List<Action> history) {
		if (consecutiveWins == 3 && strategy instanceof CycleStrategy){
			setStrategy(new LastStrategy(history));
		} else if (consecutiveWins == 3 && strategy instanceof LastStrategy){
			setStrategy(new RandomStrategy());
		}

		return strategy.getAction();
	}

}
