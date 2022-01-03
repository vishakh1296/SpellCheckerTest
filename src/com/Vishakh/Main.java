//SpellChecker Program

package com.Vishakh;

import java.io.*;
import java.util.*;

public class Main {


    //readInputFile Method: to read the input.txt file
    public static String readInputFile(String file, List<String> inputList) throws FileNotFoundException {

                //read Input.txt file
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while((line = reader.readLine()) != null){
                        System.out.println("Input File: "+ line);
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


               //Storing text file String to String Array.
               Scanner scanInput = new Scanner(new File(file));
               while (scanInput.hasNextLine())
               inputList.add(scanInput.next());
               String[] stringArray = new String[inputList.size()];


               //transferring the arraylist contents to string array && removing delimiters as well as converting to lowercase
               for (int i = 0; i < inputList.size(); i++){
               stringArray[i] = inputList.get(i).replaceAll("\\W+","").toLowerCase(Locale.ROOT);
               //Updating the current Array List by using set() method
               inputList.set(i, stringArray[i]);

           }

           return "";
    }


    //readDictionaryFile Method: to read the dictionary.txt file
    public static String readDictionaryFile(String file, List<String> DictionaryList) throws FileNotFoundException {


            //read Dictionary.txt file
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                System.out.println("Dictionary File: ");
                String line;
                while((line = reader.readLine()) != null){
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //Storing the text file string to ArrayList
               Scanner scanDictionary = new Scanner(new File(file));
               while(scanDictionary.hasNextLine())
               DictionaryList.add(scanDictionary.next());
               return "";
    }


    //Main Method
    public static void main(String[] args) throws FileNotFoundException{

        //creating an arrayList to store the content from the input.txt file
        List<String>  listInputFile = new ArrayList<String>();

        //creating an arrayList to store the content from the dictionary.txt file
        List<String>  listDictionaryFile = new ArrayList<String>();

        //calling the method: readInputFile()
        readInputFile("C:\\Users\\Vishakh\\IdeaProjects\\SpellChecker\\src\\input.txt", listInputFile);

        //calling the method: readDictionaryFile()
        readDictionaryFile("C:\\Users\\Vishakh\\IdeaProjects\\SpellChecker\\src\\Dictionary.txt", listDictionaryFile);

        //Printing the array
        //System.out.println("Input File Array: " + listInputFile);
        //System.out.println("Dictionary File Array: " + listDictionaryFile);


        //To Print the list of words that are not in the dictionary
        listInputFile.removeAll(listDictionaryFile);
        System.out.println("List of unmatched words: " + listInputFile);


    }

}



