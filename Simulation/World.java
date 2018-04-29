/*
File Name: World.java
Developers: Sheldon Benard
Purpose: Contains code for creating the world and implementing world logic; world is stepable
Input,Output: None
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class World implements Stepable{
    //if the user doesn't createWorld before getInstance, createWorld with default rows,columns
    private static final int DEFAULT_ROW = 10;
    private static final int DEFAULT_COL = 10;
    private int rows;
    private int columns;
    private Item[][] world;

    private static World instance; //Singleton design, so have static world object

    //Frame and textfields for the Items in the world
    private JFrame mainFrame;
    private JTextField[][] tokens;

    /*
    Name: createWorld
    Developers: Sheldon Benard
    Inputs: rows,columns
    Purpose: Create world instance with specified rows,columns; return instance if it already exists
    */
    public static World createWorld(int rows, int columns) {
        if (instance == null){
            instance = new World(rows,columns);
            return instance;
        }
        else {
            System.out.println("World already created");
            return instance;
        }
    }

    /*
    Name: getInstance
    Developers: Sheldon Benard
    Inputs: None
    Purpose: get world instance; create default if none exists
    */
    public static World getInstance(){
        if (instance == null) {
            System.out.println("No world exists; create default world");
            instance = createWorld(DEFAULT_ROW, DEFAULT_COL);
        }
        return instance;
    }

    /*
    Name: World
    Developers: Sheldon Benard
    Inputs: rows,columns
    Purpose: private (for singleton) constructor for world; create Item[][] array and set rows,columns
    */
    private World(int rows, int columns){
        this.world = new Item[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    /*
    Name: getItem
    Developers: Sheldon Benard
    Inputs: x,y coordinates
    Purpose: get item form world[][] using x,y
    */
    public Item getItem(int x, int y) throws IndexOutOfBoundsException{
        return world[x][y];
    }

    /*
    Name: updateWorld
    Developers: Sheldon Benard
    Inputs: old x,y coordinates, new x,y coordinates
    Purpose: If Item is moved, update the world by moving Item
    */
    public void updateWorld(int x, int y, int newX, int newY) throws IndexOutOfBoundsException{
        Item item = this.world[x][y];

        if(item == null)return;

        this.world[newX][newY] = item;
        this.world[x][y] = null;
    }

    /*
    Name: step
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Do one iteration of the simulation; call step on all the items
    */
    public void step(){
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                Item item = this.world[i][j];

                if (item == null) continue;
                else{
                    //If item was already moved during this simulation, don't move it again
                    if (item.hasMoved()){
                        item.resetMoved();
                        continue;
                    }

                    item.step();

                    //Now, we don't want to move the same item twice; if the item moved right or down, we will see it again
                    //so setMoved() in this case
                    int[] coordinates = item.getCoordinates();
                    boolean rightMove = coordinates[1] - j == 1 && coordinates[0] - i == 0;
                    boolean downMove = coordinates[1] - j == 0 && coordinates[0] - i == 1;
                    if(rightMove || downMove)item.setMoved();
                }
            }
        }
    }

    /*
    Name: buildWorldDisplay
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Build swing world using JFrame and rows*columns JTextFields
    */
    public void buildWorldDisplay(){
        mainFrame = new JFrame("Java Simulation");
        mainFrame.setSize(500,500);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        mainFrame.setLayout(new GridLayout(this.rows,this.columns));
        tokens = new JTextField[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns;j++){
                tokens[i][j] = new JTextField();
                mainFrame.add(tokens[i][j]);
            }
        }
        mainFrame.setVisible(true);
    }

    /*
    Name: display
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Display the world after each iteration; (must include updated locations for each Item)
    */
    public void display(){
        mainFrame.revalidate();

        //For each Item[][] world coordinate, update the associated textField
        for(int j = 0; j < columns;j++){
            for(int i = 0;i<rows;i++){
                Item item = getItem(i,j);
                String token;

                if(item == null)token = "-";
                else token = Character.toString(item.getToken());
                tokens[i][j].setText(token);
                tokens[i][j].repaint();
                mainFrame.repaint();
            }
        }
    }

    /*
    Name: add
    Developers: Sheldon Benard
    Inputs: newItem, its x,y coordinate
    Purpose: Add item to the world; throw error if at a location already occupied
    */
    public void add(Item newItem, int x, int y) throws Exception{
        Item item = this.world[x][y];
        if (item != null)
            throw new Exception("Item already exists at specified position");
        this.world[x][y] = newItem;
    }

}
