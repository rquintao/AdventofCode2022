package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Day3Second {

    public void run() throws IOException {

        int points = 0;

        // Open the file
        FileInputStream fstream = new FileInputStream("input/inputD3.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        int i = 1;
        List<List<Character>> list = new ArrayList<>();

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            if (i > 3){
                i = 1;
                list.clear();
            }

            list.add(strLine.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));

            if(i==3) {

                final List<Character> fisrtSearch = list.get(0).stream().filter(list.get(1)::contains).collect(Collectors.toList());
                Character badgeType = list.get(2).stream().filter(fisrtSearch::contains).findFirst().orElse(null);

                if (badgeType != null){
                    if ((int) badgeType >= 97){
                        points += (int) badgeType - 96;
                    } else {
                        points += (int) badgeType - 38;
                    }
                }
            }

            i++;
        }

        System.out.println("The points are: " + points);
    }
}
