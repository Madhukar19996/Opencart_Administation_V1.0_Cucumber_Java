Feature: Customers

  Scenario: Add New Customer
    Given User Launch Chrome browser
    When User opens URL "https://demo3x.opencartreports.com/admin/index.php?route=common/login"
    And User enters Email as "demo" and Password as "demo"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "Warning: You do not have permission to modify customers!"
    And close browser
