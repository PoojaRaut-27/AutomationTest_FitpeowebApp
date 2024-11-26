Feature: Revenue Calculator Functionality

Scenario: Adjusting slider, updating text field, selecting CPT codes, and validating reimbursement values
    Given user on the FitPeo Homepage
    When user navigate to the Revenue Calculator Page
    And  scroll down to the slider section
    Then the revenue calculator slider should be visible

    When user can adjust the slider to set its value to 820
    And the text field value should be updated to 820

    When user click on the text field associated with the slider
    And user enter the value 560 in the text field
    Then the slider should update its position to reflect the value 560

    When user scroll down further to the CPT codes section
    And select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474 checkboxes should be selected
    

    When user validate the Total Recurring Reimbursement
    Then the header displaying "Total Recurring Reimbursement for all Patients Per Month:" should show the value "$110700"
    