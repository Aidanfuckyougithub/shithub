import java.util.*;
import java.io.*;

public class MyProgram
{
    public static void main(String[] args) throws Exception
    {
        int size = 40;
        int[][] arr = new int[size][size];
        int[][] tempArr = cloneArray(arr);
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        Scanner kb = new Scanner(System.in);
        int colCount = 0;
        int rowCount = 0;
        int cellCount = 0;
        boolean gameLoop = true;
        boolean firstLoop = true;
        int iterations = 0;
        
        while(sc.hasNextInt()){
            arr[rowCount][colCount] = sc.nextInt();
            //System.out.print((arr[rowCount][colCount] == 1 ? "🟥" : "🟩") + " ");
            if(colCount >= (size - 1)){
                colCount = -1;
                rowCount++;
                //System.out.println("press start");
            }
            colCount++;
        }
        
        //String ask = kb.next();
        
        while(gameLoop = true){
            System.out.println();
            for(int r = 0; r < size; r++){
                for(int c = 0; c < size; c++){
                    //System.out.print(tempArr[r][c] + " ");
                }
                //System.out.println();
            }
            Thread.sleep(100);
            System.out.print("\033[H\033[2J");  
            
            if(firstLoop == false){
                arr = cloneArray(tempArr);
            }
            
            for(int row = 0; row < size; row++){
                for(int col = 0; col < size; col++){
                    
                    cellCount = 0;
                    
                    if(row != 0){
                        //broken
                        // System.out.print(arr[row-1][col] + "d");
                        if(arr[row - 1][col] == 1){
                            cellCount++;
                            // System.out.print("Dong");
                        }
                    }
                    
                    if(row != 0 && col != 0){
                        if(arr[row - 1][col - 1] == 1){
                            cellCount++;
                            //System.out.print("e");
                        }
                    }
                    
                    if(col != 0){
                        if(arr[row][col - 1] == 1){
                            cellCount++;
                            //System.out.print("ding");
                        }
                    }
                    
                    if(row != size - 1){
                        if(arr[row + 1][col] == 1){
                            cellCount++;
                            // //System.out.print("ding");
                        }
                    }
                    
                    if(row != size - 1 && col != size - 1){
                        if(arr[row + 1][col + 1] == 1){
                            cellCount++;
                            // //System.out.print("ding");
                        }
                    }
                    
                    if(col != size - 1){
                        if(arr[row][col + 1] == 1){
                            cellCount++;
                            //System.out.print("ding");
                        }
                    }
                    
                    if(row != 0 && col != size - 1){
                        if(arr[row - 1][col + 1] == 1){
                            cellCount++;
                            //System.out.print("d");
                        }
                    }
                    
                    if(row != size - 1 && col != 0){
                        if(arr[row + 1][col - 1] == 1){
                            cellCount++;
                            // //System.out.print("ding");
                        }
                    }
                    //System.out.print(cellCount + "c");
                    System.out.print((arr[row][col] == 1 ? "🟥" : "🟩") + " ");
                    
                    tempArr[row][col] = arr[row][col];
                    
                    //System.out.print("C ");
                    //rule 1
                    if(cellCount < 2){
                        tempArr[row][col] = 0;
                    }
                    
                    //rule 2 useless
                    
                    //rule 3
                    if(cellCount > 3){
                        tempArr[row][col] = 0;
                    }
                    //rule 4
                    if(cellCount == 3){
                        tempArr[row][col] = 1;
                    }
                    
                    
                }
                System.out.println();
            }
            iterations++;
            System.out.println("Iterations: " + iterations);
            firstLoop = false;
        }
    }
    
    public static int[][] cloneArray(int[][] toClone) {
        int[][] output = new int[toClone.length][toClone[0].length];
        for (int i=0; i<toClone.length; i++) {
            for (int j=0; j<toClone[i].length; j++) {
                output[i][j] = toClone[i][j];
            }
        }
        return output;
    }
}