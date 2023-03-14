Feature:
  Scenario:
    Given the user started a deferred transaction on Merchant Demo
    And the user check the Developer Options checkbox
    And the user select the Custom-data as
    When the transaction is concluded
    Then the sys register the merchant reference correctly in the transaction
