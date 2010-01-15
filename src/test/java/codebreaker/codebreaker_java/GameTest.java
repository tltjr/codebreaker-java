package codebreaker.codebreaker_java;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest extends TestCase {

	private Game game;
	private Messenger messenger;
	
	@Before
	public void setUp() throws Exception {
		messenger = mock(Messenger.class); 
		game = new Game(messenger);
		game.start("r g y c");
	}

	@Test
	public void testSendsWelcomeMessage() throws Exception {
		verify(messenger).puts("Welcome to Codebreaker!");
	}
	
	@Test
	public void testPromptsForFirstGuess() throws Exception {
		verify(messenger).puts("Enter guess:");
	}
	
	@Test
	public void testFourCorrectColorsInCorrectPlacesMarksBBBB() throws Exception {
		game.guess("r g y c");
		verify(messenger).mark("bbbb");
	}
	
	@Test
	public void testFourCorrectColorTwoCorrectPlacesMarksBBWW() throws Exception {
		game.guess("r g c y");
		verify(messenger).mark("bbww");
	}
	
	@Test
	public void testFourCorrectColorsOneCorrectPlaceMarksBWWW() throws Exception {
		game.guess("y r g c");
		verify(messenger).mark("bwww");
	}
}
