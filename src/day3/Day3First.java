package day3;

import com.sun.deploy.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class Day3First {

    public void run() throws IOException {

        int points = 0;

        // Open the file
        FileInputStream fstream = new FileInputStream("input/inputD3.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            final List<Character> list = strLine.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            List<Character> firstSack = list.subList(0, list.size() / 2);
            List<Character> secondSack = list.subList(list.size() / 2, list.size());

            final Character error = firstSack.stream().filter(secondSack::contains).findFirst().orElse(null);

            if (error != null){
                if ((int) error >= 97){
                     points += (int) error - 96;
                } else {
                    points += (int) error - 38;
                }
            }

             System.out.println("Points: " + points);

        }

        System.out.println("The points are: " + points);
    }
}
