Feature: InvestopediaWebFeature
  This feature is to launch website and verify product and price

  Scenario: Verify Apple Inc product and price
    Given  I have logon to Investopedia website using the provided url "https://www.investopedia.com/markets/quote?tvwidgetsymbol=aapl"
    When I capture the Title and Stock price
    Then I verify title is "APPLE INC"
    And I Verify the price is below "150" USD
    And I Assert all and close browser
