/*
File Name: Autonomous.java
Developers: Sheldon Benard
Purpose: Contains code for the autonomous (moving) items in the simulation
Input,Output: None
 */
import java.util.Random;


public class Autonomous extends Moveable {

    /*
    Name: Autonomous
    Developers: Sheldon Benard
    Inputs: Item's name, token, x&y position
    Purpose: Constructor: use parent constructor
    */
    public Autonomous(String name, char token, int x, int y){
        super(name,token,x,y);
    }

    /*
    Name: step
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Logic for the autonomous step; overrides the default step in Item
    */
    public void step(){
        int[] move = getMove(); //get move to use

        //Re-use logic in bump; a 'step' can be thought of as a bump
        //by an invisible being/force
        this.bump(move[0],move[1]);
    }

    /*
    Name: getMove
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Helper: get random next move
    */
    private int[] getMove(){
        int[][] moves = {
                {1,0}, //increase row by 1 -> down
                {-1,0}, //decrease row by 1 -> up
                {0,1}, //increase column by 1 -> right
                {0,-1}, //decrease column by 1 -> left
        };
        Random rand = new Random();
        int move = rand.nextInt(moves.length);
        return moves[move];
    }

}
