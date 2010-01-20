package codebreaker.codebreaker_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App 
{
    public static void main( String[] args )
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Game g = new Game(new Messenger());
    	g.start(new Generator());
    	String guess = "";
    	while(true) {
    		try {
				guess = br.readLine();
				if(guess.equals("exit")) { break; }
			} catch (IOException e) {
				e.printStackTrace();
			}
    		g.guess(guess);
    	}
    }
}
