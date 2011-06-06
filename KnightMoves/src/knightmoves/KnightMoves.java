 /*     Project Name: Knight Moves
  *     Author: Paul Mauviel
  *     Question: 
  *     What is the minimum number of moves required 
  *     for a knight to cover the entire chess board?
  *     Answer using Warnsdorff's algorithm.
  */
package knightmoves;


import java.util.*;
public class KnightMoves {


    private static int sizex = 8; //Set Size of grid area
    private static int sizey = 8;
    public static void main(String[] args) 
    {
       Random generator = new Random(); //to generate starting position
       
       //Create new board. (Java inits to 0)
       int[][] board = new int[8][8];   
       
       //Create starting position.
       //Point start = new Point(generator.nextInt(sizex),generator.nextInt(sizey));    
       Point start = new Point(1,0);
       
       System.out.println("Starting Position: " + start + "\n"); //Print starting position
       
       getAnswer(board, start, 1);      //Where the magic happens
       
       
       
       printBoard(board);
       
     }
    
    private static void getAnswer(int[][] board, Point pos, int numberOfMoves)
    {
            
            //Set square just moved to the numberOfMoves
            board[pos.getX()][pos.getY()] = numberOfMoves; 
                                                  
            //Check winning conditions.
            if (checkBoard(board))  
            {
                return;
            }
            
           //will hold possible moves from current square
            LinkedList moves = new LinkedList();    
                                                    
            //fills the moves List
            calculateMoves(moves, pos, board);  
            
            //iterator for list
            ListIterator iter = moves.listIterator();   
            
            Point p; //Current possible move
            
            if (moves.isEmpty())
            {
                //no possible moves in direct viscinity
                return;
            }
            else {
                
                //holds each move's possible moves
                LinkedList temporaryList;  
                
                //List with shortest size from possible moves
                LinkedList finalList = new LinkedList(); 
                                                        
                //next move
                Point nextPoint = new Point(0,0); 
                        
                while (iter.hasNext())
                {
                 
                    //p is now next possible move
                    p = (Point)(iter.next()); 
                    
                    //create a new empty List
                    temporaryList = new LinkedList();
                    
                    //fill List with possible moves from Point p
                    calculateMoves(temporaryList,p,board); 
                    
                    /* If the temporary list is smaller than the current best 
                     * answer's List, then replace it and change the current best
                     * answer.
                     */
                    
                    if (finalList.size() > temporaryList.size() || finalList.size() == 0)
                    {
                        finalList = temporaryList;
                        nextPoint = new Point(p);
                    }  
                }
                
                //Move on and continue.
                getAnswer(board, nextPoint, numberOfMoves+1);

            }
           
        }
    
    
    //if no move has been assigned to any square, return false;
    private static boolean checkBoard(int[][] board)
    {
        for (int i = 0; i < sizex; i++)
        {
            for (int k = 0; k < sizey; k++)
            {
                if (board[i][k] == 0) return false;
            }
        }
        
        return true;
    }
    
    //Check all possible moves, avoiding going off the board and repeating a square
    private static void calculateMoves(LinkedList list, Point pos, int[][] board)
    {
        //Up - Left
        if (pos.getX() - 1 >= 0 && pos.getY() + 2 < sizey)
        {
            Point p = new Point(pos.getX() - 1, pos.getY() + 2);

            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
            
        //Up - Right
        if (pos.getX() + 1 < sizex && pos.getY() + 2 < sizey)
        {
            Point p = new Point(pos.getX() + 1, pos.getY() + 2);
            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
        
        //Right - Up
        if (pos.getX() + 2 < sizex && pos.getY() + 1 < sizey)
        {
            Point p = new Point(pos.getX() + 2, pos.getY() + 1);
            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
        
        //Right - Down
        if (pos.getX() + 2 < sizex && pos.getY() - 1 >= 0)
        {
            Point p = new Point(pos.getX() + 2, pos.getY() - 1);
            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
        
        //Down - Left
        if (pos.getX() - 1 >= 0 && pos.getY() - 2 >= 0)
        {
            Point p = new Point(pos.getX() - 1, pos.getY() - 2);
            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
            
        //Down - Right
        if (pos.getX() + 1 < sizex && pos.getY() - 2 >= 0)
        {
            Point p = new Point(pos.getX() + 1, pos.getY() - 2);
            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
        
        //Left - Up
        if (pos.getX() - 2 >= 0 && pos.getY() + 1 < sizey)
        {
            Point p = new Point(pos.getX() - 2, pos.getY() + 1);
            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
        
        //Left - Down
        if (pos.getX() - 2 >= 0 && pos.getY() - 1 >= 0)
        {
            Point p = new Point(pos.getX() - 2, pos.getY() - 1);
            if (board[p.getX()][p.getY()] == 0)
            {
                list.add(p);
            }
        }
    }
    
    
    //print board
    private static void printBoard(int[][] board)
    {
        for (int i = sizey -1; i >= 0; i--)      //Print final move board.
       {
           System.out.print(""+ i + "| ");
           for (int k = 0; k < sizex; k++)
           {
               System.out.print("\t" + board[k][i] + " ");
           }
           System.out.println("\n\n");
       }
       for (int k = 0; k < sizex; k++)
       {
            System.out.print("\t---");
       }
       System.out.println();
       for (int k = 0; k < sizex; k++)
       {
            System.out.print("\t" + k + " ");
       }
    }
}
