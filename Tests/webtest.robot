*** Settings ***
Documentation                    This is the some basic info about the whole test suite.
Library                          SeleniumLibrary

*** Variables ***
${Browser}                       headlesschrome
${URL}                           http://rental10.infotiv.net/

*** Keywords ***
Begin Web Test
    Open browser                 about:blank              ${Browser}
    set selenium speed           1
Go to Web Page
    Load Page
    Verify Page Loaded
Load Page
    Go to                         ${URL}
Verify Page Loaded
    Wait until Page Contains       Login Test

Enter Search Term
    Input Text                     id:email  jayashree.bondre@gmail.com
    Input Text                     id:password  ITHS@123
Submit Search
    Press keys                     id:login        RETURN
Verify Search Completed
    wait until page contains       When do you want to make your trip?
End Web Test
    Close Browser

*** Test Cases ***

User can access website
    [Documentation]                   This is some basic info about the test
    [Tags]                            Test 1
    Given open browser                about: blank         ${Browser}
    When GO to                        ${URL}
    Then Wait until page contains     When do you want to make your trip?


Login
    [Documentation]                Login Test
    [Tags]                         Test 2
    Given Input text               id:email  jayashree57@gmail.com
    And Input text                 id:password  ITHS@123
    When Press keys                id:login        RETURN
    Then Wait until page contains  When do you want to make your trip?

Make your trip
    [Documentation]                Make your trip
    [Tags]                         Test 3
    Given Input text               id:start   04-20
    And Input text                 id:end     04-23
    When Press keys                id:continue        RETURN
    Then Wait until page contains  What would you like to drive?

Book your trip
    [Documentation]                Book your trip
    [Tags]                         Test 4
    Press keys                     id:bookQ7pass5      RETURN
    Wait until page contains       Confirm booking



Confirm booking of Tesla
    [Documentation]                   Confirm booking
    [Tags]                            Test 7
    Given Input text                  id:cardNum   1111222233334444
    And Input text                    id:fullName   Visa
    #And Input text                    id:month1   1
    #And Input text                    id:month2018   2018
    And Input text                    id:cvc   123
    When Press keys                   id:confirm        RETURN
    Then Wait until page contains     now ready for pickup


Logout
    [Documentation]                Logout from Infotive Car Rental
    [Tags]                         Test 4
    Press keys                     id:logout        RETURN
    Wait until page contains       ABOUT
    close Browser
