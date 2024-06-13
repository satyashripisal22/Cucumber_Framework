Feature: Login


  @Sanity 
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

  @regression
  Scenario Outline: Successful Login with Valid as well as Invalid Credentials DDT
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

    Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |test@yourstore.com|admin|
    
    
    #when we executed feature file it will give you unimplemented method