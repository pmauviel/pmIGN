/*      Class Name: Point
 *      Description: Point in 2D space.
 */
package knightmoves;

public class Point {
    private int x;
    private int y;
    
    //Constructor with values
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    //Copy Constructor
    public Point(Point point)
    {
        this.x = point.getX();
        this.y = point.getY();
    }
    
    //Accessors
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    //for debugging/printing.
    public String toString()
    {
        return "(" + x + " , " + y + ")";
    }
}
