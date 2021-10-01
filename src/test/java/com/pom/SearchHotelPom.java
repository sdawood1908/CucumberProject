package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.FunctionalLib;

public class SearchHotelPom extends FunctionalLib {

	public SearchHotelPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location")
	private WebElement dDnLocation;

	@FindBy(id="hotels")
	private WebElement dDnHotels;

	@FindBy(id="room_type")
	private WebElement dDnRoomType;

	@FindBy(id="room_nos")
	private WebElement dDnRoomNo;

	@FindBy(id="datepick_in")
	private WebElement txtCheckIn;

	@FindBy(id="datepick_out")
	private WebElement txtCheckOut;

	@FindBy(id="adult_room")
	private WebElement dDnAdult;

	@FindBy(id="child_room")
	private WebElement dDnChildRoom;

	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement lnkBookedItinerary;
	
	@FindBy(id="checkin_span")
	private WebElement checkInDateError;
	
	@FindBy(id="checkout_span")
	private WebElement checkOutDateError;
	
	@FindBy(id="location_span")
	private WebElement locationError;

	public WebElement getLocationError() {
		return locationError;
	}

	public WebElement getCheckInDateError() {
		return checkInDateError;
	}

	public WebElement getCheckOutDateError() {
		return checkOutDateError;
	}

	public WebElement getLnkBookedItinerary() {
		return lnkBookedItinerary;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getdDnAdult() {
		return dDnAdult;
	}

	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}


	public void searchHotel(String location, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {

		selectOptionsFromDropDown(getdDnLocation(), "visibleText", location);
		selectOptionsFromDropDown(getdDnHotels(), "visibleText", hotels);
		selectOptionsFromDropDown(getdDnRoomType(), "visibleText", roomType);
		selectOptionsFromDropDown(getdDnRoomNo(), "visibleText", noOfRooms);
		sendText(getTxtCheckIn(), checkInDate);
		sendText(getTxtCheckOut(), checkOutDate);
		selectOptionsFromDropDown(getdDnAdult(), "visibleText", adultsPerRoom);
		selectOptionsFromDropDown(getdDnChildRoom(), "visibleText", childrenPerRoom);
		click(getBtnSearch());

	}
	public void bookedItinerary() {
		click(getLnkBookedItinerary());
	}
	public void mandatoryFeilds(String location,String checkInDate,String noOfRooms, String checkOutDate, String adultsPerRoom) {
		selectOptionsFromDropDown(getdDnLocation(), "visibleText", location);
		selectOptionsFromDropDown(getdDnRoomNo(), "visibleText", noOfRooms);
		getTxtCheckIn().clear();
		sendText(getTxtCheckIn(), checkInDate);
		getTxtCheckOut().clear();
		sendText(getTxtCheckOut(), checkOutDate);
		selectOptionsFromDropDown(getdDnAdult(), "visibleText", adultsPerRoom);
		click(getBtnSearch());
	}
	
	public String checkInDateError() {
		String string = getText(getCheckInDateError());
		return string;
	}
	public String checkOutDateError() {
		String string = getText(getCheckOutDateError());
		return string;

	}
	public void withoutAnyFeild() {
		click(getBtnSearch());

	}
	public String locationError() {
		String string = getText(getLocationError());
		return string;

	}

}
