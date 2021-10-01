package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.FunctionalLib;
import com.pom.BookHotelPage;
import com.pom.BookedItinerary;
import com.pom.BookingConfirmation;
import com.pom.LoginPage;
import com.pom.SearchHotelPom;
import com.pom.SelectHotelPom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdactinStep extends FunctionalLib {

	String errorMessage;

	@Given("User is on the Adactin Hotel Page")
	public void browserLaunch() {
		getDriver("chrome");
		launchUrl("https://adactinhotelapp.com/");
	}

	@When("User should Login using {string} and {string}")
	public void login(String userName, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.login(userName, password);
	}

	@When("User should Search Hotel using {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void searchHotel(String location, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		SearchHotelPom hotelPom = new SearchHotelPom();
		hotelPom.searchHotel(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
	}

	@When("User should Book hotel using {string},{string},{string}")
	public void bookHotel(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) {
		SelectHotelPom hotelPom = new SelectHotelPom();
		hotelPom.selectHotel();
		List<Map<String,String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String ccNo = map.get("ccNo");
		String ccType = map.get("ccType");
		String expMonth = map.get("expMonth");
		String expYear = map.get("expYear");
		String cvvNo = map.get("cvvNo");

		BookHotelPage bookHotelPage = new BookHotelPage();
		bookHotelPage.bookHotel(firstName, lastName, address, ccNo, ccType, expMonth, expYear, cvvNo);
	}

	@When("User should cancel booking")
	public void cancelBooking() {
		BookingConfirmation confirmation = new BookingConfirmation();
		String orderId = confirmation.orderId();
		BookedItinerary bookedItinerary = new BookedItinerary();
		errorMessage = bookedItinerary.cancelBooking(orderId);

	}

	@Then("User should verify {string} Message")
	public void verifyMessage(String expectedErrorMessage) {
		Assert.assertEquals(expectedErrorMessage , errorMessage );
		driver.quit();
	}

	@When("User should click Booked Itinerary")
	public void clickBookedItinerary() {
		SearchHotelPom hotelPom = new SearchHotelPom();
		hotelPom.bookedItinerary();
	}

	@When("User should cancel booking using {string}")
	public void cancelBookingExistingOrderId(String orderId) {
		BookedItinerary bookedItinerary = new BookedItinerary();
		errorMessage = bookedItinerary.cancelBooking(orderId);
	}
	@When("User should book hotel without entering any feilds")
	public void bookHotelWithoutEnteringAnyFeilds() {
		SelectHotelPom hotelPom = new SelectHotelPom();
		hotelPom.selectHotel();
		BookHotelPage bookHotelPage = new BookHotelPage();
		WebElement btnBookNow = bookHotelPage.getBtnBookNow();
		click(btnBookNow);
	}

	@Then("User should verify {string}, {string}, {string}, {string}, {string} , {string} and {string} error messages")
	public void verifyErrorMessages(String firstName, String lastName, String address, String ccNo, String ccType, String expMonth, String cvvNo) {
		BookHotelPage bookHotelPage = new BookHotelPage();
		String fNameError = bookHotelPage.fNameError();
		Assert.assertEquals(firstName, fNameError);
		String lNameError = bookHotelPage.lNameError();
		Assert.assertEquals(lastName, lNameError);
		String addressError = bookHotelPage.addressError();
		Assert.assertEquals(address, addressError);
		String ccTypeError = bookHotelPage.ccTypeError();
		Assert.assertEquals(ccType, ccTypeError);
		String expiryError = bookHotelPage.expiryError();
		Assert.assertEquals(expMonth, expiryError);
		String cvvError = bookHotelPage.cvvError();
		Assert.assertEquals(cvvNo, cvvError);
		closeAllBrowsers();
	}

	@Then("User should verify {string} title")
	public void verifyTitle(String confirmation) {
		BookingConfirmation confirmation2 = new BookingConfirmation();
		String confirmationTxt = confirmation2.bookingConfirmationTxt();
		Assert.assertEquals(confirmation, confirmationTxt);
		closeAllBrowsers();
	}
	@Then("User should verify {string} Title Message")
	public void verifyTitleMessage(String string) {
		SelectHotelPom hotelPom = new SelectHotelPom();
		String title = hotelPom.getTitle();
		Assert.assertEquals(string, title);
		closeAllBrowsers();
	 
	}
	@When("User should Search Hotel using {string} , {string} , {string} , {string} and {string}")
	public void searchHotel(String location, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom) {
	    SearchHotelPom hotelPom = new SearchHotelPom();
	    hotelPom.mandatoryFeilds(location, checkInDate, noOfRooms, checkOutDate, adultsPerRoom);
	    
	}

	@Then("User should verify {string} and {string} error messages")
	public void user_should_verify_and_error_messages(String checkIn, String checkOut) {
	    SearchHotelPom hotelPom = new SearchHotelPom();
	    String checkInDateError = hotelPom.checkInDateError();
	    String checkOutDateError = hotelPom.checkOutDateError();
	    Assert.assertEquals(checkIn, checkInDateError);
	    Assert.assertEquals(checkOut, checkOutDateError);
	    closeAllBrowsers();
		
	}
	@When("User should click search hotel without entering any fields")
	public void searchHotelWithoutEnteringAnyFields() {
		SearchHotelPom hotelPom = new SearchHotelPom();
		hotelPom.withoutAnyFeild();
	  
	}

	@Then("User should verify {string} error message")
	public void user_should_verify_error_message(String errormsg) {
	    SearchHotelPom hotelPom = new SearchHotelPom();
	    String locationError = hotelPom.locationError();
	    Assert.assertEquals(errormsg, locationError);
	    closeAllBrowsers();
	    
	}
}
