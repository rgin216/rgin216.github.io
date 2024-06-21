import java.util.Scanner;
public class Human {

	public Action play() {
		
		String input;
		
		while(true){
			System.out.println("Choose among R (rock), P (paper), S (scissors)");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			if (!input.equals("R")&&!input.equals("P")&&!input.equals("S")){ 
				System.out.println("Invalid input, please try again");
			} else{
				break;
			}			
		}
		return Action.getActionbyId(input);
	
		
	}
}
