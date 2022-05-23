Feature: User will use 'todo list' to manage tasks which includes only adding tasks (Basic test)

Scenario: Verify the web elements when the user navigates to the page
Given the user is in this page
Then ToDos title should be displayed
And Blank text box is displayed
And 'What needs to be done' is the place holder
And Footer text is present


Scenario: Add items to empty list
Given an empty todo list
When I add 'Buy milk' and 'Buy bread'
Then two items are listed
And Bottom left displays '2 items left'
And 'All' , 'Active' & 'Complete' are displayed
And 'Clear completed' is not displayed