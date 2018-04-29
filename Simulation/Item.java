/*
File Name: Item.java
Developers: Sheldon Benard
Purpose: Abstract method for Items that populate world; Items are stepable
Input,Output: None
 */
public abstract class Item implements Stepable {
    private String name;
    private char token;
    //Coordinates
    private int x;
    private int y;

    //Indicator for if the Item has been moved during this step of the simulation
    private boolean moved = false;

    /*
    Name: Item
    Developers: Sheldon Benard
    Inputs: Item's name, token, x&y position
    Purpose: Constructor: set fields with inputs
    */
    public Item(String name, char token, int x, int y){
        this.name = name;
        this.token = token;
        this.x = x;
        this.y = y;
    }

    /*
    Name: bump
    Developers: Sheldon Benard
    Inputs: New x,y positions
    Purpose: Abstract - define bump method that children should implement
    */
    public abstract boolean bump(int x, int y);

    /*
    Name: getCoordinates
    Developers: Sheldon Benard
    Inputs: None
    Purpose: return coordinate array
    */
    public int[] getCoordinates(){
        int[] coordinates = {this.x,this.y};
        return coordinates;
    }

    /*
    Name: getToken
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Return this.token
    */
    public char getToken(){
        return this.token;
    }

    /*
    Name: step
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Define default step, which is to do nothing
    */
    public void step(){}

    /*
    Name: hasMoved,setMoved,resetMoved
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Getters,setters for moved field
    */
    public boolean hasMoved(){
        return moved;
    }
    public void setMoved(){
        this.moved = true;
    }
    public void resetMoved(){
        this.moved = false;
    }

    /*
    Name: setCoordinates
    Developers: Sheldon Benard
    Inputs: new x,y coordinates
    Purpose: Set new coordinates; make sure coordinates are valid
    */
    public void setCoordinates(int x, int y) throws Exception{
        //if the new x or y coordinates deviate more than 1 from the old -> invalid move
        if (Math.abs(this.x - x) > 1)
            throw new Exception("Invalid move");
        else if (Math.abs(this.y - y) > 1)
            throw new Exception("Invalid move");
        else{
            this.x = x;
            this.y = y;
        }
    }
}
