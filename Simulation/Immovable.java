/*
File Name: Immovable.java
Developers: Sheldon Benard
Purpose: Contains code for the Immovable (stationary) items in the simulation
Input,Output: None
 */
public class Immovable extends Item {

    /*
    Name: Immovable
    Developers: Sheldon Benard
    Inputs: Item's name, token, x&y position
    Purpose: Constructor: use parent constructor
    */
    public Immovable(String name, char token, int x, int y){
        super(name,token,x,y);
    }

    /*
    Name: bump
    Developers: Sheldon Benard
    Inputs: new x,y position
    Purpose: Implements abstract method; return false -> can never be bumped
    */
    public boolean bump(int moveX, int moveY){
        return false;
    }

    /*
    Name: setCoordinates
    Developers: Sheldon Benard
    Inputs: new x,y position
    Purpose: Override setCoordinates; throw exception if trying to adjust coordinates
    */
    public void setCoordinates(int x, int y)throws Exception{
        throw new Exception("Can't move immovable item");
    }

}
