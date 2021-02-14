import java.util.Set;

public class SpaceCalculator {
    public static void SpaceCalculator(HuffmanCoderReadWrite textfile1){

        //First we calculate how many Space of the Original file take//

        //First we separate the FrequencyMap for easier coding
        Set key = textfile1.FrequencyMap.keySet();
        Character[] charkeys = (Character[])key.toArray(new Character[key.size()]);
        Integer[] values = textfile1.FrequencyMap.values().toArray(new Integer[key.size()]);
        int n = textfile1.FrequencyMap.size();
        int sum = 0;
        //we use for loop go over each char with its frequency, add all the frequency together
        for (int i = 0; i <n; i++) {
            sum = sum + values[i];
        }
        //since char takes 8 bits, we times 8
        sum = sum * 8;


        //Then we calculate how many space the translated Huffman Codes take
        int sum2 = 0;
        int thischarTotalbits = 0;
        int j = textfile1.CodeList.size();

        //we use a for loop to see each Huffman node's length
        //then we times the length with each frequency
        // since each Huffman nodes take only 1 bits, we just add them together.
        for (int i = 0; i <j; i++){
            char char1 = textfile1.Charlist.get(i);
            int length = textfile1.CodeList.get(i).length();
            int frequency = textfile1.FrequencyMap.get(char1);
            thischarTotalbits = length * frequency;
            sum2 += thischarTotalbits;
        }

        //now we calculate the space of the huffman chart.//
        //The tree have to print 3 things:
        // 1. Char 2. its frequency 3. its HuffmanNode

        int sum3 = 0;
        //the space each char takes //
        //each char take 8 space so it is
        //Also, each char have two | to separate  the string, we need to count them as well.
        int space1 = textfile1.Charlist.size() + 2;
        space1 *= 8;

        int space2 = 0;
        //Its frequency is integer.
        for (int i = 0; i <j; i++){
            int int1 = values[i];
            String string1 = Integer.toString(int1);
            //The frequency is a integer
            space2 =  string1.length();
            //each number takes 4 bits
            space2 *= 4;
        }

        //Its huffman codes takes 1 bits.
        //So the space would be its length

        int space3 = 0;
        for (int i = 0; i <j; i++){
            int length = textfile1.CodeList.get(i).length();
            space3 += length;
        }

        int spaceForHuffmanChart = space1 + space2 + space3;



        //Finally we calculate how many space we save by
        //Subtract the original space by space of huffman chart and translated huffman codes

        int Savedspace = sum - sum2 - sum3;

        System.out.println("The Huffman chart and translated Hufffman codes are generated into a file called: "
                + textfile1.getOutputFilepath());
        System.out.println("    || the file would be in the project file");

        System.out.println("The total space we saved from translate textfile is: "
                +  Savedspace + " bits");

        System.out.println("___________________");
        System.out.println();
    }
}
