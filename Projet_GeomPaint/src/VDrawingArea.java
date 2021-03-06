import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * This class is the view of our program
 * its role is to draw all the figure
 * every time a change is detected
 */
@SuppressWarnings("serial")
public class VDrawingArea extends JPanel implements Observer {


	/**
	 * Attribute corresponding to the model linked with this view.
	 */
	private Model model;

	/**
	 * Constructor of the class VDrawingArea
	 * @param m - model to be linked with this view.
	 */
	public VDrawingArea(Model m){
		super();
		this.model = m;
		
		// Adding listeners to the View.
		CDrawingArea cda = new CDrawingArea(m);
		this.addMouseListener(cda);
		this.addMouseMotionListener(cda);
		
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	this.displayAll(g);
	}


	/**
	 * every time a change is noticed, we check repaint everything
	 */
	public void update(Observable o, Object arg1) {
		this.model = (Model) o;
		repaint();		
	}
	
	/**
	 * this method is use to draw every single figure,
	 * for each figure we check if this is a polygon or a circle type
	 * in both case we also change the colour and if the figure is 
	 * filled or not
	 */
	public void displayAll(Graphics g){
		GeomShape figure;
    	int nb_pts;
    	for(int i = 0 ; i < this.model.getFigureList().size() ; i++){
    		figure = this.model.getFigureList().get(i);
    		nb_pts = figure.getNumberPoints();
    		// check if it is a polygon or a circle type
    		if (figure instanceof Polygon){
    			int[] coordsX = new int[nb_pts];
        		int[] coordsY = new int[nb_pts];
        		// to draw a polygon, we need to create two tab, one with x coord and other with y coord
        		for (int j = 0 ; j < nb_pts-1 ; j++){
        			coordsX[j] = figure.getPointsTab()[j].getX();
        			coordsY[j] = figure.getPointsTab()[j].getY();
        		}
        		g.setColor(figure.getColour());
        		//check if we need to fill the figure or not
        		if (figure.isFilled())
        			g.fillPolygon(coordsX, coordsY, nb_pts);
        		else
        			g.drawPolygon(coordsX, coordsY, nb_pts);
    		}
    		if (figure instanceof Circle){
    			int radius = figure.getPointsTab()[0].distance(figure.getPointsTab()[1]);
    			int d = radius*2;
    			// Si ! le nom de cette variagle est drole !
    			int coin_x = figure.getPointsTab()[0].getX()-radius;
    			int coin_y = figure.getPointsTab()[0].getY()-radius;
    			g.setColor(figure.getColour());
    			//check if we need to fill the figure or not
    			if (figure.isFilled())
    				g.drawOval(coin_x, coin_y, d, d);
    			else
    				g.fillOval(coin_x, coin_y, d, d);
    		}
    	}
	}
}

	