package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Day1Second {

    public void run() throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("input/inputD1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        Integer[] maxArray = new Integer[]{0, 0, 0};
        int currentCaloriesSum = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {

            if(!strLine.equals("")){
                currentCaloriesSum = currentCaloriesSum + Integer.parseInt(strLine);
            } else {
                for(int i=0; i<3; i++){
                    if(currentCaloriesSum > maxArray[i]){
                        shiftValues(maxArray, currentCaloriesSum, i);
                    }
                }

                currentCaloriesSum = 0;
            }
        }
        System.out.println(maxArray[0] + " | " + maxArray[1] + " | " + maxArray[2]);
        System.out.println("O máximo de calorias é -> " + Math.addExact(Math.addExact(maxArray[0], maxArray[1]), maxArray[2]));

        //Close the input stream
        fstream.close();

    }

    private static void shiftValues(Integer[] maxArray, int currentCaloriesSum, int index) {
        int localMax = maxArray[index];
        maxArray[index] = currentCaloriesSum;
        if(index == 0){
            return;
        }
        shiftValues(maxArray, localMax, index-1);
    }
}
