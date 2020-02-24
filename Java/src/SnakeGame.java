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

    public int[] findTailRecursive(int[]){
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

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
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

