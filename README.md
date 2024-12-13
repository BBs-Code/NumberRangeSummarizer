# Number Range Summarizer

`BBsNumberRangeSummarizer` summarizes a comma delimited String of ascending integers by collapsing sequential integers into a range. 

## Assumptions
`BBsNumberRangeSummarizer` attempts to make minimal assumptions about the data. 

The string input given to the `collect` function must simply be a comma delimited sequence of Integers and allows for spacing between the Integers and the commas. If an invalid Integer is encountered during parsing, a `NumberFormatException` is thrown, in line with the exception from `Integer.parseInt`. 

The `summarizeCollection` function will first remove the duplicates and sort the collection given before creating the summary. 

## Dependencies
This package was written with Java 16 and Maven 3.9.4, and utilizes JUnit 5.11. No external packages are required.

## Usage
`mvn compile` - Compiles the package for use.

`mvn test` - Runs the included tests. 

`mvn clean` - Removes all compiled files.

## Examples
The included tests provide many examples of how to use `BBsNumberRangeSummarizer`. A few examples are also given below.

    Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31

    Result: "1, 3, 6-8, 12-15, 21-24, 31"


    Sample Input: "22, 91, 1, 5, 9, 10, 11,2"

    Result: "1-2, 5, 9-11, 22, 91"

## Notes
While `collect` could be implemented more compactly with `String.split`, Baeldung.com did benchmarking to compare the two approaches, and found that using `String.indexOf` and `String.substring` to be more efficient. This is likely due to `String.split` making use of regex which can experience poor performance.

The Baeldung comparison can be found at https://www.baeldung.com/java-string-performance. 
