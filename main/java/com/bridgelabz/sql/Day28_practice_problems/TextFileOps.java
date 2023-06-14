package com.bridgelabz.sql.Day28_practice_problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextFileOps 
    
{
    public static final String FILE_PATH = "C:\\Day_28_Advance_AddressBook\\src\\main\\java\\com\\bridgelabz/addressMap.txt";


    public void writeDataToDestination(HashMap<String, AddressBook> addressBookHashMap) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for(Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()){
            String addressBookString = entry.toString().concat("\n");
            stringBuffer.append(addressBookString);
        }
        Files.write(Path.of(FILE_PATH), stringBuffer.toString().getBytes());
    }

    public void readDataFromSource() throws IOException {
        Files.lines(Path.of(FILE_PATH)).forEach( addressBookString -> System.out.println(addressBookString));
    }

}
