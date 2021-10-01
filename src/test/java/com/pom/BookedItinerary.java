package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.FunctionalLib;

public class BookedItinerary extends FunctionalLib{

	public BookedItinerary() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="order_id_text")
	private WebElement txtSearch;

	@FindBy(id="search_hotel_id")
	private WebElement btnGo;

	@FindBy(name="ids[]")
	private WebElement chkSelectBooking;

	@FindBy(name="cancelall")
	private WebElement btnCancelBooking;

	@FindBy(xpath="//input[contains(@id,'btn_id')]")
	private WebElement btnCancel;

	@FindBy(id="search_result_error")
	private WebElement errorMsg;

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getChkSelectBooking() {
		return chkSelectBooking;
	}

	public WebElement getBtnCancelBooking() {
		return btnCancelBooking;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public String cancelBooking(String orderId) {
		sendText(getTxtSearch(), orderId);
		click(getBtnGo());
		click(getChkSelectBooking());
		click(getBtnCancel());
		try {
		driver.switchTo().alert().accept();
		}catch (Exception e) {
			System.out.println("No Alert Present");
		}
		String text = getErrorMsg().getText();
		return text;
	}



}
