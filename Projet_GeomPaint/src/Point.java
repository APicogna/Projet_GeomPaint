/**
 * Class Point
 * Describes the principal component of any geometric figure.
 * @author VILAS
 */
public class Point {

////////////////////
//   ATTRIBUTES   //
////////////////////
	
	/**
	 * Attributes x and y corresponding respectively to
	 * the abscissa and the ordinate of the Point.
	 */
	private int x,y;
	
	/**
	 * Method translate()
	 * Method that moves a Point as per the data given as argument.
	 * @param dx - variation abscissa-wise.
	 * @param dy - variation ordinate-wise.
	 */
	public void translate(int dx, int dy)
	{
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
	
////////////////////
//    METHODS     //
////////////////////
	
	/**
	 * Constructor of the class Point 
	 * admitting two integers as arguments, 
	 * corresponding to the following:
	 * @param abs - value to be given to the abscissa of the created Point.
	 * @param ord - value to be given to the ordinate of the created Point.
	 */
	public Point(int abs, int ord)
	{
		if(abs >= 0 && ord >= 0)
		{
			this.x = abs;
			this.y = ord;
		}
	}
	
	/**
	 * Method isNearTo()
	 * returns true if the point given as parameter is in a 10px area
	 * around the calling point.
	 * @param p - point to evaluate the proximity of.
	 * @return true if the point given as parameter is in a 10px area around the calling point, false otherwise.
	 */
	public boolean isNearTo(Point p)
	{
		return (p.getX() < this.getX()+5 && p.getX() > this.getX()-5
			&& p.getY() < this.getY()+5 && p.getY() > this.getY()-5);
	}

///////////////////////
// GETTERS & SETTERS //
///////////////////////
	
	/**
	 * Method getX()
	 * @return - abscissa value of the calling Point.
	 */
	public int getX() 
	{
		return x;
	}
	
	/**
	 * Method setX()
	 * @param x - value to be given to the abscissa of the calling Point.
	 */
	public void setX(int x) 
	{
		this.x = x;
	}
	
	/**
	 * Method getY()
	 * @return - ordinate value of the calling Point.
	 */
	public int getY() 
	{
		return y;
	}
	
	/**
	 * Method setY()
	 * @param y - value to be given to the ordinate of the calling Point.
	 */
	public void setY(int y) 
	{
		this.y = y;
	}

}
