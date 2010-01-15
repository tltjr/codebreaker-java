package codebreaker.codebreaker_java;

import cuke4duke.Pending;
import cuke4duke.Given;
import cuke4duke.Then;
import cuke4duke.When;
import static org.mockito.Mockito.*;

public class CodebreakerSteps {
	
	private Messenger messenger;
	private Game game;
	
	@Given("^I am not yet playing$")
	public void iAmNotYetPlaying() {
	}

	private void createGameMockMessenger() {
		messenger = mock(Messenger.class);
		game = new Game(messenger);
	}

	@When("^I start a new game$")
	public void iStartANewGame() {
		createGameMockMessenger();
		game.start("r g y c");
	}
	
	@Then("^I should see \"([^\"]*)\"$")
	public void iShouldSeeWelcomeToCodebreaker(String message) {
		verify(messenger).puts(message);
	}

    @Given("^the secret code is (. . . .)$")                           
    public void theSecretCodeIs(String code) {
    	createGameMockMessenger();
		game.start("r g y c");
    }                                     
                                          
    @When("^I guess (. . . .)$")            
    public void iGuess(String code) {            
    	game.guess(code);
    }                                     
                                          
    @Then("^the mark should be (.*)$")                                
    public void theMarkShouldBeBbbb(String mark) {
    	verify(messenger).mark(mark);
    }                                     
                                          


}
