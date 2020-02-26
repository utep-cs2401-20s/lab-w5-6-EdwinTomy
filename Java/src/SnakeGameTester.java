//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class SnakeGameTester{

    @Test
    public void exhaustive1(){
        System.out.println("Exhaustive: Test Case #1");
        boolean[][] arr = {
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
        };
        SnakeGame sol = new SnakeGame(arr, 2, 2);
        int[] correctAnswer = {2, 2, 1};
        assertArrayEquals(correctAnswer, sol.findTailExhaustive());
    }

    @Test
    public void exhaustive2(){
        System.out.println("Exhaustive: Test Case #2");
        boolean[][] arr = {
                {true, false, false, false, false, false},
                {true, false, false, false, false, false},
                {true, false, false, false, false, false},
                {true, false, false, false, false, false},
                {true, false, false, false, false, false},
                {true, false, false, false, false, false},
        };
        SnakeGame sol = new SnakeGame(arr, 0, 0);
        int[] correctAnswer = {5, 0, 6};
        assertArrayEquals(correctAnswer, sol.findTailExhaustive());
    }

    @Test
    public void exhaustive3(){
        System.out.println("Exhaustive: Test Case #1");
        boolean[][] arr = {
                {false, false, false, false, false, false},
                {false, true, false, true, false, false},
                {false, true, false, true, false, false},
                {false, true, true, true, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
        };
        SnakeGame sol = new SnakeGame(arr, 1, 1);
        int[] correctAnswer = {1, 3, 7};
        assertArrayEquals(correctAnswer, sol.findTailExhaustive());
    }

}