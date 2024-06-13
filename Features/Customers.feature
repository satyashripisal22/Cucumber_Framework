Feature: Customers
Background: Steps common for all Scenarios
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard


    @regression
    Scenario: Add New Customer
    When User click on customers menu 
    And click on customers menu item
    And click on Add new button
    Then User can view Add new customer page 
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
    
    @Sanity
    Scenario: Search Customer by Email
    When User click on customers menu 
    And click on customers menu item
    And Enter Customer Email
    When Click on search button
    Then User should found Email in the Search table
    And close browser
    
    @regression
    Scenario: Search Customer by Name
    When User click on customers menu 
    And click on customers menu item
    And Enter Customer FirstName
    And Enter Customer LastName
    When Click on search button
    Then User should found Name in the Search table
    And close browser



 
