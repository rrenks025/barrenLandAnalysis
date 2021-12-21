# Barren Land Analysis
## Description
You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399, 599). A portion of the farm is barren, and all the barren land is in the form of rectangles. Due to these rectangles of barren land, the remaining area of fertile land is in no particular shape. An area of fertile land is defined as the largest area of land that is not covered by any of the rectangles of barren land. 

Read input from STDIN. Print output to STDOUT 

## Input 
You are given a set of rectangles that contain the barren land. These rectangles are defined in a string, which consists of four integers separated by single spaces, with no additional spaces in the string. The first two integers are the coordinates of the bottom left corner in the given rectangle, and the last two integers are the coordinates of the top right corner. 

## Output
Output all the fertile land area in square meters, sorted from smallest area to greatest, separated by a space. 

## Samples
| Input  | Output |
| ------------- | ------------- |
| {"0 292 399 307"} | 116800 116800  |
| {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"}   | 22816 192608  |

## Build Environment
This project was built using Eclipse IDE for Java Developers.
The project files are included in the repository and the IDE can be used to run the source and test code.
Running main will wait until a string of barren land rectangles is input, then will proceed to run.

### Building and running via command line
The source and test code can also be built and ran via command line.  These steps assume that Java is installed and configured on the machine.
See the table below for commands on running or building. Run the command in the corresponding "Run From Directory".
| Step  | Run From Directory | Command
| ------------- | ------------- | ------------- |
| Build Source | src  | javac -d ../bin com/targetCaseStudy/barrenLandAnalysis/*.java
| Build Test | test | javac -d ../bin -cp junit-4.13.2.jar;../src;. com/targetCaseStudy/barrenLandAnalysis/barrenLandAnalysisTest.java
| Run Main | bin | java com.targetCaseStudy.barrenLandAnalysis.Main
| Run Test | bin | java -cp ../test/junit-4.13.2.jar;../test/hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore com.targetCaseStudy.barrenLandAnalysis.barrenLandAnalysisTest

### Versions Used
| Item  | Version |
| ------------- | ------------- |
| Java | 17.0.1  |
| Hamcrest Core | 1.3 |
| JUnit | 4.13.2 |

## Testing
Testing was done in the following ways:
1. Using JUnit
2. Changing main to use a testString defined in code
3. Using stdin to input parameters

Method 1 is used to test cases in which the input meets the definitions of the problem.
Methods 2 and 3 are used to test cases in which the input does not meet the definitions of the problem. (i.e. an input coordinate is outside of the grid, the input is empty, or a rectangle doesn't have 4 coordinates)
