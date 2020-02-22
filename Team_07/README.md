# Project 3 - Team 7

## How to run
```sh
$ cd Team_07/src
$ javac MainWindow.java
$ java MainWindow
```

## Sprint Review
#### What did we do?
- Fixed existing bugs from Sprint 1
- Cleared the Product Backlog

#### What could be better?
- Time management, along with effective planning & estimation.

#### What we will do?
- Create next Sprint Backlog
- Fix existing bugs

## Sprint Retrospective

#### What did we do well?
- GUI looks pretty good
- Code clean up after each major task
- Sprint 1 pending tasks are completed

#### What should we have done better?
- Could have switched from using JPanels (for shape) to paintComponent sooner
- Lack of planning lead to some rework during the sprint
- Knowledge acquisition's estimation

#### What should we start doing?
- Assigning related user stories to same person
- Assigning user stories depending on the expertise of the person
- Better estimation for each task

#### What should we stop doing?
- Hurrying up to code without proper planning and estimation

#### What should we keep doing? 
- Code clean up and unit testing after each major task

## Product Backlog
|  **Sprint** | **User Stories** | **Acceptance Criteria** | **Status** | **Effort** | **Priority** | **Author** |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1 | As a user, I want to have a window with two blank panels (left and right) | Size of window must be 1000*800px.<br/>Size of left panel must be 200*800px<br/>Size of right panel must be 800*800px | Completed | 1 | Must have | Aravind |
|  1 | As a user, I want to have a panel (shapes panel) which contains a triangle, a circle and a square so that I can select a shape by clicking on the shape | Size of the panel must be 200*800px | Completed | 3 | Must have | Aditya Bajaj |
|  1 | As a user, I want a panel (workspace) so that I can create a selected shape when I click anywhere in that panel | 1. Size of the panel must be 800*800px<br/>2. Shape should be created where the user clicks<br/>3. Shape must be same as the one in the shapes panel | Completed | 3 | Must have | Praveen |
|  1 | As a user, I want to drag the shapes in workspace panel. | 1. Response time while dragging a shape must be less than one second<br/>2. Shape must not move out of the window if the mouse cursor goes out of the window while dragging shape | Completed | 5 | Must have | Karandeep |
|  1 | As a developer, I want to replace the window's left blank panel with the shapes panel and window's right panel with the workspace panel | 1. Shapes and workspace panels must fit properly in the window<br/>2. Only selected shape should be create when user clicks in the workspace panel | Completed | 3 | Must have | Aravind |
|  2 | As a user, I want a dot at the center of the circle | 1. Creating a new circle must include the dot<br/>2. Dots should move along when the circle is moved | Completed | 2 | Must have | Karandeep |
|  2 | As a user, I want three dots inside the triangle near the 3 corners | 1. Creating a new triangle must include the dots<br/>2. Dots should move along when the circle is moved | Completed | 2 | Must have | Karandeep |
|  2 | As a user, I want two vertical bars inside the square | 1. Creating a new square must include the bars<br/>2. Dots should move along when the circle is moved | Completed | 2 | Must have | Aditya |
|  2 | As a user, I want to make a line connection from one dot (inside a circle or triangle) to another dot (inside another circle or triangle) when I click on the dots one by one | 1. There must be only one line connection from and to a dot<br/>2. Line connection must be between dots of two different shapes only<br/>3. Line connection can only be made between the dots of shapes in the workspace panel only | Completed | 5 | Must have | Karandeep |
|  2 | As a user, I want to make a line connection from one vertical bar (inside a square) to another vertical bar (inside another square) when I click on the bars one by one | 1. There can be multiple connections from and to a vertical bar<br/>2. Line connection must be between bars of two different shapes only<br/>3. Line connection can only be made between the vertical bars of the squares in the workspace panel only | Completed | 5 | Must have | Karandeep |
|  2 | As a user, I want to make a line connection from one vertical bar (inside a square) to another dot (inside another circle or triangle) when I click on the dot and the bar one by one | 1. There can be multiple connections from and to a vertical bar<br/>2. Line connection must be between bars of two different shapes only<br/>3. Line connection can only be made between the vertical bars of the squares in the workspace panel only | Completed | 5 | Must have | Aravind |
|  2 | As a user, I want that the line connections of a shape must move when the shape is moved | 1. All the line connections from/to a shape must move when the shape is moved. | Completed | 5 | Must have | Aravind |
|  2 | As a developer, I want to try different line connection combinations and make sure that all the line connections move as we move the shapes |  | Completed | 2 | Must have | Aditya |
|  2 | As a developer, I want to learn about saving java objects’ information in a file |  | Completed | 3 | Nice to have | Aravind |
|  2 | As a developer, I want to learn about open java objects’ information saved as a file and add them to the application |  | Completed | 3 | Nice to have | Praveen |
|  2 | As a user, I want a menu bar which contains two items - Save and Open |  | Completed | 1 | Nice to have | Praveen |
|  2 | As a user, I want to save my workspace panel as a file when I click on the save item in the menu bar so that I can view or make changes to the same workspace later |  | Completed | 8 | Nice to have | Aditya |
|  2 | As a user, I want to open the previously saved workspace files when I click on the open item in the menu bar so that I can view or edit the saved workspace | 1. User must be able to view and make changes to the workspace panel<br/>2. The opened workspace must be same as the saved workspace panel | Completed | 8 | Nice to have | Praveen |

### Authors
- Aditya Bajaj
- Aravind Thillai Villalan
- Karandeep Singh Grewal
- Praveen Kumar P

### Acknowledgements
- Javier Gonzalez Sanchez
