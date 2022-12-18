package day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Day4First {

    public void run() throws IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream("input/inputD4Simple.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int pairs = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {

            int[] ints = Arrays.stream(strLine.split("[,\\-]")).mapToInt(Integer::parseInt).toArray();

            if(ints[0] > ints[2]){
                if(ints[1] <= ints[3]){
                    pairs++;
                }
            } else if(ints[0] < ints[2]){
                if(ints[1] >=  ints[3]){
                    pairs++;
                }
            } else {
                pairs++;
            }
        }

        System.out.println("Number of pairs: " + pairs);
    }
}
