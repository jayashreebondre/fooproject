*** Setting ***
Documentation                   This is some basic infor about the whole test suite
Library                         SeleniumLibrary
*** Variables ***
${URL}                           http://rental10.infotiv.net/
${BROWSER}                       Chrome
${LOGIN_TESTBOX}                 //*[@id="email"]
${PASSWORD_TESTBOX}              //*[@id="password"]
${LOGIN_BUTTON}                  //*[@id="login"]
${SUCCESS_LOGIN-LABLE}           //*[@id="welcomePhrase"]
${LOGOUT_BUTTON}                  //*[@id="logout"]

*** Keywords ***
Navigate to the home page
    Open browser                     ${URL}                     ${BROWSER}
Enter Email and Password
    Click Element                    ${LOGIN_TESTBOX}
    Input Text                       ${LOGIN_TESTBOX}       jayashree58@gmail.com
    Click Element                    ${PASSWORD_TESTBOX}
    Input Text                       ${PASSWORD_TESTBOX}    ITHS@123
Click Login Button
    Click Element                    ${LOGIN_BUTTON}
Verify Login Success Message
    Wait Until Element Is Visible    ${SUCCESS_LOGIN-LABLE}
    Element Should Be Visible        ${SUCCESS_LOGIN-LABLE}
Close current browser
   Close Browser
Click Logout Button
    Click Element                    ${LOGOUT_BUTTON}


*** Test Cases ***
User can login by supplying valid credentials
    [Documentation]
    [Tags]                                   USER_LOGIN
    Navigate to the home page
    Enter Email and Password
    Click Login Button
    set selenium speed                         1
    Verify Login Success Message
    #Close current browser


Logout
    [Documentation]                Logout from Infotive Car Rental
    [Tags]                         Test 2
    Click Logout Button
    Wait until page contains       ABOUT
    Close current browser