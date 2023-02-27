package com.bridgelabz.sql.Day28_practice_problems;

public class JsonFileOps {
    public static final String FILE_PATH = "C:\\Day_28_Advance_AddressBook\\src\\main\\java\\com\\bridgelabz/addressMap.json";


    public void writeDataToDestination(HashMap<String, AddressBook> addressBookHashMap) throws IOException {
        Gson gson = new Gson();
        Writer writer = Files.newBufferedWriter(Paths.get(FILE_PATH));
        gson.toJson(addressBookHashMap, writer);
        writer.close();
    }

    public void readDataFromSource() throws IOException {
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));


        HashMap<?, ?> map = gson.fromJson(reader, HashMap.class);

        // print map entries
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        // close reader
        reader.close();
    }

}
