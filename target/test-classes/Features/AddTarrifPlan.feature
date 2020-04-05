Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Title of your scenario

   Given user launch demo telecom site
   And user clicks on add tarrif button
   When user enters tarrif plan fields
   And user clicks on tarrif submit button
   Then user should be recieved congratulation message
  Scenario: Title of your scenario
    Given user launch demo telecom site
    And user clicks on add tarrif button
    When user enters tarrif plan fields with two dim list
      | 400 | 300 | 200 | 100 | 4 | 3 | 2 |
      | 300 | 200 | 100 | 100 | 5 | 4 | 3 |
     | 200 | 100 | 300 | 100 | 6 | 5 | 4 |
     | 100 | 400 | 400 | 100 | 4 | 6 | 5 |
    And user clicks on tarrif submit button
    Then user should be recieved congratulation message

  Scenario: Title of your scenario
    Given user launch demo telecom site
   And user clicks on add tarrif button
   When user enters tarrif plan fields with two dim list
      | MR  | FLM | FIM | FSP | LMC | IMC | SMC |
     | 400 | 300 | 200 | 100 |   4 |   3 |   2 |
      | 300 | 200 | 100 | 100 |   5 |   4 |   3 |
     | 200 | 100 | 300 | 100 |   6 |   5 |   4 |
     | 100 | 400 | 400 | 100 |   4 |   6 |   5 |
   And user clicks on tarrif submit button
    Then user should be recieved congratulation message
    
    
    
    
    Scenario Outline:
    Given user launch demo telecom site
    And user clicks on add tarrif button
    When user enters tarrif plan fields with two dim list"<MR>","<FLM>","<FIM>","<FSP>","<LMC>","<IMC>","<SMC>"
    And user clicks on tarrif submit button
    Then user should be recieved congratulation message
    
    Examples:
      | MR  | FLM | FIM | FSP | LMC | IMC | SMC |
      | 400 | 300 | 200 | 100 |   4 |   3 |   2 |
      | 300 | 200 | 100 | 100 |   5 |   4 |   3 |
      | 200 | 100 | 300 | 100 |   6 |   5 |   4 |
      | 100 | 400 | 400 | 100 |   4 |   6 |   5 | 
