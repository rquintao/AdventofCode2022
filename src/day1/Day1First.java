package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Day1First {

    public void run() throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("input/inputD1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        int maxCalories = 0;
        int currentCaloriesSum = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {

            if(!strLine.equals("")){
                currentCaloriesSum = currentCaloriesSum + Integer.parseInt(strLine);
            } else {
                if(currentCaloriesSum > maxCalories){
                    maxCalories=currentCaloriesSum;
                }

                currentCaloriesSum = 0;
            }
        }

        System.out.println("O máximo de calorias é -> " + maxCalories);

        //Close the input stream
        fstream.close();
    }
}
