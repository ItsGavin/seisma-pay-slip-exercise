# seisma-pay-slip-exercise
Seisma recruitment exercise: Monthly employee pay slip calculation program.

Exercise brief located at ``resources/Prereq Coding Test.docx``

## Instructions
1. Clone the project (HTTPS):

  ~$ git clone https://github.com/ItsGavin/seisma-pay-slip-exercise.git

2. Run the build script:

  ~$ cd seisma-pay-slip-exercise
  ~/seisma-pay-slip-exercise/$ build.sh

This script compiles the project's class files and creates a 'bin' directory if it does not exist.

3. Run the program:

  ~/seisma-pay-slip-exercise/$ java -cp bin Main

## Data Format
As detailed in the exercise brief, the input and output csv data are formatted in the following manner.

Input Formatted:

| First Name | Last Name | Annual Salary | Superannuation Rate (%) | Payment Start Date |

Input Raw:

``first name, last name, annual salary, super rate (%), payment start date``

Output Formatted:

| Name | Pay Period | Gross Income | Income Tax | Net Income | Superannuation Amount |

Output Raw:
``name, pay period, gross income, income tax, net income, super``

<!-- ## Editing Variables
#### Input csv (Employee Information)
By default, the program reads a file ``input.csv`` from the ``resources`` folder to obtain employee information data.

To change this, edit the global variable ``INPUTSOURCE`` in ``Main.java`` (line 21) to point to the new input csv.

#### Output csv (Pay Slip Information)
By default, the program writes the processed pay slip information to a file ``output.csv`` in the ``resources`` folder.

To change this, edit the global variable ``OUTPUTSOURCE`` in ``Main.java`` (line 24) to point to the new output csv. -->

<!-- ## Project Structure
  ├── README.md                     - Readme file
  ├── build.sh                      - Build script to compile classes
  ├── .gitignore                    - .gitignore file
  ├── resources
  |   ├── input.csv                 - Employee information csv file
  |   └── Prereq Coding Test.docx   - Exercise brief
  └── src
      ├── Calculations.java         - Class containing pay slip information calculation methods
      └── Main.java                 - Main method -->

## Assumptions
- The input and output CSV files are assumed to have no headings and contain raw data from line 1 onwards

- CSV line delimiter is a comma(,)