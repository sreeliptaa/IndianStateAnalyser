package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCode {
    public static void main(String[] args) throws CensusAnalyserException, IOException {
        String filePathRead = "C:\\Users\\panda\\IdeaProjects\\Indiancensusanalyser\\src\\main\\resources\\IndiaStateCode";
        String fileName = "StateCode";
        String delimiter = ",";
        List<String> stringName = new ArrayList<>();
        stringName.add("SrNo");
        stringName.add("State");
        stringName.add("Name");
        stringName.add("TIN");
        stringName.add("StateCode");

        ReadOperation readObj = new ReadOperation();
        int count = readObj.readDataCount(filePathRead, fileName);
        System.out.println(count);

        readObj.readDelimiter(filePathRead, delimiter);
        readObj.readHeader(filePathRead, stringName);
    }
}
