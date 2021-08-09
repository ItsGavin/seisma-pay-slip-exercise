# seisma-pay-slip-exercise

Seisma recruitment exercise: Monthly employee pay slip calculation program.
Exercise brief located at ``resources/Prereq Coding Test.docx``

Author: Gavin Ng

Email: gavin_ng96@hotmail.com

## Instructions

1. Clone the project (HTTPS):

        ~$ git clone https://github.com/ItsGavin/seisma-pay-slip-exercise.git

2. Run the build script:

        ~$ cd seisma-pay-slip-exercise
        ~/seisma-pay-slip-exercise/$ build.sh

This script compiles the project's class files and creates a 'bin' directory if it does not exist.

3. Run the program:

The program requires 2 command line arguements to run, the path to the input
CSV file and the path to the output CSV file. The following example command
defaults the paths of both CSV files to the resource folder, named ``input.csv``
and ``output.csv`` respectively

        ~/seisma-pay-slip-exercise/$ java -cp target/classes payslip/App resources/input.csv resources/output.csv

## Data Format

As detailed in the exercise brief, the input and output csv data are formatted in the following manner.
Note that ``annual salary`` should be a positive integer and ``super rate (%)`` should be within the range of 0% and 50%.

Input Formatted:

| First Name | Last Name | Annual Salary | Superannuation Rate (%) | Payment Start Date |
| --- | --- | --- | --- | --- |

Input Raw:

``first name, last name, annual salary, super rate (%), payment start date``

Output Formatted:

| Name | Pay Period | Gross Income | Income Tax | Net Income | Superannuation Amount |
 --- | --- | --- | --- | --- | --- |

Output Raw:

``name, pay period, gross income, income tax, net income, super``

## Project Structure

        ├── .gitiattributes                 - .gitiattribute file
        ├── .gitignore                      - .gitignore file
        ├── .travis.yml                     - .gitignore file
        ├── build.sh                        - Build script to compile classes
        ├── pom.xml                         - Maven pom file
        ├── README.md                       - Readme file
        ├── resources
        |   ├── input.csv                   - Employee information csv file
        |   └── Prereq Coding Test.docx     - Exercise brief
        └── src
            ├── main/java
            |   ├── model
            |   |   └── Employee.java       - Employee object model class
            |   ├── payslip
            |   |   └── App.java            - Main method
            |   |   └── InputParser.java    - Parser to convert CSV input
            |   └── utility
            |       └── Constants.java              - Constant variables
            |       └── InputOutOfRangeException    - Custom exception
            └── test/java                           - JUnit test cases
                ├── model
                |   └── EmployeeTest.java 
                └── payslip
                    └── InputParserTest.java

## Assumptions

- The input and output CSV files are assumed to have no headings and contain raw data from line 1 onwards

- CSV line delimiter is a comma(,)
