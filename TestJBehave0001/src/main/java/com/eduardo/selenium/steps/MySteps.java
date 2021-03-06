package com.eduardo.selenium.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.eduardo.apps.sinesp.PlateSearch;
import com.eduardo.apps.sinesp.SinespHome;
import com.eduardo.framework.device.AndroidDevice;
import com.eduardo.framework.selenium.AbstractPage;



public class MySteps {
	
	private final String ERROR_MESSAGE = "ERRO: Não foi possível executar o teste";
	
	private AndroidDevice android;
	
	private PlateSearch SinespPlateSearch;
	
	private SinespHome HomeSinesp;
    
	@Given("I have set up the device")	
	public void deviceSetup() {	
		// a criacao do driver e inicializao da vm agora fica na pagina
		// se faz sentido é uma questao a ser vista		
	}
	
	@When ("I Fire up the app")
	public void fireApp() {
		AbstractPage.initDriver();
	}	
	
	@Then("I'm at the Sinesp app home")
	@Given("I'm at the Sinesp app home")
	public void imAtSinespHome() {
		Assert.assertTrue(HomeSinesp.getNumeroBotoesHome() > 0);
	}
	
	@When ("I click in the Veiculos button")
	public void clickVeiculoButton () {
		HomeSinesp.clickVeiculoButton();
	}
	
	@Then ("I see there are $amount buttons")	
	public void validatenothing(@Named("amount") int howManyButtons) {		
		Assert.assertEquals(howManyButtons, HomeSinesp.getNumeroBotoesHome());
	}
	
	@Then("the field plate letters is shown")
	public void validatePlateLetters() {
		Assert.assertTrue(SinespPlateSearch.isPlateLettersPresent());
	}
	
	@When("I type the plate $letters $numbers")
	public void typePlate(@Named ("letters") String letters, @Named("numbers") String numbers) {
		SinespPlateSearch.inputLetters(letters);
	}
	
	@Then("the field contains $whatLetters $whatNumbers")
	public void checkPlateType(@Named ("whatLetters") String leters, @Named("whatNumbers") String numbers) {
		SinespPlateSearch.inputNumbers(numbers);
	}
	
	
	
	
//	Given I'm at the Sinesp app home
//	When I click in the Ve�culos button
//	Then I see the button "checar situa��o"
//	When I type the plate "icq5550"
//	Then the editText1 field will contain "icq"
//	And the editText2 field will contain "5550"
//	When I click in the checar situa��o button
//	Then I see the message "placa n�o foi encontrada"
	
}

