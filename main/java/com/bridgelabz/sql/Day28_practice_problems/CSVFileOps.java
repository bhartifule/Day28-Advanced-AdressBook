package com.bridgelabz.sql.Day28_practice_problems;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CSVFileOps {
    public static final String FILE_PATH = "C:\\Day_28_Advance_AddressBook\\src\\main\\java\\com\\bridgelabz/addressMap.csv";
    public void writeDataToDestination(HashMap<String, AddressBook> addressBookHashMap) throws IOException {
        File file = new File(FILE_PATH);

        FileWriter outputfile = new FileWriter(file);

        CSVWriter writer = new CSVWriter(outputfile);

        for(Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()){
            String[] addressBookDetail = new String[2];
            addressBookDetail[0] = entry.getKey();
            addressBookDetail[1] = entry.getValue().toString();
            writer.writeNext(addressBookDetail);
        }

        writer.close();

    }

    public void readDataFromSource() throws IOException {
        try{
            FileReader filereader = new FileReader(FILE_PATH);

            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                for (String addressBookDetails : nextRecord) {
                    System.out.print(addressBookDetails + "\t");
                }
                System.out.println();
            }
        } catch (CsvValidationException e){

        }
    }

}
