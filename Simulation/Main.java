/*
File Name: Main.java
Developers: Sheldon Benard
Purpose: Contains main method for executing simulation
Input,Output: None
 */
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    /*
    Name: main
    Developers: Sheldon Benard
    Inputs: Command-line args (NOT USED)
    Purpose: main method for executing simulation
    */
    public static void main(String[] args){
        World world = buildWorld();
        world.display(); //display initial world
        do{
            int max_iterations = 100;
            for(int i = 0; i<max_iterations;i++){
                //Sleep for readability; adjust if needed
                try{
                    TimeUnit.MILLISECONDS.sleep(200);
                }catch (Exception e){}

                world.step(); // Iterate through the world once
                world.display();
            }


        }while(askUserToRepeat().equals("yes")); // 'yes' to repeat; 'no' to end
        System.exit(0);
    }

    /*
    Name: buildWorld
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Build the (swing) world and add the items to the world
    */
    private static World buildWorld(){
        World world = World.createWorld(10,10); //10x10 world
        world.buildWorldDisplay(); //create Swing world display

        //Add 5 immovable items
        Immovable[] immovable = new Immovable[5];
        immovable[0] = new Immovable("Tree1",'T',1,1);
        immovable[1] = new Immovable("Tree2",'T',3,2);
        immovable[2] = new Immovable("Tree3",'T',5,6);
        immovable[3] = new Immovable("Tree4",'T',9,9);
        immovable[4] = new Immovable("Tree5",'T',7,2);

        addItems(world, immovable);

        //Add 3 moveable items
        Moveable[] movable = new Moveable[3];
        movable[0] = new Moveable("Rabbit1",'R',2,3);
        movable[1] = new Moveable("Rabbit2",'R',5,5);
        movable[2] = new Moveable("Rabbit3",'R',8,2);

        addItems(world,movable);

        //Add 2 autonomous items
        Autonomous[] autonomous = new Autonomous[2];
        autonomous[0] = new Autonomous("Wolf1",'W',3,7);
        autonomous[1] = new Autonomous("Wolf2",'W',7,3);

        addItems(world,autonomous);

        return world;
    }

    /*
    Name: addItems
    Developers: Sheldon Benard
    Inputs: World object, Array of Items to add
    Purpose: Helper: add all items in array to world
    */
    private static void addItems(World world, Item[] items){
        for(Item item: items){
            int[] coordinates = item.getCoordinates();
            try {
                world.add(item, coordinates[0], coordinates[1]);
            }catch(Exception e){
                System.out.println("Error adding items into world");
                System.exit(-1);
            }
        }
    }

    /*
    Name: askUserToRepeat
    Developers: Sheldon Benard
    Inputs: None
    Purpose: Helper: ask for user input to repeat the simulation
    */
    private static String askUserToRepeat(){
        Scanner scan = new Scanner(System.in);
        String input = null;

        do{
            System.out.print("Would you like to run the simulation again? Answer 'yes' or 'no':");
            String in = scan.nextLine();
            if(in.matches("(no|yes)"))
                input = in;
        }while(input == null);

        return input;
    }


}
