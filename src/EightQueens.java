import java.io.Console;

public class EightQueens
{
    static boolean[][] board = new boolean[8][8];
    static int queensCount = 0;
    static int startJ = 0;
    static int boardCount = 0;

    public static void main(String[] args)
    {
        resetBoard();
        for (int i = 0; i < 8; i++)
        {
            int j = startJ;
            for (; j < 8; j++)
            {
                if(startJ != 0)
                {
                    startJ = 0;
                }
                if (canPlaceQueen(i, j))
                {
                    board[i][j] = true;
                    queensCount++;
                    break;
                }
            }
            if(j == 8)
            {
                do
                {
                    if(i == 0)
                    {
                        return;
                    }
                    resetRow(--i);
                }
                while (startJ == 8);
                --i;
            }
            if(queensCount == 8)
            {
                outputBoard();
                do
                {
                    resetRow(i);
                    --i;

                    if(i < 0)
                    {
                        return;
                    }
                }
                while (startJ == 8);

            }
        }
    }

    private static void resetRow(final int i)
    {
        for(int j = 0; j< 8; j++)
        {
            if(board[i][j]) {
                startJ = j+1;
            }
            board[i][j] = false;
        }
        queensCount--;
    }

    private static void outputBoard()
    {
        System.out.println("found board: " + ++boardCount );
        for(int i =0; i<8; i++)
        {
            for(int j =0; j<8; j++)
            {
               if(board[i][j]) {
                   System.out.print("Q");
               } else {
                   System.out.print("N");
               }
            }
            System.out.println();
        }
    }

    private static void resetBoard()
    {
        queensCount = 0;
        for(int i =0; i<8; i++)
        {
            for(int j =0; j<8; j++)
            {
                board[i][j] = false;
            }
        }
    }

    private static boolean canPlaceQueen(final int i, final int j)
    {
        //row check
        for(int l = 0; l< 8; l++)
        {
            if(board[i][l])
                return false;
        }
        //column check
        for(int l = 0; l< 8; l++)
        {
            if(board[l][j])
                return false;
        }

        //diagonal check
        for(int p = 1; p < 7; p++)
        {
            if(i+p < 8 && j+p < 8 && board[i+p][j+p])
                return false;
            if(i+p < 8 && j-p >= 0 && board[i+p][j-p])
                return false;
            if(i-p >= 0 && j+p < 8 && board[i-p][j+p])
                return false;
            if(i-p >= 0 && j-p >= 0 && board[i-p][j-p])
                return false;
        }

        return true;
    }
}
