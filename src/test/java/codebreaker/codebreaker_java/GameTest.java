package codebreaker.codebreaker_java;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import cuke4duke.Pending;

public class GameTest extends TestCase {

	private Game game;
	private Messenger messenger;
	
	@Before
	public void setUp() throws Exception {
		messenger = mock(Messenger.class); 
		game = new Game(messenger);
	}

	@Test
	public void testSendsWelcomeMessage() throws Exception {
		game.start("r g y c");
		verify(messenger).puts("Welcome to Codebreaker!");
	}
	
	@Test
	public void testPromptsForFirstGuess() throws Exception {
		game.start("r g y c");
		verify(messenger).puts("Enter guess:");
	}
	
	@Test
	public void testFourCorrectColorsInCorrectPlacesMarksBBBB() throws Exception {
		game.start("r g y c");
		game.guess("r g y c");
		verify(messenger).mark("bbbb");
	}
	
	@Test
	public void testFourCorrectColorTwoCorrectPlacesMarksBBWW() throws Exception {
		game.start("r g y c");
		game.guess("r g c y");
		verify(messenger).mark("bbww");
	}
	
	@Test
	public void testFourCorrectColorsOneCorrectPlaceMarksBWWW() throws Exception {
		game.start("r g y c");
		game.guess("y r g c");
		verify(messenger).mark("bwww");
	}
	
	@Test
	public void testDuplicatesInGuessThatMatchPegInCodeByColorAndPosition() throws Exception {
		game.start("r y g c");
		game.guess("r y g g");
		verify(messenger).mark("bbb");
	}
	
	@Test
	public void testTwoCorrectColorsWrongPlaces() throws Exception {
		game.start("r g y c");
		game.guess("g w c w");
		verify(messenger).mark("ww");
	}
}
