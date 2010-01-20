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
	private Generator mockedGenerator;
	
	@Before
	public void setUp() throws Exception {
		messenger = mock(Messenger.class); 
		game = new Game(messenger);
		mockedGenerator = mock(Generator.class);
		when(mockedGenerator.code()).thenReturn("rgyc");
	}

	@Test
	public void testSendsWelcomeMessage() throws Exception {
		game.start(mockedGenerator);
		verify(messenger).puts("Welcome to Codebreaker!");
	}
	
	@Test
	public void testPromptsForFirstGuess() throws Exception {
		game.start(mockedGenerator);
		verify(messenger).puts("Enter guess:");
	}
	
	@Test
	public void testFourCorrectColorsInCorrectPlacesMarksBBBB() throws Exception {
		game.start(mockedGenerator);
		game.guess("rgyc");
		verify(messenger).mark("bbbb");
	}
	
	@Test
	public void testFourCorrectColorTwoCorrectPlacesMarksBBWW() throws Exception {
		game.start(mockedGenerator);
		game.guess("rgcy");
		verify(messenger).mark("bbww");
	}
	
	@Test
	public void testFourCorrectColorsOneCorrectPlaceMarksBWWW() throws Exception {
		game.start(mockedGenerator);
		game.guess("yrgc");
		verify(messenger).mark("bwww");
	}
	
	@Test
	public void testDuplicatesInGuessThatMatchPegInCodeByColorAndPosition() throws Exception {
		game.start(mockedGenerator);
		game.guess("rgyg");
		verify(messenger).mark("bbb");
	}
	
	@Test
	public void testTwoCorrectColorsWrongPlaces() throws Exception {
		game.start(mockedGenerator);
		game.guess("gwcw");
		verify(messenger).mark("ww");
	}
}
