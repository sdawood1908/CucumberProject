package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.FunctionalLib;

public class SelectHotelPom extends FunctionalLib{

	public SelectHotelPom() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[contains(@id,'radiobutton_')]")
	private WebElement radioBtn;

	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(xpath= "//td[text()='Select Hotel ']")
	private WebElement titleSelectHotel;

	public WebElement getTitleSelectHotel() {
		return titleSelectHotel;
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selectHotel() {
		click(getRadioBtn());
		click(getBtnContinue());
	}
	public String getTitle() {
		String string = getText(getTitleSelectHotel());
		return string;

	}
}
