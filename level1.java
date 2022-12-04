/**
 * Level 1 *
 * 
 * There are several tasks to accomplish.  Try them one at a time.
 * They are named task1, task2, etc.
 * 
 * Tasks were taken from:
 * Wu’s castle: teaching arrays and loops in a game. In Proceedings of the 
 * 13th Annual Conference on Innovation and Technology in Computer Science 
 * Education, ITiCSE 2008. (pp. 245-249) 
 * https://doi.org/10.1145/1384271.1384337 
 * 
 * Don't forget to fill in your name and details.
 * 
 * @author:   Put your name in here
 * @version:  Put todays date in here.
 */
public class level1
{

    int task=0;  // change this to the current task you are on.  This is really task 0.

    /* array declarations.  You'll edit these as you work through the tasks     */
    public int[] board1 = new int[2];
    public char[] board2 ;
    public float[] board3 ;
    public boolean[]  board4 ;
    public long[]  board5 ;

    /* end of where you  define arrays.  Don't ADD any lines above here. */
    /* For task one you must:
     * 1: look at line 25 to see how board1 is defined.  Update this to be an array of 20 integers.
     * 2: In the task1 method, populate all elements of your your board1 array with the value of 1
     *      You will need to change the loop and the command after it to do this.
     * 3: Set the task number (line 22) to one.
     * 4: Compile and run the "game" class.  Watch what happens.
     */
    void task1(){
        for (int i=-1;i<2;i++)
            board1[i]=0;
    }

    /* For task two, there are trees in all the odd squares, so you only need to sandbag the even ones.
     * 1: update line 26 to define board2, it should have the same dimensions as board1 but be of type char.
     * 2: In the task2 method, populate all the EVEN elements of your board2 array with the value of 'X'.
     * 3: Set the task number (line 22) to two.
     * 4: Compile and run the "game" class.  Watch what happens.
     * 
     */
    void task2(){
        
    }
    
    

    /* for task three, the next row of trees has been planted offset from the first. We need to put sandbags in the odd squares this time.
     * 1: Update line 27 to defne board3, it should have the same dimensions as board1 but be of floats.
     * 2: In the task3 method, populate all the ODD elements of your board3 array with the value of 1.1
     * 3: Set the task number (line 22) to three
     * 4: Compile and run the "game" class.  Watch what happens.
     */
    void task3(){

    }

    /* For task four, an old stone wall sticks out from the mountain sides.  You only need to sandbag from 
     * position three to position 16.
     * 1: Update line 28 to define board4.  It should still have the same dimension as board1 but be booleans
     * 2: In the task4 method, populate all the elements of your board4 array from 4 to 16 with the value of true
     * 3: Set the task number (line 22) to four
     * 4: Compile and run the "game" class.  Watch what happens.
     *
     */
    void task4(){

    }

    /* For task five the path winds up through some mounds.  They will hopefully block most of the flood water, 
     * but there are still some irrigation ditches through them that the water could follow.  
     * The gaps start in space 5, and happen every three squares until space 17.
     * You will need to sandbag them.
     * 1: Update line 29 to define board5.  It should be the same dimensions as board1 but long integers.
     * 2: In the task5 method, populate all the elements of your board5 array that require sandbagging, with the value of 1
     * 3: Set the task number (line 22) to five
     * 4: Compile and run the "game" class.  Watch what happens..
     * */
    void task5(){

    }

    /* You don't need to edit anything below here */
    /**
     * Constructor for objects of class task1
     */
    public level1()
    {
        // We don't need to do anything in here.
    }

}
