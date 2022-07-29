## Workout Management System

**Introduction**

The objective of this project was to create a fully functional CRUD application for a relational database with at least 2 entities. I did this with the utilisation of supporting tools, methodologies and technologies that we've learned over the last several weeks at the academy.

I decided to use the subject of Workout Management System. Workout management system will help us to manage exercise with respect to time and calories. Workout may have multiple exercises.

**What was used for the project:**

1- A Jira board for project management

2- Git & GitHub for version source control

3- Java and Spring Boot for the creation of a restful API

4- JUnit and Mockito for unit and integration testing.

5- HTML, CSS and JavaScript for the front-end application, with Bootstrap.

6- Mysql Workbench for database

7- Post canary for API testing



**Project Management:**

Link to jira board: https://waseemkhanqa.atlassian.net/jira/software/projects/PRAC/boards/4/backlog

I created epics of Front-End, Back-End, Testing, Documentation for my backlog entries. Each entry had a priority and a story point estimate attached to them. I created stories of the main work and created multiple tasks for that story. Below is a screenshot of my Jira backlog:

![Jira board](https://github.com/waseem-khan-qa/WorkoutPracticalProject/blob/main/Documentation/jira%20backlog.JPG)




**Database:**

Below is an ERD to show the relationship between the entities:

![FF14 ERD after](https://github.com/waseem-khan-qa/WorkoutPracticalProject/blob/main/Documentation/ERD.PNG)


**Java back-end Design:**

Below is a UML of the back-end showing the relationship between classes:

![FF14PP uml](https://github.com/waseem-khan-qa/WorkoutPracticalProject/blob/main/Documentation/UML.PNG)






**Testing:**

For the Java back-end, integration tests used JUnit and MockMVC to test the functionality of the API, and Mockito was used for unit testing the service classes.
The below screenshots show all of my tests passing and my coverage of the back-end classes.

![Coverage](https://github.com/waseem-khan-qa/WorkoutPracticalProject/blob/main/Documentation/coverage.JPG)






**Front-end:**

This was built using HTML, CSS and JavaScript. The webpages have forms to create, read, update and delete a Workout or Exercise, with a "Add" Button. The read sections return the data in a table format. 

![Workouts](https://github.com/waseem-khan-qa/WorkoutPracticalProject/blob/main/Documentation/workouts.jpeg)
![Exercises](https://github.com/waseem-khan-qa/WorkoutPracticalProject/blob/main/Documentation/exercises.jpeg)



**Continued Development:**

-Add find by title functionality so users can find by their workouts or exercises by title rather than remembering their Id number.
