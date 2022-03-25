
/**
 * Main driver for the game
 *
 * @author Bill Viggers
 * @version 20-March-2022
 */

public class game
{

    final int MAXCOLS=20;

    /**
     * Constructor for objects of class game
     */
    public game()
    {
        // initialise instance variables
        level1 first = new level1();        
        Screen s = new Screen();
        int error=-1; // no errors.
        int errordetail=0; // task specific errors.

        // Set the inital flood waters
        for (int i=0;i<MAXCOLS;i++)
            s.map[0][i]=0;

        // check array bounds
        //int check=0;  // us for which checks the try is for.
        int taskcheck=1;  // which task to try.

        // first we check items that should give errors.  this makes sure that bounds are not set too high
        // Because of these we can't really do it in a loop.

        try{
            int x=first.board1[20];
            System.out.println("You made the array too big in task 1");
            error=1;
        } catch (Exception e) {} // we expect an error here, no problems.

        if (error==0){
            try{
                char x=first.board2[20];
                System.out.println("You made the array too big in task 2");
                error=1;
            } catch (Exception e) {} // we expect an error here, no problems.
        } // check task 2 upper bound

        if (error==0){
            try{
                float x=first.board3[20];
                System.out.println("You made the array too big in task 3");
                error=1;
            } catch (Exception e) {} // we expect an error here, no problems.
        } // check task 3 upper bound
        if (error==0){
            try{
                float x=first.board4[20];
                System.out.println("You made the array too big in task 4");
                error=1;
            } catch (Exception e) {} // we expect an error here, no problems.
        } // check task 4 upper bound
        if (error==0){
            try{
                float x=first.board5[20];
                System.out.println("You made the array too big in task 5");
                error=1;
            } catch (Exception e) {} // we expect an error here, no problems.
        } // check task 5 upper bound  

        
        
        // Now we check that arrays was big enough.  These should not generate errors.
        if (error ==0)
        try {
            System.out.println("Checking bounds are high enough");
            taskcheck=1;
            int x=first.board1[19]; // should not give an error
            taskcheck=2;
            char c=first.board2[19]; // should not give an error;
            taskcheck=3;
            float f=first.board3[19]; // should not give an error;
            taskcheck=4;
            x=first.board4[19]; // should not give an error
            taskcheck=5;
            x=first.board5[19]; // should not give an error
            
            
            
        } catch (Exception e) {
            System.out.println("Hmm... an error...");
            System.out.println("You didn't set the array bound high enough for task "+taskcheck);
            //System.out.println(e);
            error=1;
        }

        if (error !=1)
        switch (first.task){  
            case 5: // irrigation ditches
            first.task5();
            boolean okay=true;
            for (int i=0; i<20; i++) {  //check each position 
                s.map[5][i]=first.board5[i];
                if ( i>=5 && i<=17 && (i%3==2)){  // there should be a sandbag.
                    if (first.board5[i]!=1){
                        System.out.println("You forgot to put a sandbag in square "+i+" for task 5");   
                        error=5;                
                    } // missing sandbag                    
                } // position might have a sandbag
                else { // check nothing was put where it shouldn't be.
                    if (first.board5[i]!=0){
                        System.out.println("You didn't need to put something in square "+i+" in task 5.  It's already high enough.");
                        error=5;
                        errordetail=1;
                    }// something put on a hill
                    else { // add the hill image
                        s.map[5][i]=5;
                    } // add correct icon to map.

                } // hill squares.

            } // each location.
            case 4: // wall from edges
            first.task4();
            for (int i=0; i<3; i++){ 
                s.map[4][i]=4;
                s.map[4][MAXCOLS-i-1]=4;
                if (first.board4[i]!=0 || first.board4[MAXCOLS-i-1]!=0){
                    System.out.println("You can't put something in square "+i+" in task 4.  It's got a wall there!");
                    error =4;
                    errordetail=1;
                }
            } // set up walls.
            for (int i=3;i<=16;i++){
                s.map[4][i]=first.board4[i];
                if (first.board4[i]!=1){
                    System.out.println("You forgot to put a sandbag in square "+i+" for task 4");   
                    error=4;
                }//  no sandbag

            } // for each square that should be sanbagged.
            case 3: // even stones, odd sandbags
            first.task3();
            for (int i=0; i< MAXCOLS;i++) {

                if (i%2==1){ // we should have a sandbag here.
                    if ( first.board3[i] !=1.1f){ 
                        System.out.println("You forgot to put a sandbag in square "+i+" for task 3");   
                        error=3;
                    }//  no sandbag
                    else s.map[3][i]=1; //put in the sandbag.
                } // even square
                if (i%2==0 ){
                    s.map[3][i]=3; // 3=monolith
                    if (first.board3[i] !=0){ // they will run out of sandbags...
                        System.out.println("There is something on top of the monolith in square "+i+" for task 3"); 
                        error=3;
                        errordetail=1;
                    } // something put over the stone.
                } // odd square
            } //for

            case 2: // odd trees, even sandbags
            first.task2();
            for (int i=0; i< MAXCOLS;i++) {

                if (i%2==0){ // we should have a sandbag here.
                    if ( first.board2[i] !='X'){ 
                        System.out.println("You forgot to put a sandbag in square "+i+" for task 2");   
                        error=2;
                    }//  no sandbag
                    else s.map[2][i]=1; // lets add the sandbag.
                } // even square
                if (i%2==1 ){
                    s.map[2][i]=2; // 2=tree
                    if (first.board2[i] !='\u0000'){ // they will run out of sandbags...
                        System.out.println("You put something on top of the tree in square "+i+" for task 2"); 
                        error=2;
                        errordetail=1;
                    } // something put over the tree.
                } // odd square
            } //for

            case 1:  // line of sandbags
            first.task1();
            for (int i=0; i< MAXCOLS;i++) {
                s.map[1][i]=first.board1[i];
                if (first.board1[i] !=1){
                    System.out.println("You forgot to put a sandbag in square "+i+" for task 1");   
                    error=1;
                }// if
            } //for
            break;
            default: System.out.println("You have not correctly set your task variable on line 16");
            System.out.println("It is currently set to "+first.task);
            error =0;
            break;
        } // switch

        if (error > -1){
            System.out.println("The village flooded.  Go back to task "+error+" and check your work");
        } else {
            System.out.println("Hurrah!  You saved the village from wave "+first.task);
        }

        /*
        for (int i=0;i<MAXCOLS;i++)
        System.out.println(s.map[0][i]);
         */
        s.repaint();
    } // constructor

}
