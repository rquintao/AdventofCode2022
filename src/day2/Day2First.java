package day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Day2First {

    public void run() throws IOException {

        /*
        * Winning combs
        * A Y 2 + 6
        * B Z 3 + 6
        * C X 1 + 6
        * */

        // Open the file
        FileInputStream fstream = new FileInputStream("input/inputD2.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        List<String> theirOptionsList  = Arrays.asList("A", "B", "C");
        List<String> myOptionsList = Arrays.asList("X", "Y", "Z");

        Map<String, String> winningCombs = new HashMap<>();
        winningCombs.put("A", "Y");
        winningCombs.put("B", "Z");
        winningCombs.put("C", "X");


        int points = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {


            final String[] round = strLine.split(" ");

            if(theirOptionsList.indexOf(round[0])==myOptionsList.indexOf(round[1])){
                points = points + theirOptionsList.indexOf(round[0]) + 4;
            } else if (winningCombs.get(round[0]).equals(round[1])){
                points = points + myOptionsList.indexOf(round[1]) + 7;
            } else{
                points += myOptionsList.indexOf(round[1]) + 1;
            }

        }

        System.out.println("The points are: " + points);
    }
}


/*17189*/