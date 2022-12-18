package day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 */
public class Day4Second {

    public void run() throws IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream("input/inputD4.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int assignmentPairs = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {

            int[] ints = Arrays.stream(strLine.split("[,\\-]")).mapToInt(Integer::parseInt).toArray();

            if(ints[0] >= ints[2] && ints[0]<=ints[3]){
                    assignmentPairs++;
            } else if(ints[0] <= ints[2] && ints[1]>=ints[2]){
                    assignmentPairs++;
            }
        }

        System.out.println("Number of assignmentPairs: " + assignmentPairs);
    }
}

//24495
