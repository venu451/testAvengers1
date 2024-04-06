Feature: Capturing Course Info

  Scenario: Course Info
    Given the user is navigated to the coursera home page
    When user enters input field as "Web Development Courses" and clicks on search button
    And select the language as english and select the level as Beginner
    Then the user should print the first two courses title, rating and hours of learning
