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
import java.util.Objects;

/**
 *
 */
public class Day2Second {

    public void run() throws IOException {

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

            if(round[1].equals("Y")){
                points = points + theirOptionsList.indexOf(round[0]) + 4;
            } else if (round[1].equals("Z")){
                points = points + myOptionsList.indexOf(winningCombs.get(round[0])) + 7;
            } else{
                List<String> temp = Arrays.asList("A", "B", "C");
                final String s = winningCombs.get(round[0]);
                final String s1 = temp.stream().filter(t -> !Objects.equals(t, round[0])
                                                            && !Objects.equals(t, theirOptionsList.get(myOptionsList.indexOf(s))))
                        .findFirst().orElse(null);
                points += theirOptionsList.indexOf(s1) + 1;
            }

        }
        System.out.println("The points are: " + points);
    }
}


/*9835*/
