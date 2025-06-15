Feature: Customers
Background: Steps common for all scenrios
    Given User Launch Chrome browser
    When User opens URL "https://demo3x.opencartreports.com/admin/index.php?route=common/login"
    And User enters Email as "demo" and Password as "demo"
    And Click on Login
    Then User can view Dashboard


  Scenario: Add New Customer

    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "Warning: You do not have permission to modify customers!"
    And close browser

  Scenario: Filter Customer by Email

    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer EMail
    When Click on filter button
    Then User should found Email in the Filter table
    And close browser

  Scenario: Filter Customer by Name

    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer Name
    When Click on filter button
    Then User should found name in the Filter table
    And close browser
