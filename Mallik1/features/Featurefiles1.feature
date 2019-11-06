Feature: Secure Pay 
Scenario: Secure Pay page contact us page
Given Launch google page
 And Search for SecurePay
When Open SecurePay page
Then Verify Securepay home page
When On home page click on Support and Contact us page
Then Contact us page is displayed
 And Fill Contact us form
