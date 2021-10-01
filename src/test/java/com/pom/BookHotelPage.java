package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.FunctionalLib;

public class BookHotelPage extends FunctionalLib{

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="first_name")
	private WebElement txtFirstName;

	@FindBy(id="last_name")
	private WebElement txtLastName;

	@FindBy(id="address")
	private WebElement txtAddress;

	@FindBy(id="cc_num")
	private WebElement txtCcNo;

	@FindBy(id="cc_type")
	private WebElement dDnCcType;

	@FindBy(id="cc_exp_month")
	private WebElement dDnExpMonth;

	@FindBy(id="cc_exp_year")
	private WebElement dDnExpYear;

	@FindBy(id="cc_cvv")
	private WebElement txtCvvNo;

	@FindBy(id="book_now")
	private WebElement btnBookNow;

	@FindBy(id="first_name_span")
	private WebElement msgFirstNameSpan;

	@FindBy(id="last_name_span")
	private WebElement msgLastNameSpan;

	@FindBy(id="address_span")
	private WebElement msgAddressSpan;

	@FindBy(id="cc_num_span")
	private WebElement msgCcNosSpan;

	@FindBy(id="cc_type_span")
	private WebElement msgCcTypeSpan;

	@FindBy(id="cc_expiry_span")
	private WebElement msgCcExpirySpan;

	@FindBy(id="cc_cvv_span")
	private WebElement msgCvvSpan;

	public WebElement getMsgFirstNameSpan() {
		return msgFirstNameSpan;
	}

	public WebElement getMsgLastNameSpan() {
		return msgLastNameSpan;
	}

	public WebElement getMsgAddressSpan() {
		return msgAddressSpan;
	}

	public WebElement getMsgCcNosSpan() {
		return msgCcNosSpan;
	}

	public WebElement getMsgCcTypeSpan() {
		return msgCcTypeSpan;
	}

	public WebElement getMsgCcExpirySpan() {
		return msgCcExpirySpan;
	}

	public WebElement getMsgCvvSpan() {
		return msgCvvSpan;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCcNo() {
		return txtCcNo;
	}

	public WebElement getdDnCcType() {
		return dDnCcType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxtCvvNo() {
		return txtCvvNo;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookHotel(String firstName, String lastName, String address,String ccNo, String ccType, String expMonth, String expYear, String cvvNo) {
		sendText(getTxtFirstName(), firstName);
		sendText(getTxtLastName(), lastName);
		sendText(getTxtAddress(), address);
		sendText(getTxtCcNo(), ccNo);
		sendText(getdDnCcType(), ccType);
		sendText(getdDnExpMonth(), expMonth);
		sendText(getdDnExpYear(), expYear);
		sendText(getTxtCvvNo(), cvvNo);
		click(getBtnBookNow());

	}
	public String fNameError() {
		String string = getText(getMsgFirstNameSpan());
		return string;

	}
	public String lNameError() {
		String string = getText(getMsgLastNameSpan());
		return string;

	}
	public String addressError() {
		String string = getText(getMsgAddressSpan());
		return string;

	}
	public String ccNoError() {
		String string = getText(getMsgCcNosSpan());
		return string;

	}
	public String ccTypeError() {
		String string = getText(getMsgCcTypeSpan());
		return string;

	}
	public String expiryError() {
		String string = getText(getMsgCcExpirySpan());
		return string;

	}
	public String cvvError() {
		String string = getText(getMsgCvvSpan());
		return string;

	}

}
