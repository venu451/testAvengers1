Feature: Filling out the Ready to Transform Form

  Scenario Outline: Submitting the form with an invalid data atleast one data
    Given the user is on the home page of coursera
    When the user enters click on the For Enterprise
    When the user enters into that For Enterprise page and click on the Solutions
    When the user enters into the Solutions and navigate to Coursera for Campus section
    Then the user should be redirected to the Registration form  page
    And fill the FirstName and LastName and Email and Password as by passing  "<row_index>"
    Then click on the submit button
    And the user should see a Error message

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
