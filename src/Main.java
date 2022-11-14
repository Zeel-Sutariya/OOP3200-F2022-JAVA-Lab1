/*
Group 3:
    - Zeel Sutariya (100846187)
    - Niraj Mistry (100855211)
Date - Nov 13, 2022

 */
import java.util.Scanner;

public class Main
{
    // Defining No. of Players -
    public static int NUM_OF_PLAYERS = 3;

    // Defining No. of Games
    public static int NUM_OF_GAMES = 2;

    /**
     * To read the input to 2D array accordingly
     * @param object
     * @return
     * @param <T>
     */
    public static <T> T getConsoleInputTo2DArray(T[][] object)
    {
        Scanner console = new Scanner(System.in);
        // reading input accordingly
        switch (object.getClass().getSimpleName())
        {
            case "Double[][]":
                return (T) ((Double) console.nextDouble());
            case "Integer[][]":
                return (T) ((Integer) console.nextInt());
            case "Float[][]":
                return (T) ((Float) console.nextFloat());
            default:
                return (T) console.nextLine();
        }
    }

    public static void main(String[] args)
    {
        // Storing Names in names(String Array)
        String[] names = new String[NUM_OF_PLAYERS];
        // Storing scores in a 2D Int Array
        Integer[][] scores = new Integer[NUM_OF_PLAYERS][NUM_OF_GAMES];
        double totalScores = 0.0;
        double avgScores = 0.0;
        // Assigning names as required
        names[0] = "Tom";
        names[1] = "Zeel";
        names[2] = "Niraj";

        // Taking input(scores) from user
        for(int i=0; i<NUM_OF_PLAYERS; i++)
        {
            for(int j=0; j<NUM_OF_GAMES; j++)
            {
                // Validation - Using try to show error message if the input isn't numeric or a whole number
                try {
                    System.out.printf("Please Enter %s's score for GAME #%d: ", names[i], j + 1);
                    // getting input and storing in scores(2D array)
                    scores[i][j] = getConsoleInputTo2DArray(scores);
                    // Validation - Show error message if the scores is out side the range [0-300]
                    if(!(scores[i][j] >=0 && scores[i][j] <=300))
                    {
                        // Error message - Out of range
                        System.out.println("Invalid input. Value between 0 and 300 needed. Please try again.");
                        j--;
                    }
                }
                catch (Exception e)
                {
                    // Error Message - Numeric Input needed
                    System.out.println("Invalid Input! Numeric value needed. Please try again.");
                    j--;
                }
            }
            System.out.println();
        }

        // Displaying Scores using nested loops as required
        for(int i=0; i<NUM_OF_PLAYERS; i++)
        {
            System.out.printf("Display Scores for %s:", names[i]);
            for(int j=0; j<NUM_OF_GAMES; j++)
            {
                totalScores += scores[i][j];
                System.out.printf("\nGame # %d: %5d", j+1, scores[i][j]);
            }
            avgScores = totalScores/NUM_OF_GAMES;
            System.out.printf("\nAverage for %s: %.1f\n\n", names[i], avgScores);
            avgScores = 0.0;
            totalScores = 0.0;
        }
    }
}