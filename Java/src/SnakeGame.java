public class SnakeGame{
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

//Constructors
    SnakeGame(){
        game = new boolean[1][1];
    }
    SnakeGame(boolean[][] game, int x, int y){
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j <game.length; j++){
                this.game[i][j] = game[i][j];
            }
        }
        headPosition = new int[] {x, y};
    }

//Methods
    public int[] findTailExhaustive(){
        resetCounters();
        int[] tail = new int[3];
        int counter = 0;

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j <game.length; j++){
                exhaustiveChecks++;
                if(game[i][j]){
                    counter++;

                    if((neighbors(i,j) == 1) && (i != headPosition[0]) && (j != headPosition[1])){
                        tail[0] = i;
                        tail[1] = j;
                    }
                }
            }
        }tail[2] = counter;
        return tail;
    }

    public int[] findTailRecursive(){
        resetCounters();
        int[] tail = new int[3];

        if(game[headPosition[0] - 1][headPosition[1]]){
            tail[0] = headPosition[0] - 1;
            tail[1] = headPosition[1];
            tail[2]++;
            recursiveChecks++;
            tail =  findTailRecursive(tail, headPosition);
        }
        if(game[headPosition[0]][headPosition[1] - 1]){
            tail[0] = headPosition[0];
            tail[1] = headPosition[1] - 1;
            tail[2]++;
            recursiveChecks++;
            tail =  findTailRecursive(tail, headPosition);
        }
        if(game[headPosition[0] + 1][headPosition[1]]){
            tail[0] = headPosition[0] + 1;
            tail[1] = headPosition[1];
            tail[2]++;
            recursiveChecks++;
            tail = findTailRecursive(tail, headPosition);
        }
        if(game[headPosition[0]][headPosition[1] + 1]){
            tail[0] = headPosition[0];
            tail[1] = headPosition[1] + 1;
            tail[2]++;
            recursiveChecks++;
            tail = findTailRecursive(tail, headPosition);
        }
        return tail;
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        if(game[currentPosition[0] - 1][currentPosition[1]]){
            if(((currentPosition[0] - 1) != previousPosition[0]) || (currentPosition[1] != previousPosition[1])){
                for(int i = 0; i < 3; i++){
                    previousPosition[i] = currentPosition[i];
                }
                currentPosition[0] = currentPosition[0] - 1;
                currentPosition[2]++;
                recursiveChecks++;
                return findTailRecursive(currentPosition, previousPosition);
            }
        }
        if(game[currentPosition[0]][currentPosition[1] - 1]){
            if((currentPosition[0] != previousPosition[0]) || ((currentPosition[1] - 1) != previousPosition[1])){
                for(int i = 0; i < 3; i++){
                    previousPosition[i] = currentPosition[i];
                }
                currentPosition[1] = currentPosition[1] - 1;
                currentPosition[2]++;
                recursiveChecks++;
                return findTailRecursive(currentPosition, previousPosition);
            }
        }
        if(game[currentPosition[0] + 1][currentPosition[1]]){
            if(((currentPosition[0] + 1) != previousPosition[0]) || (currentPosition[1] != previousPosition[1])){
                for(int i = 0; i < 3; i++){
                    previousPosition[i] = currentPosition[i];
                }
                currentPosition[0] = currentPosition[0] + 1;
                currentPosition[2]++;
                recursiveChecks++;
                return findTailRecursive(currentPosition, previousPosition);
            }
        }
        if(game[currentPosition[0]][currentPosition[1] + 1]){
            if((currentPosition[0] != previousPosition[0]) || ((currentPosition[1] + 1) != previousPosition[1])){
                for(int i = 0; i < 3; i++){
                    previousPosition[i] = currentPosition[i];
                }
                currentPosition[1] = currentPosition[1] + 1;
                currentPosition[2]++;
                recursiveChecks++;
                return findTailRecursive(currentPosition, previousPosition);
            }
        }return currentPosition;
    }

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
        if(column != game.length - 1){
            if(game[row][column + 1])
                sum++;
        }
        if(row != game.length - 1){
            if(game[row + 1][column])
                sum++;
        }
        return sum;
    }
}

