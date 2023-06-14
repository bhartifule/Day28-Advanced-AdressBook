package com.bridgelabz.sql.Day28_practice_problems;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class AddressBookMain
{
	 static  HashMap<String,AddressBook> addressBookMap = new HashMap<>();   // create hashmap to store addressbooks

	    // String --> Key
	    //Key --> Address book Name
	    // AddressBook --> Value(In address book we will store our contacts)
	    //Addressbook --> new Object
	    public static void main(String[] args) {
			
	        System.out.println("WelCome To AddressBook Program");
	        Scanner scanner = new Scanner(System.in);
	        int opration;   // declared a variable
	        do {   // do while = it will execute atleast one before checking the condition
	            System.out.println("1. ADD Addressbook \n2. Perform Operations into AddressBook " +
	                    "\n3 Display all address book \n 4 Write Addressbooks to file \n 5 Read from file \n 6 EXIT  ");
	            System.out.println("Enter the Operation Number");
	            opration = scanner.nextInt();
	            scanner.nextLine();
	            switch (opration) {
	                case 1:
	                    System.out.println("Enter the name of address book");
	                    String name =scanner.nextLine();
	                    AddressBook addressBook = new AddressBook();
	                    addressBookMap.put(name,addressBook);

	                    break;
	                case 2:
	                    System.out.println("Enter the name of address book into which you want to perform the operations");
	                    String bookName = scanner.nextLine();
	                    AddressBook addressBookToAdd =  addressBookMap.get(bookName); // to Find in which address book the operation should be performed.
	                    addressBookToAdd.operation();                                 // bookname = key

	                    break;
	                case 3:
	                    for(Entry<String, AddressBook> set : addressBookMap.entrySet()){  // it will iterate through each entry of addressbookmap
	                        System.out.println(set.getKey() + "=" + set.getValue());         // (it will print addressbook name = addressbook value)
	                    }
	                    break;

	                case 4:
	                    TextFileOps textfile = new TextFileOps();
	                    try{
	                        textfile.writeDataToDestination(addressBookMap);
	                    } catch (IOException e){
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 5:
	                    textfile = new TextFileOps();
	                    try{
	                        textfile.readDataFromSource();
	                    } catch (IOException e){
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 6:
	                    System.out.println("Exiting");   // it will exit from thw whole program.
	                    break;
	                default:
	                    System.out.println("Enter The Wrong Opration Number");
	            }
	        } while (opration != 6);

	        System.out.println();
	        

	    }
}
