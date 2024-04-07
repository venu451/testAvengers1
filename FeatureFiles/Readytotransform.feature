Feature: Filling out the Ready to Transform Form

  Scenario: Submitting the form with an invalid data atleast one data
    Given the user is on the home page of coursera
    When the user enters click on the For Enterprise
    When the user enters into that For Enterprise page and click on the Solutions
    When the user enters into the Solutions and navigate to Coursera for Campus section
    Then the user should be redirected to the Registration form  page
    And fill the FirstName and LastName and Email and Passwrod
    Then click on the submit button
    And the user should see a Error message
    
