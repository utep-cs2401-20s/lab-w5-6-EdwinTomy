public class SnakeGame{
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

//Constructors
    SnakeGame(){
        game = new boolean[1][1];
        headPosition = new int[] {0, 0};
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    SnakeGame(boolean[][] game, int x, int y){
        this.game = new boolean[game.length][game[0].length];
        this.headPosition = new int[] {x, y};
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                this.game[i][j] = game[i][j];
            }
        }
        headPosition = new int[] {x, y};
    }

//Methods

//Exhaustive Method
    public int[] findTailExhaustive(){
        resetCounters();
        int[] tail = new int[3];
        int counter = 0;

        //Nested for loop iterating through every element.
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j <game[i].length; j++){
                exhaustiveChecks++;

                //Counting all true elements.
                if(game[i][j]){
                    counter++;

                    //If it has less than 2 neighbors and isn't the head position, it's the tail.
                    if((neighbors(i,j) <= 1) && ((i != headPosition[0]) || (j != headPosition[1]))){
                        tail[0] = i;
                        tail[1] = j;
                    }
                }
            }
        }tail[2] = counter;

        //When the snake is of length 1 and tail and head are the same.
        if(counter == 1){
            tail[0] = headPosition[0];
            tail[1] = headPosition[1];
        }
        return tail;
    }

    //Exhaustive helper method, counts the neighbor elements that are true.
    public int neighbors(int row, int column){
        int sum = 0;

        if(row != 0){
            if(game[row - 1][column])
                sum++;
        }
        if(column != 0){
            if (game[row][column - 1])
                sum++;
        }
        if(column != game[0].length - 1){
            if(game[row][column + 1])
                sum++;
        }
        if(row != game.length - 1){
            if(game[row + 1][column])
                sum++;
        }
        return sum;
    }

//Recursive Methods
    public int[] findTailRecursive(){
        resetCounters();
        int[] tail = new int[3];

        //Updating tail as we're making the recursive calls.
        //Checking in all cases if array index is out of bounds.
        if(headPosition[0] != 0){
            if (game[headPosition[0] - 1][headPosition[1]]) {
                tail[0] = headPosition[0] - 1;
                tail[1] = headPosition[1];
                tail[2] += 2;
                recursiveChecks++;
                return findTailRecursive(tail, headPosition);
            }
        }
        if(headPosition[1] != 0) {
            if (game[headPosition[0]][headPosition[1] - 1]) {
                tail[0] = headPosition[0];
                tail[1] = headPosition[1] - 1;
                tail[2] += 2;
                recursiveChecks++;
                return findTailRecursive(tail, headPosition);
            }
        }
        if(headPosition[0] != game.length - 1){
            if (game[headPosition[0] + 1][headPosition[1]]) {
                tail[0] = headPosition[0] + 1;
                tail[1] = headPosition[1];
                tail[2] += 2;
                recursiveChecks++;
                return findTailRecursive(tail, headPosition);
            }
        }
        if(headPosition[1] != game[0].length - 1){
            if (game[headPosition[0]][headPosition[1] + 1]) {
                tail[0] = headPosition[0];
                tail[1] = headPosition[1] + 1;
                tail[2] += 2;
                recursiveChecks++;
                return findTailRecursive(tail, headPosition);
            }
        }
        //Returning tail with the final positions and length.
        tail[0] = headPosition[0];
        tail[1] = headPosition[1];
        tail[2] = 1;
        return tail;

    }

    //Recursive helper method.
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {

        //Verifying if array index isn't out of bounds.
        //Then searching which direction is the snake following.
        //Finally updating currentPosition and previousPosition and calling findTailRecursive.
        if (currentPosition[0] > 0) {
            if (game[currentPosition[0] - 1][currentPosition[1]]) {
                if (((currentPosition[0] - 1) != previousPosition[0]) || (currentPosition[1] != previousPosition[1])) {
                    for (int i = 0; i < 2; i++) {
                        previousPosition[i] = currentPosition[i];
                    }
                    currentPosition[0] = currentPosition[0] - 1;
                    currentPosition[2]++;
                    recursiveChecks++;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if (currentPosition[1] > 0) {
            if (game[currentPosition[0]][currentPosition[1] - 1]) {
                if ((currentPosition[0] != previousPosition[0]) || ((currentPosition[1] - 1) != previousPosition[1])) {
                    for (int i = 0; i < 2; i++) {
                        previousPosition[i] = currentPosition[i];
                    }
                    currentPosition[1] = currentPosition[1] - 1;
                    currentPosition[2]++;
                    recursiveChecks++;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if (currentPosition[0] < game.length - 1) {
            if (game[currentPosition[0] + 1][currentPosition[1]]) {
                if (((currentPosition[0] + 1) != previousPosition[0]) || (currentPosition[1] != previousPosition[1])) {
                    for (int i = 0; i < 2; i++) {
                        previousPosition[i] = currentPosition[i];
                    }
                    currentPosition[0] = currentPosition[0] + 1;
                    currentPosition[2]++;
                    recursiveChecks++;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        if (currentPosition[1] < game[0].length - 1) {
            if (game[currentPosition[0]][currentPosition[1] + 1]) {
                if ((currentPosition[0] != previousPosition[0]) || ((currentPosition[1] + 1) != previousPosition[1])) {
                    for (int i = 0; i < 2; i++) {
                        previousPosition[i] = currentPosition[i];
                    }
                    currentPosition[1] = currentPosition[1] + 1;
                    currentPosition[2]++;
                    recursiveChecks++;
                    return findTailRecursive(currentPosition, previousPosition);
                }
            }
        }
        //When reaching the end of the tail (base case).
        return currentPosition;
    }

//Additional methods
    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

    private static int getRecursiveChecks(){
        return recursiveChecks;
    }
}

