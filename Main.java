import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

//This assignment has 4 class
        //1: HuffmanCoderReadWrite
         //This class contains method of read and write text file//
        //2: HuffmanNode
        //This method contains transformation of huffman code and write of the huffman codes.//
        //3.Priority
        //Priority queue is used in HuffmanNode to generate huffman tree//
        //4. Class to calculate how many space we saved.
        //The method would print the total space saved

        //Thoughts of implementation:
        //ArrayList have higher speed in getMethod, but Linkedlist have higher speed in addMethod, I would prefer LinkedList
        // because  it have higher speed in add, we need go through all the text to generate the frequency table. (Even though we
        // still need to get all the data to generate the Huffman coding.


        //This method need input the filepath of the input file, and the filepath of the outputfile
        // (Note: just enter the file name and address of the output file The program will
        // generate the output file automatically)

        HuffmanCoderReadWrite textfile1 = new HuffmanCoderReadWrite(
                "/Users/kenyansong/Desktop/data structure/program2/text1.txt",
                "/Users/kenyansong/Desktop/data structure/program2/text1output.txt");
        SpaceCalculator.SpaceCalculator(textfile1);


        HuffmanCoderReadWrite textfile2 = new HuffmanCoderReadWrite(
                "/Users/kenyansong/Desktop/data structure/program2/text2.txt",
                "/Users/kenyansong/Desktop/data structure/program2/text2output.txt");
        SpaceCalculator.SpaceCalculator(textfile2);









































    }
}
