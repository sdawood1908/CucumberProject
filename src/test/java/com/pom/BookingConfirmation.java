package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.FunctionalLib;

public class BookingConfirmation extends FunctionalLib{

	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="order_no")
	private WebElement txtOrderNo;

	@FindBy(id="my_itinerary")
	private WebElement btnItinerary;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement titleConformation;

	public WebElement getTitleConformation() {
		return titleConformation;
	}

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

	public WebElement getBtnItinerary() {
		return btnItinerary;
	}
	public String orderId() {
		String string = getAttribute(getTxtOrderNo(), "value");
		click(getBtnItinerary());
		return string;
	}

	public String bookingConfirmationTxt() {
		String textFromPage = getText(getTitleConformation());
		return textFromPage;
		
	}
}
