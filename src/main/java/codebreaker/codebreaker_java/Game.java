package codebreaker.codebreaker_java;


public class Game {

	private Messenger messenger;
	private String code;
	
	public Game(Messenger messenger) {
		this.messenger = messenger;
	}

	public void start(String code) {
		this.code = code;
		messenger.puts("Welcome to Codebreaker!");
		messenger.puts("Enter guess:");
	}

	public void guess(String guess) {
		String result = "";
		int i=0;
		while(i<code.length()) {
			if(code.charAt(i)==guess.charAt(i)) {
				result = "b".concat(result);
			}
			else {
				if(code.indexOf(guess.charAt(i))>-1){
					result += "w";
				}
			}
			i = i+2;
		}
		messenger.mark(result);
	}

}
