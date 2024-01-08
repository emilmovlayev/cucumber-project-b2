Feature: Docuport Login Logout Feature

  @smoke @eml
  Scenario: Login as a client
    Given user is on Docuport login page
    When user enters username for client
    And user enters password for client
    And user clicks login button
    Then user should see the home page for client

    @regression
    Scenario: Login as an employee
      Given user is on Docuport login page
      When user enters username for employee
      And user enters password for employee
      And user clicks login button
      Then user should see the home page for employee

  @smoke
Scenario: Login as an advisor
  Given user is on Docuport login page
  When user enters username for advisor
  And user enters password for advisor
  And user clicks login button
  Then user should see the home page for advisor

  @smoke
  Scenario: Login as an supervisor
    Given user is on Docuport login page
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    Then user should see the home page for supervisor