@test

Feature: Test filter Players list

  Background:login to the system
    Given login with given credentials as admin
    Then admin should see admin-index page

  Scenario:filter Players list
    When admin clicks on players button
    Then admin should see Player Management page
    When admin fills given data to user name filter input field
    Then admin should see pla players list with only given data on user name filter field
