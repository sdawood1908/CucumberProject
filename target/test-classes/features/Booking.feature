Feature: Verifying Adactin Hotel Page

  Scenario Outline: Verifying Adactin Booking page by selecting all feilds
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should Search Hotel using "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childrensPerRoom>"
    And User should Book hotel using "<firstName>","<lastName>","<address>"
      | ccNo             | ccType           | expMonth | expYear | cvvNo |
      | 1234567890987654 | American Express | January  |    2022 |  9987 |
      | 1234567890987654 | VISA             | February |    2022 |   876 |
      | 1234567890987654 | Master           | March    |    2022 |   546 |
      | 1234567890987654 | Other            | April    |    2022 |   345 |
    Then User should verify "Booking Confirmation" title

    Examples: 
      | userName     | password     | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | adultsPerRoom | childrensPerRoom | firstName | lastName | address     |
      | shaiksmokiee | shaiksmokiee | Sydney   | Hotel Creek | Standard | 3 - Three | 22/09/2021 | 23/09/2021 | 2 - Two       | 3 - Three        | shaik     | dawood   | omr,chennai |

  Scenario Outline: Verifying Adactin Booking page without entering any feilds
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should Search Hotel using "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childrensPerRoom>"
    And User should book hotel without entering any feilds
    Then User should verify "Please Enter your First Name","Please Enter you Last Name", "Please Enter your Address", "Use 16 digit Dummy Data Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type" , "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number" error messages

    Examples: 
      | userName     | password     | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | adultsPerRoom | childrensPerRoom |
      | shaiksmokiee | shaiksmokiee | Sydney   | Hotel Creek | Standard | 3 - Three | 22/09/2021 | 23/09/2021 | 1 - One       | 2 - Two          |
