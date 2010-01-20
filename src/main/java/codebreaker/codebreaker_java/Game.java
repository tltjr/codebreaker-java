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
		char[] result = new char[4];
		int i=0;
		while(i<code.length()) {
			if(code.charAt(i)==guess.charAt(i)) {
				result[i/2] = 'b';
			}
			else {
				int indexOf = code.indexOf(guess.charAt(i));
				if(indexOf>-1){
					if(result[indexOf/2]!='b') {
						result[indexOf/2] = 'w';
					}
				}
			}
			i = i+2;
		}
		messenger.mark(charArrayToString(result));
	}

	private String charArrayToString(char[] marked) {
		int i=0;
		String result = "";
		while(i<marked.length) {
			char temp = marked[i];
			if(temp=='b') {
				result = "b".concat(result);
			}
			else if(temp=='w'){
				result += 'w';
			}
			i++;
		}
		return result;
	}

}
