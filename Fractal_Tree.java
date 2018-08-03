/* Author: Brandon Baker
 * Project: Fractal Tree
 * 
 * Purpose:
 * The purpose of this project is to show how to create a simple graphics application with the JFrame class. 
 * The end result will display a fractal tree animation which will be drawn onto the JFrame in intervals. 
 * By the end of this project, the reader will have a better understanding of how to create a JFrame 
 * window and draw things onto that window. The reader will also have a basic understanding of 
 * classes and simple objects, which will lead them into the world of Object Oriented Programming. 
 * 
 * 
 * Output:
 * A fractal tree drawn onto the screen in intervals.
 * 
 */


//This allows us to use built in colors, as well as, customize our own colors in Java.
import java.awt.Color;
//This allows us to draw things to the screen. For example, we are able to draw the fractal tree to the screen.
import java.awt.Graphics;
//This allows us to create a window and add things to it.
import javax.swing.JFrame;
 

/* This is our class called "Fractal_Tree" which uses JFrame. Essentially the "Fractal_Tree" class inherits 
 * all the components of the JFrame class defined in Java.
 */
public class Fractal_Tree extends JFrame {
 
    /* This is a definition implemented by the Eclipse IDE, and happens after you create your 
	 * "Fractal_Tree" class.
	 */
	private static final long serialVersionUID = 1L;

	
	//Creating an object called Fractal_Tree
	public  Fractal_Tree() {
		//Setting the title of the JFrame, or the window.
        setTitle("Fractal Tree");
        
        //Setting a fixed size of the JFrame, or the window.
        setSize(800, 600);
        
        //Not allowing the JFrame to be resizable, unlike your internet browser which is resizable. 
        setResizable(false);
        
        /* Setting the location of the JFrame to the middle of the screen. Basically, if the Location is relative to 
         * "null" this will place the JFrame at the middle of the screen. 
         */
        setLocationRelativeTo(null);
        
        //Allowing the JFrame to be visible on the screen. If this was false, nothing would happen on the screen.
        setVisible(true);
        
        //Setting the default to exit the application after the exit button is pushed.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Creating a new color for the background using the imported color class. 
        Color offWhite = new Color(255,255,244);
        
        //Setting the Background Color of the JFrame to the new color created. 
        setBackground(offWhite);
    }
 
	//Creating a function to draw the Fractal_Tree object onto the JFrame
	
	/* The "drawTree" function will be using variables such as graphics, location, angle of rotation, and number of iterations
	 * 
	 */
    private void drawTree(Graphics g, int x1, int y1, double angle, int iteration) {
        
    	//If the "iteration" is equal to 0, then this will mean that the branch has reached the end length as defined when calling the "drawTree" object.
    	if (iteration == 0) return;
    	
    	//Creating a way to pause the tree from being drawn instantly. This will allow the tree to be drawn in intervals. 
        try {
			Thread.sleep(30);
			
		//This is the Java auto-completed method for the catch exception.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        /* Declaring two new integer variables x2 and y2 to indicate the initial size of the branch. These variables will be equal to x1 and y1 plus the angle at which the new branch is rotated,
         * multiplied by the iteration, multiplied by 10.0. Essentially, this means that with each iteration, the branch will get rotated by an angle and decrease
         * its size until the number of iterations is equal to zero.
         */
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * iteration * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * iteration * 10.0);
        
        //This will draw the first branch at the location specified by x1 and x2 with the size and angle specified by x2 and y2.
        g.drawLine(x1, y1, x2, y2);
        
        //The repaint method paint the "Fractal_Tree" object onto the JFrame.
        repaint();
        
        /* The "drawTree" function will call itself until the iteration is equal to 0.
         * This will cause the "Fractal_Tree" object to be drawn with each iteration scaling the size.
         */
        drawTree(g, x2, y2, angle - 15, iteration - 1);
        drawTree(g, x2, y2, angle + 15, iteration - 1);
    }
 
    /*
     * Setting up a paint component for the color of the "Fractal_Tree" object. 
     * Since the "Fractal_Tree" object is being drawn and re-drawn we have to initialize a "paint" component.
     * We did not have to create a "paint" component for the background color because we are not re-drawing the component.
     * This method uses the "repaint()" method in line 97.
     */
    @Override
    public void paint(Graphics g) {
    	
    	//Creating a new color for the tree branch.
    	Color barkBrown = new Color(51,42,34);
    	
    	//Setting the new color to the variable "g"
        g.setColor(barkBrown);
        
        //Calling the "drawTree" method and sending the color g, the size of the tree, the angle, and the number of iterations.
        drawTree(g, 400, 500, -90, 9 );
        
    }
 
    
    //This is the main function which everything is called and created. Every program will have a main function such as this. 
    public static void main(String[] args) {
    	
    	//Creating a new "Fractal_Tree" object. By creating this object, it will call the class and run through all the code that has been defined. 
        new Fractal_Tree();
    }
}