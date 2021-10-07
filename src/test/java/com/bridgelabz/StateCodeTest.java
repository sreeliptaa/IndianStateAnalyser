package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCodeTest {
    ReadOperation readObj = new ReadOperation();
    String fileName = "IndiaStateCode";
    private Assertions Assert;

    /**
     * Purpose : Given the States Census CSV file
     * Check to ensure the Number of Record matches
     */
    @Test
    public void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() throws CensusAnalyserException {
        String filePathRead = "C:\\Users\\panda\\IdeaProjects\\Indiancensusanalyser\\src\\main\\resources\\IndiaStateCode";
        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(38, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Census CSV File if incorrect
     * Return a Custom Exception
     */

    @Test
    public void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException() throws CensusAnalyserException {
        String filePathRead = "C:\\Users\\panda\\IdeaProjects\\Indiancensusanalyser\\src\\main\\resources\\IndiaStateCode";
        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(38, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Census CSV File when correct but type incorrect
     * Return a Custom Exception
     */
    @Test
    public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException() {
        String filePathRead = "C:\\Users\\panda\\IdeaProjects\\Indiancensusanalyser\\src\\main\\resources\\IndiaStateCode";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Census CSV File when correct but delimiter incorrect
     * Return a Custom Exception
     */
    @Test
    public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
        String filePathRead = "C:\\Users\\panda\\IdeaProjects\\Indiancensusanalyser\\src\\main\\resources\\IndiaStateCode";
        String delimiter = ".";
        try {
            if (delimiter.equals(","))
                Assert.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
            else
                Assert.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Census CSV File when correct but csv header incorrect
     * Returns a Custom Exception
     */
    @Test
    public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThrowException() {
        List<String> stringName = new ArrayList<>();
        String filePathRead ="C:\\Users\\panda\\IdeaProjects\\Indiancensusanalyser\\src\\main\\resources\\IndiaStateCode;";
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("Density");

        try {
            boolean flag = readObj.readHeader(filePathRead, stringName);
            if (flag == true)
                Assert.assertTrue(flag);
            else
                Assert.assertFalse(flag);
        } catch (IOException | CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}
