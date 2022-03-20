
/**
 * Level 1 *
 * 
 * There are several tasks to accomplish.  Try them one at a time.
 * They are named task1, task2, etc.
 * 
 * Don't forget to fill in your name and details.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class level1
{

    int task=5;  // change this to the current task you are on.  This is really task 0.

    /* array declarations.  You'll edit these as you work through the tasks     */
    public int board1[]=new int[20];
    public int board2[]=new int[20];
    public int board3[]=new int[20];
    public int board4[] = new int [20];
    public int board5[] = new int[20];
    public int board6;
    public int board7;

    /* end of where you  define arrays*/

    /* For task one you must:
     * 1: look at line 19 to see how board1 is defined.
     * 2: In the task1 method, populate all elements of your your board1 array with the value of one.
     * 3: Set the task number (line 16) to one.
     * 4: Compile and run.  Watch what happens.
     */
    void task1(){

        for (int i=0;i<20;i++)
            board1[i]=1;
        //board1[7]=0; // test water        
    }

    /* For task two, there are trees in all the odd squares, so you only need to sandbag the even ones.
     * 1: update line 20 to define board2, it should have the same dimensions as board1.
     * 2: In the task2 method, populate all the EVEN elements of your board2 array with the value of one.
     * 3: set the task number (line 16) to two.
     * 4: Compile and run.  Watch what happens.
     * 
     */
    void task2(){

        for (int i=0;i<20;i+=2)
            board2[i]=1;

    }

    /* for task three, the next row of trees has been planted offset from the first. We need to put sandbags in the odd squares this time.
     * 1: update line 21 to defne board3, it should have the same dimensions as board1.
     * 2: In the task3 method, populate all the ODD elements of your board3 array with the value of one.
     * 3: set the task number (line 16) to three
     * 4: Compile and run.  Watch what happens.
     */

    void task3(){
        for (int i=1;i<20;i+=2)
            board3[i]=1;

        //board3[18]=3;

    }
    /* For task four, an old stone wall sticks out from the mountain sides.  You only need to sandbag from position three to position 16.
     * 1: update line 22 to define board4.  It should still have the same dimension as board1
     * 2: In the task5 method, populate all the elements of your board4 array from 4 to 16 with the value of one
     * 3: set the task number (line 16) to four
     * 4: compile and run.  Watch what happens.
     *
     */

    void task4(){
        for (int i=3; i<=16; i++)
            board4[i]=1;

        //board4[7]=0;

        //board4[1]=1;

    }

    /* For task five the path winds up through some mounds.  They will hopefully block most of the flood water, but there are still some irrigation ditches
     * through them that the water could follow.  They start in space 5, and happen every three squares until space 17.
     * You will need to sandbag them.
     * 1: Update line 22 to define board5.  It should be the same dimensions as board1.
     * 2: In the task5 method, populate all the elements of your board5 array that require sandbagging, with the value of one.
     * 3: set the task number (line 16) to five
     * 4: Compile and run.  Watch what happens.
     * */

    void task5(){
        for (int i=6; i<=17; i+=3) 
            board5[i]=1;

    }

    
    /* You don't need to edit anything below here */

    /**
     * Constructor for objects of class task1
     */
    public level1()
    {
    }
    // method to return a given array from this class

}
