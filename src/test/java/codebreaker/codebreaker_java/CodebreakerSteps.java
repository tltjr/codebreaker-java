package codebreaker.codebreaker_java;

import cuke4duke.Pending;
import cuke4duke.Given;
import cuke4duke.Then;
import cuke4duke.When;
import static org.mockito.Mockito.*;

public class CodebreakerSteps {

	private Messenger messenger;
	private Game game;
	private Generator mockedGenerator;
	
	@Given("^I am not yet playing$")
	public void iAmNotYetPlaying() {
	}

	private void createGameMockMessenger() {
		messenger = mock(Messenger.class);
		game = new Game(messenger);
		mockedGenerator = mock(Generator.class);
		when(mockedGenerator.code()).thenReturn("rgyc");
	}

	@When("^I start a new game$")
	public void iStartANewGame() {
		createGameMockMessenger();
		game.start(mockedGenerator);
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void iShouldSeeWelcomeToCodebreaker(String message) {
		verify(messenger).puts(message);
	}

	@Given("^the secret code is (....)$")
	public void theSecretCodeIs(String code) {
		createGameMockMessenger();
		game.start(mockedGenerator);
	}

	@When("^I guess (....)$")
	public void iGuess(String guess) {
		game.guess(guess);
	}

	@Then("^the mark should be (.*)$")
	public void theMarkShouldBe(String mark) {
		verify(messenger).mark(mark);
	}

	@Given("^6 colors$")
	public void sixColors() {
	}

	@Given("^4 positions$")
	public void fourPositions() {
	}

	@When("^I play (.*) games$")
	@Pending
	public void iPlayXGames(String number) {
		
	}

	@Then("^each color should appear between 1500 and 1800 times in each position$")
	@Pending
	public void eachColorShouldAppearBetween1500And1800TimesInEachPosition() {
	}

	@Then("^each color should appear no more than once in each secret code$")
	@Pending
	public void eachColorShouldAppearNoMoreThanOnceInEachSecretCode() {
	}
}
