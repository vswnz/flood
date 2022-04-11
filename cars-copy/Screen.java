
/**
 * Draw a grid on the screen.
 *
 * @author Bill
 * @version March 20 2022
 * 
 */

// Libraries for GUI
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;  // geometry stuff for lines

public class Screen extends JFrame {
    //    final String imageFile = "mole100.png";// Feel free to use a water pipe image if you have one.

    final int wSize=1200;  // How big is the window?
    final int imageSize=100;
    final int GRIDSIZE=50;  // size of each square
    final int ROWOFFSET=120; // how far down the first row of grids is.
    final int COLS=20;  // how many squares to draw on the grid
    final int COLLOFFSET=70; // how far from left hand edge do we start?
    final int ROWS=10; // How many rows do we draw?

    // And the grid that contains our village contents
    int map[][] = new int[ROWS][COLS];  // 0 is empty, 1 is a sandbag, all we have so far.

    //Variables for what we want to display
    boolean display1DGrid=true;
    boolean drawMap=true;

    // images
    final String sandBagFile="sandbag - Copy.jpg";
    ImageIcon sandBagImage= new ImageIcon(sandBagFile);
    final String waterFile="water.jpg";
    ImageIcon waterImage = new ImageIcon(waterFile);
    final String treeFile="tree.jpg";
    ImageIcon treeImage = new ImageIcon(treeFile);
    final String stoneFile="stone.jpg";
    ImageIcon stoneImage = new ImageIcon(stoneFile);
    final String wallFile="wall.jpg";
    ImageIcon wallImage = new ImageIcon(wallFile);
    final String moundFile="mound.jpg";
    ImageIcon moundImage = new ImageIcon(moundFile);


    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        if (drawMap){
            // mountains to left and right
            // fillrect, x,y, width, height
            g2.fillRect(COLLOFFSET-GRIDSIZE,ROWOFFSET,  GRIDSIZE,GRIDSIZE*ROWS);
            g2.fillRect(COLLOFFSET+GRIDSIZE*COLS,ROWOFFSET,  GRIDSIZE,GRIDSIZE*ROWS);

        }
        if (display1DGrid){ // Show the axis if we want to.
            //Line2D - xstart,ystart,xend,yend
            //X axis lines
            Line2D lin = new Line2D.Float(COLLOFFSET, ROWOFFSET, COLLOFFSET+COLS*GRIDSIZE, ROWOFFSET);
            g2.draw(lin);
            lin = new Line2D.Float(COLLOFFSET, ROWOFFSET+GRIDSIZE, COLLOFFSET+COLS*GRIDSIZE, ROWOFFSET+GRIDSIZE);
            g2.draw(lin);

            for (int i=0; i<= COLS;i++){
                lin = new Line2D.Float(COLLOFFSET+i*GRIDSIZE, ROWOFFSET, COLLOFFSET+i*GRIDSIZE, ROWOFFSET+GRIDSIZE);  //Line2D - xstart,ystart,xend,yend
                g2.draw(lin);
            }

            // draw a sandbag
            for (int r=0; r<ROWS;r++)
                for (int c=0;c<COLS;c++)
                    switch (map[r][c]){ // 1 is a sandbag.
                        case -1: break; // base empty case
                        case 0: waterImage.paintIcon(this, g, COLLOFFSET+c*GRIDSIZE+1,ROWOFFSET+r*GRIDSIZE+1); // +1 so to not sit on gridline
                        break;
                        case 1: sandBagImage.paintIcon(this, g, COLLOFFSET+c*GRIDSIZE+1,ROWOFFSET+r*GRIDSIZE+1); // +1 so to not sit on gridline
                        break;
                        case 2: treeImage.paintIcon(this, g, COLLOFFSET+c*GRIDSIZE+1,ROWOFFSET+r*GRIDSIZE+1);
                        break;
                        case 3: stoneImage.paintIcon(this, g, COLLOFFSET+c*GRIDSIZE+1,ROWOFFSET+r*GRIDSIZE+1);
                        break;
                        case 4: wallImage.paintIcon(this, g, COLLOFFSET+c*GRIDSIZE+1,ROWOFFSET+r*GRIDSIZE+1);
                        break;
                        case 5: moundImage.paintIcon(this, g, COLLOFFSET+c*GRIDSIZE+1,ROWOFFSET+r*GRIDSIZE+1);
                        break;
                        default: System.out.println("Something odd got put in a square...");
                        break;
                    }

        } // Display the axis
       
        // debug check icons
        System.out.println("debug: water");
        waterImage.paintIcon(this, g, COLLOFFSET+10*GRIDSIZE+1,ROWOFFSET+10*GRIDSIZE+1);
    }
    // This method sets up the basic frame we will use.
    public Screen(){
        setTitle("Village in Flood");  //Whateveryou want the window to be called.

        // start with empty map
        for (int r=0;r<ROWS;r++)
            for (int c=0; c<COLS;c++)
                map[r][c]=-1;  // we use -1 as uninitialised arrays are 0 and we want to catch that.

        // Lets load the library.

        this.getContentPane().setPreferredSize(new Dimension(wSize,wSize));  
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.pack();
        this.toFront();  // Not too sure what this does, commenting out makes no apparent difference
        this.setVisible(true);

        // We'll update the board here and call paint again  and again

    }
}
