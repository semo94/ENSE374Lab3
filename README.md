# ENSE374Lab3
A Java application that allows a user to choose an account that best suits their requirements. The application will ask the user a number of questions about their requirements and then choose the appropriate account.

![](https://github.com/semo94/ENSE374Lab3/blob/master/Class_Diagram.png)

## Usage Guide

### 1) Compile and run the app
From within the root directory:
~~~
javac -classpath . Bank.java
java Bank
~~~

### 2) Select the mood
Enter ***1*** to run the app or ***2*** to test the app

### 3) Follow the instructions
If you run the app, it will ask you a bunch of questions in order to determine the best account type that fits your needs. Upon the survey completion, you'll have to confirm the recommended account or take the survey again. If the recommendation confirmed, you'll be asked to enter an initial deposite then an account will be created accordingly. The account specifications will be displayed to you.


## Algorithm Explanation
This running algorithm depends on a scoring mechanism. Each account type will initially have a score of zero. On each question, the algorithm will increase the score of each account type that fulfills the criteria of the user's answer. After finishing the survey, the algorithm will suggest the account that got the highest score. Moreover, the algorithm can repeat itself if the user chose to retake the survey. At any point, if the user entered an invalid value, the algorithm will display an error message and exit the system.
