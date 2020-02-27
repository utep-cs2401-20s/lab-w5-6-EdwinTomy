//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class SnakeGameTester{

//Exhaustive Test Cases.

//Test Case 1: Snake length is equal to one. PASSED
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

//Test Case 2: Snake on the edge of the game. PASSED
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

//Test Case 3: Snake turning around. PASSED
    @Test
    public void exhaustive3(){
        System.out.println("Exhaustive: Test Case #3");
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

//Test Case 4: Snake length transversing "diagonally" from corner to corner. PASSED
    @Test
    public void exhaustive4(){
        System.out.println("Exhaustive: Test Case #4");
        boolean[][] arr = {
                {false, false, false, false, true, true},
                {false, false, false, false, true, false},
                {false, false, false, true, true, false},
                {false, false, true, true, false, false},
                {false, true, true, false, false, false},
                {true, true, false, false, false, false},
        };
        SnakeGame sol = new SnakeGame(arr, 5, 0);
        int[] correctAnswer = {0, 5, 11};
        assertArrayEquals(correctAnswer, sol.findTailExhaustive());
    }

//Test Case 5: Snake occupies entire game. PASSED
    @Test
    public void exhaustive5(){
        System.out.println("Exhaustive: Test Case #5");
        boolean[][] arr = {
                {true},
                {true},
                {true},
                {true},
                {true},
                {true},
        };
        SnakeGame sol = new SnakeGame(arr, 0, 0);
        int[] correctAnswer = {5, 0, 6};
        assertArrayEquals(correctAnswer, sol.findTailExhaustive());
    }

//Recursive Test Cases.
//Test Case 1: Snake length is equal to one. PASSED
    @Test
    public void recursive1(){
        System.out.println("Recursive: Test Case #1");
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
        assertArrayEquals(correctAnswer, sol.findTailRecursive());
    }

//Test Case 2: Snake on the edge of the game. PASSED
    @Test
    public void recursive2(){
        System.out.println("Recursive: Test Case #2");
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
        assertArrayEquals(correctAnswer, sol.findTailRecursive());
    }

//Test Case 3: Snake turning around. PASSED
    @Test
    public void recursive3(){
        System.out.println("Recursive: Test Case #3");
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
        assertArrayEquals(correctAnswer, sol.findTailRecursive());
    }

//Test Case 4: Snake length transversing "diagonally" from corner to corner. PASSED
    @Test
    public void recursive4(){
        System.out.println("Recursive: Test Case #4");
        boolean[][] arr = {
                {false, false, false, false, true, true},
                {false, false, false, false, true, false},
                {false, false, false, true, true, false},
                {false, false, true, true, false, false},
                {false, true, true, false, false, false},
                {true, true, false, false, false, false},
        };
        SnakeGame sol = new SnakeGame(arr, 5, 0);
        int[] correctAnswer = {0, 5, 11};
        assertArrayEquals(correctAnswer, sol.findTailRecursive());
    }

//Test Case 5: Snake occupies entire game. PASSED
    @Test
    public void recursive5(){
        System.out.println("Recursive: Test Case #5");
        boolean[][] arr = {
                {true},
                {true},
                {true},
                {true},
                {true},
                {true},
        };
        SnakeGame sol = new SnakeGame(arr, 0, 0);
        int[] correctAnswer = {5, 0, 6};
        assertArrayEquals(correctAnswer, sol.findTailRecursive());
    }
}