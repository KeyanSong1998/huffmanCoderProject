import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class HuffmanCoderReadWrite {
    public String inputFilepath;
    private String outputFilepath;
    //Frequency table 1 is used for generate Huffman tree
    public HashMap<Character,Integer> FrequencyMap;
    private String textLine;
    //2 Linked list is used for translate text file into 0 and 1//
    public LinkedList<Character> Charlist;
    public LinkedList<String> CodeList;


   //Constructor for Huffmancode, need input file's path, and output file path(where to create and name
   // of the out put file)
    public HuffmanCoderReadWrite(String inputFilepath, String outputFilepath) throws IOException {
        this.inputFilepath = inputFilepath;
        this.outputFilepath = outputFilepath;
        //generate hashmap for frequency table//
        FrequencyMap = new HashMap<Character,Integer>();
        //write a method to generate frequency table and put in Frequency map
        Huffman_Frequency_table_generate(FrequencyMap);
        //create A new file as output//
        File outputFile = new File(outputFilepath);
        Charlist = new LinkedList<Character>();
        CodeList = new LinkedList<String>();
        HuffmanNode.HuffmanTreeGenerate(this.FrequencyMap,Charlist,CodeList,this.inputFilepath,this.getOutputFilepath());

    }

    public String getOutputFilepath() {
        return outputFilepath;
    }


    //the method to scan the input text file to generate the Hashmap which contains
    // chars and freuqency to generate list of HuffmanNodes later.
    public void Huffman_Frequency_table_generate(HashMap<Character,Integer> FrequencyMap) throws FileNotFoundException {
        //Scan the text file//
        File file = new File(inputFilepath);
        Scanner scan = new Scanner(file);
        //Traverse the text file until lastline//
        while (scan.hasNextLine()){
            //record this line as textLine//
            textLine = scan.nextLine();
            //make it as frequency table//
            char[] CharArray = textLine.toCharArray();
            for (int i = 0; i < CharArray.length; i ++){
                //put the Char into Hashmap//
                //if it do not exist, add it and make frequency as 1 //
                char c = CharArray[i];
                if (!FrequencyMap.containsKey(c)){
                    FrequencyMap.put(c,1);
                }
                //if it exist, add 1 frequency //
                else {
                    FrequencyMap.put(c,FrequencyMap.get(c)+1);
                }
            }
        }
    }


    //A method to scan the input text file (again!), produce the encoded output file, and compute the savings.//
    public static void Huffman_writeIntoFile(FileWriter fw,String inputFilepath, LinkedList<Character> Charlist,
                                             LinkedList<String> CodeList) throws IOException {
        //Scan the whole text file until last line
        File file = new File(inputFilepath);
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            //record this line as textLine//
            String textLine = scan.nextLine();
            //Translate the line use the (Huffman)CodeList we generated//
            //first we get a Chararray of all chars//
            char[] CharArray = textLine.toCharArray();
            //We use a for loop to translate each char into huffman Code then record the code into the output file//
            for (int i = 0; i < CharArray.length; i ++) {
                char c = CharArray[i];
                int index = Charlist.indexOf(c);
                String code = CodeList.get(index);
                fw.write(code);
                }
            }
        }


    @Override
    public String toString() {
        return "HuffmanCoderReadWrite{" +
                "FrequencyMap=" + FrequencyMap +
                '}';
    }


    //A method to sort the HashMap by value//
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }









    public static String huffmanCoder(String inputFilepath, String outputFilepath) throws IOException {
        //create A new file as output//
        File outputFile = new File(outputFilepath);
        //generate the Huffman Node//
        //write the content into the output path.//
        return outputFilepath;
    }
}
