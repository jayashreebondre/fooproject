*** Settings ***
Documentation                    This is the some basic info about the whole test suite.
Library                          SeleniumLibrary

*** Variables ***
${Browser}                       headlesschrome
${URL}                           http://rental10.infotiv.net/

*** Keywords ***
Begin Web Test
    Open browser                   about:blank              ${Browser}
Go to Web Page
    Load Page
    Verify Page Loaded
Load Page
    Go to                          http://rental10.infotiv.net/
Verify Page Loaded
    Wait until Page Contains        Create Login
Enter Login Details
    Input Text                     id:email  jayashree.bondre@gmail.com
    Input Text                     id:password  ITHS@123
Create Login
    Press keys                     id:createUser        RETURN
Verify Login
    wait until page contains       Create a new user
End Web Test
    Close Browser


*** Test Cases ***

User can access website
   [Documentation]                     This is some basic info about the test
   [Tags]                              Test 1
   Given open browser                   about: blank          ${Browser}
   When GO to                          http://rental10.infotiv.net/
   Then Wait until page contains       When do you want to make your trip?


Create User
    [Documentation]                Create User
    [Tags]                         Test 2
    Given Input text               id:email  jayashree.bondre@gmail.com
    And Input text                 id:password  ITHS@123
    When Press keys                id:createUser        RETURN
    Then Wait until page contains  Create a new user

Create a new user
   [Documentation]                  Create a new user
   [Tags]                           Test 3
   Given Input text                 id:name  Jayashree
   And Input text                   id:last  Bondre
   And Input text                   id:phone  1231231274
   And Input text                   id:emailCreate  jayashree174@gmail.com
   And Input text                   id:confirmEmail  jayashree174@gmail.com
   And Input text                   id:passwordCreate  ITHS@123
   And Input text                   id:confirmPassword  ITHS@123
   When Press keys                  id:create        RETURN
   Then Wait until page contains    When do you want to make your trip?

Logout
    [Documentation]                Logout from Infotive Car Rental
    [Tags]                         Test 4
    Press keys                     id:logout        RETURN
    Wait until page contains       ABOUT
    close Browser
