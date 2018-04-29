Designed Patters:

    Singleton (World.java):
        World.java was designed with the singleton design pattern in mind; the private constructor, createWorld, and getInstance
        ensure only one static World instance exists. createWorld(rows,columns) and getInstance() are both used instead of
        using just the getInstance(rows,columns), since I don't want to have to specify the rows and columns for
        each getInstance call; further, simply overloading getInstance wouldn't be as clear than splitting up the creation (createWorld) and
        the getting (getInstance)

    Composite (Stepable.java -> World.java, Item.java):
        Stepable is the interface on which the composite pattern is based; the composite, World, has a step()
        function which, in turn, calls the step() function of the Item family (Immovable, Moveable, Autonomous)

Some well-designed features:
    Item is an abstract class, since an item must be either Autonomous, Moveable, or Immovable; defining it so allows for similar code for
    each of the children to be in one place: the Item class

    Instead of new logic for the Autonomous.step class, a step can be thought of as a 'bump' by an invisible force.
    So, Autonomous.step randomly picks a new move (the force) and calls super.bump (saves recoding for step and bump)

    Comments as documentation

    Exception usage prevents items from moving outside the world or an item being bumped outside the world.
