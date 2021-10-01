Feature: Verifying Adactin Hotel Page

  Scenario Outline: Cancel Booking in Adactin Page entering all feilds
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should Search Hotel using "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childrenPerRoom>"
    And User should Book hotel using "<firstName>","<lastName>","<address>"
      | ccNo             | ccType           | expMonth | expYear | cvvNo |
      | 1234567890987654 | American Express | January  |    2022 |   987 |
      | 1234567890987654 | VISA             | February |    2022 |   876 |
      | 1234567890987654 | Master           | March    |    2022 |   546 |
      | 1234567890987654 | Other            | April    |    2022 |   345 |
    And User should cancel booking
    Then User should verify "The booking has been cancelled." Message

    Examples: 
      | userName     | password     | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | adultsPerRoom | childrenPerRoom | firstName | lastName | address     | ccNo             |
      | shaiksmokiee | shaiksmokiee | Sydney   | Hotel Creek | Standard | 3 - Three | 22/09/2021 | 23/09/2021 | 3 - Three     | 2 - Two         | shaik     | dawood   | omr,chennai | 1234567890987654 |

  Scenario Outline: Cancel Booking in Adactin Page without entering any feilds
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should click Booked Itinerary
    And User should cancel booking using "<existingOrderId>"
    Then User should verify "The booking has been cancelled." Message

    Examples: 
      | userName     | password     | existingOrderId |
      | shaiksmokiee | shaiksmokiee | V501L2N37D      |
