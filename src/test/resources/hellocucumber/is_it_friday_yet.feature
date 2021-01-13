Feature: HTTP request
Scenario: Whether ResponseCode is 200
  Given I Set GET api endpoint
  When  Send a GET HTTP request
  Then  I receive valid ResponseCode 200
  And   Response is Json True
  And   Required Param is not empty


Scenario: Post Request
  Given I Set POST api endpoint
  When  Send a POST HTTP request
  Then  I receive valid ResponseCode 200
  And   Response is Json True
  And   Required Param is not empty

