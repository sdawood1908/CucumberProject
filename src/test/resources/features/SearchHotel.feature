Feature: Verifying Adactin Hotel Page

  Scenario Outline: Verifying Adactin Search Hotel page by selecting all feilds
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should Search Hotel using "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childrens>"
    Then User should verify "Select Hotel" Title Message

    Examples: 
      | userName     | password     | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | adultsPerRoom | childrens |
      | shaiksmokiee | shaiksmokiee | Sydney   | Hotel Creek | Standard | 3 - Three | 22/09/2021 | 23/09/2021 | 3 - Three     | 3 - Three |

  Scenario Outline: Verfying Adactin Search Hotel page by selecting only Mandatory feilds
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should Search Hotel using "<location>" , "<noOfRooms>" , "<checkIn>" , "<checkOut>" and "<adultsPerRoom>"
    Then User should verify "Select Hotel" Title Message

    Examples: 
      | userName     | password     | location | noOfRooms | checkIn    | checkOut   | adultsPerRoom |
      | shaiksmokiee | shaiksmokiee | Sydney   | 3 - Three | 03/10/2021 | 05/10/2021 | 1 - One       |

  Scenario Outline: Verfying Adactin Search Hotel page with invalid check in and check out dates
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should Search Hotel using "<location>" , "<noOfRooms>" , "<checkIn>" , "<checkOut>" and "<adultsPerRoom>"
    Then User should verify "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date" error messages

    Examples: 
      | userName     | password     | location | noOfRooms | checkIn    | checkOut   | adultsPerRoom |
      | shaiksmokiee | shaiksmokiee | Sydney   | 3 - Three | 03/10/2021 | 02/10/2021 | 1 - One       |

  Scenario Outline: Verfying Adactin Search Hotel page without entering any feilds
    Given User is on the Adactin Hotel Page
    When User should Login using "<userName>" and "<password>"
    And User should click search hotel without entering any fields
    Then User should verify "Please Select a Location" error message

    Examples: 
      | userName     | password     |
      | shaiksmokiee | shaiksmokiee |
