Feature: User will use 'todo list' to manage tasks and used advanced functionality such as removing/editing/Clearing tasks (Basic test)

Scenario: Remove items from the list
Given the list has 'bread' , 'butter', 'milk', 'biscut', 'chocolate'
When I remove 'milk' & 'biscut'
Then two items are removed & there is a strike throgh on them
And Bottom left displays '3 items are left'
And 'All' displays all values
And 'Active' displays 'Bread', 'Butter' & 'Chocolate'
And 'Completed' displays 'Milk', 'Biscut'
And 'Clear completed' is displayed

Scenario: Clear completed functionality works
Given the list has 'bread' , 'butter', 'milk', 'biscut', 'chocolate'
When I remove 'milk' & 'biscut'
And click 'Clear completed'
Then Both the values are removed from the list
And 'Clear completed' is not displayed

Scenario: Remove all values using Clear completed
Given the list has 'milk', 'biscut'
When I remove 'milk' & 'biscut'
And click 'Clear completed'
Then Both the values are removed from the list
And 'All', 'Active', 'Completed' & 'Clear completed' is no longer displayed

Scenario: Edit the existing value
Given the list has 'milk', 'biscut'
When I edit 'milk' to 'wine'
Then 'wine' is displayed

Scenario: Remove the existing value
Given the list has 'milk', 'biscut'
When I click cross button besides 'milk'
Then 'milk' is removed
And Bottom left displays '1 item left'
And 'Clear completed' is not displayed