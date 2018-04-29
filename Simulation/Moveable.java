/*
File Name: Moveable.java
Developers: Sheldon Benard
Purpose: Contains code for the Moveable (non-stationary) items in the simulation
Input,Output: None
 */
public class Moveable extends Item{
    /*
    Name: Moveable
    Developers: Sheldon Benard
    Inputs: Item's name, token, x&y position
    Purpose: Constructor: use parent constructor
    */
    public Moveable(String name, char token, int x, int y){
        super(name,token,x,y);
    }

    /*
    Name: bump
    Developers: Sheldon Benard
    Inputs: proposed move in X direction and Y direction
    Purpose: Move a non-stationary item; if an item is in the way, recursively call Bump on that item\
    Returns: True if move can and has been made; return false if move can't be made
    */
    public boolean bump(int moveX, int moveY){
        int[] coordinates = this.getCoordinates();

        int x = coordinates[0];
        int y = coordinates[1];

        int newX = x + moveX;
        int newY = y + moveY;

        Item itemInTheWay = null;

        // try and see if there is an item in the way; if out of the world, return false -> can't make move
        try {
            itemInTheWay = World.getInstance().getItem(newX, newY);
        }catch(IndexOutOfBoundsException e){
            return false;
        }

        // if there is no item in the way -> make the move and return true (unless exception thrown)
        if (itemInTheWay == null){
            try{
                World.getInstance().updateWorld(x,y,newX,newY);
                this.setCoordinates(newX,newY);
            }catch (Exception e){
                return false;
            }
        }

        // if there is an item in the way, recursively call bump on that item using the same proposed move
        else{
            boolean movable = itemInTheWay.bump(moveX,moveY);

            //if that item was moved, then proceed to try and move the current item
            if(movable){
                try{
                    World.getInstance().updateWorld(x,y,newX,newY);
                    this.setCoordinates(newX,newY);
                } catch (Exception e){
                    return false;
                }
            }
            // else, the item isn't able to be bumped, so this current item isn't as well
            else{
                return false;
            }
        }
        return true;
    }

}
