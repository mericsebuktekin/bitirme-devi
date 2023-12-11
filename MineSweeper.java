import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    char gameZone[][];
    String numField[][];
    Scanner input = new Scanner(System.in);
    Random rnd = new Random();

    public void run(){

        System.out.print("Lufen Satir Giriniz: ");
        int row = input.nextInt();
        System.out.print("Lufen Sutun Giriniz: ");
        int colum = input.nextInt();


        createGameZone(row,colum);
        addMines(row,colum);
        showField(row,colum);


        int size = row*colum;
        int loopRepeat=size-size/4;
        System.out.println("==Oyun Basladi==");

        while (loopRepeat>0){

            for (int i=0;i<row;i++){
                for (int j=0;j<colum;j++){
                    System.out.print(numField[i][j]+" ");
                }
                System.out.println();
            }

            int sum=0;
            System.out.print("Satir Giriniz: ");
            int row1=input.nextInt()-1;
            System.out.print("Sutun Giriniz: ");
            int colum1=input.nextInt()-1;
            if (row>=row1 && colum>=colum1 && row1>=0 && colum1>=0){
                if (gameZone[row1][colum1]=='*'){
                    System.out.println("Game Over!");
                    break;
                }else {

                    if(row1 -1 >=0 && colum1 - 1 >=0){
                        if (gameZone[row1-1][colum1-1]=='*')
                            sum++;
                    }
                    if (row1-1>=0){
                        if (gameZone[row1-1][colum1]=='*')
                            sum++;
                    }
                    if (row1 - 1>=0 && colum1 + 1 < colum){
                        if (gameZone[row1 - 1][colum1 + 1]=='*')
                            sum++;
                    }
                    if (colum1 - 1 >=0){
                        if (gameZone[row1][colum1-1]== '*')
                            sum++;
                    }
                    if (colum1 + 1 < colum){
                        if (gameZone[row1][colum1+1]=='*')
                            sum++;
                    }
                    if (row1 + 1< row && colum1 - 1 >=0){
                        if (gameZone[row1+1][colum1-1]=='*')
                            sum++;
                    }
                    if (row1+1<row){
                        if (gameZone[row1 +1 ][colum1]=='*')
                            sum++;
                    }
                    if (row1 + 1<row && colum1 + 1 <colum){
                        if (gameZone[row1 + 1][ colum1 + 1]=='*')
                            sum++;
                    }

                    numField[row1][colum1] = String.valueOf(sum);
                }

            }else {
                System.out.println("Yanlis Bir Deger Girdiniz");
            }
            System.out.println("===============");
            loopRepeat--;

            if (loopRepeat == 0){
                System.out.println("Oyunu Kazandiniz!");

                for (int i=0;i<row;i++){
                    for (int j=0;j<colum;j++){
                        System.out.print(numField[i][j]+" ");
                    }
                    System.out.println();
                }
            }
        }

    }
    public void createGameZone(int row,int colum){

        gameZone = new char[row][colum];
        numField = new String[row][colum];

        for (int i=0;i<row;i++){
            for (int j=0;j<colum;j++){
                gameZone[i][j]='-';
                numField[i][j]="-";

            }
        }


    }
    public void addMines(int row,int colum){

        int size = row*colum;
        int numMines = size/4;


        for (int i=0;i<numMines;i++){

            int randomX=(int)(Math.random()*row);
            int randomY=(int)(Math.random()*colum);
            if (gameZone[randomX][randomY]=='*'){
                numMines++;
            }
            else {
                gameZone[randomX][randomY]='*';
            }
        }
    }
    public void showField(int row,int colum){
        System.out.println("Mayinlarin Konumu");
        for (int i=0;i<row;i++){
            for(int j=0;j<colum;j++){
                System.out.print(gameZone[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }
}
