//Tic-tac-toe using java
//package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean win=false;
        char player;
        int count=9;
         char[][] table=new char[3][3];
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                 table[i][j]=' ';
            }
        }
        display(table);
        while(true) {
            System.out.println("enter the symbol X || O :");
             player = sc.nextLine().charAt(0);
            if (player == 'x' || player == 'X') {
                player = 'x';
                break;
            }
            else if (player == 'o' || player == 'O') {
                player = 'o';
                break;
            }
            else {
                System.out.println("enter the valid symbol");
            }
        }
        display(table);

        while(!win&& count>=0)
        {
            System.out.println("enter the index :" );
            int i=sc.nextInt();
            int j=sc.nextInt();
            if(i<3&&j<3&&table[i][j]==' ')
            {
                table[i][j]=player;
                display(table);
                if(winning(player,table))
                {
                    System.out.println(player+" is win the game ");
                     win=true;
                }
                else {
                    player=change(player);
                }
            }
            else {
                System.out.println("non valid index");
            }
            count--;
        }
        if(count==-1)
            System.out.println(" draw");


    }
    public static boolean winning(char player,char[][] table)
    {
        for(int i=0;i<3;i++)
        {
            if(table[i][0]==player&&table[i][1]==player&&table[i][2]==player)
                return true;
        }
        for (int i = 0; i < 3; i++) {
            if(table[0][i]==player&&table[1][i]==player&&table[2][i]==player)
                return true;
        }

        if(table[0][0]==player&&table[1][1]==player&&table[2][2]==player)
            return true;
        if(table[0][2]==player&&table[1][1]==player&&table[2][0]==player)
            return true;

        return false;

    }
    public static char change(char player)
    {
        if(player=='x')
            return 'o';
         return 'x';
    }
    public static void display(char[][] table)
    {
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.print(table[i][j]+" | ");;
            }
            System.out.println();
        }
    }
}
