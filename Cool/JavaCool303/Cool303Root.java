package JavaCool303;
import java.awt.*;

/**
 * <h1>Cool303Root</h1>
 * <b>File Name:</b> Cool303Root.java<br>
 * <b>Purpose:</b> Implement Cool303Root component <br>
 * <b>File I/O:</b> No files are required or generated by the application
 * @author Sheldon Benard
 */
public class Cool303Root extends Cool303ContainerComponent{
    //userDefined height and width;
    private int userHeight;
    private int userWidth;
    //keep track of minimum required height and width; to be used when figuring out sizing
    private int incrementalWidth;
    private int incrementalHeight;

    private final int BUFFER = 25; //add pixel buffer when adjusting root size: to ensure no overlap

    /**
     * <b>Name:</b> Cool303Root<br>
     * <b>Purpose:</b> Cool303Root constructor; provide theme<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @throws Exception if theme is null, exception thrown<br>
     * @param theme Cool303Theme strategy to be on in Cool303 objects
     *
     */
    public Cool303Root(Cool303Theme theme) throws Exception{
        if(theme == null)
            throw new Exception("Theme cannot be null in root");
        setTheme(theme);
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    /**
     * <b>Name:</b> setRootSize<br>
     * <b>Purpose:</b> Allow user to set the root size; will be used alongside adjust size to determine final size<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param width int desired width
     * @param height int desired height
     */
    public void setRootSize(int width, int height){
        this.userHeight = height;
        this.userWidth = width;

        //if userHeight and userWidth are greater than incremental height and width, then the
        //user defined dimensions are used. Else, incremental dimensions used
        int actualHeight = (userHeight > incrementalHeight) ? userHeight : incrementalHeight;
        int actualWidth = (userWidth > incrementalWidth) ? userWidth : incrementalWidth;

        //Augment by BUFFER, to ensure desired behaviour
        this.setPreferredSize(new Dimension(actualWidth + BUFFER,actualHeight + BUFFER));
    }

    //adjustSize will be the logic behind the automatic resizing if the user defined dimensions are too small
    private void adjustSize(Cool303Component component){
        //First, get component type
        String type = component.getClass().getSimpleName();
        Dimension dimension = new Dimension(0,0);

        if (type.equals("Cool303Button"))
            dimension = getTheme().getButtonPreferredSize();
        else if (type.equals("Cool303TextField"))
            dimension = getTheme().getTextFieldPreferredSize();
        else if (type.equals("Cool303Container"))
            dimension = getTheme().getContainerPreferredSize();

        //adjust incremental height; our application will yield a single row of roots, so adjust height by the max height of the components
        this.incrementalHeight = Math.max(incrementalHeight,(int)dimension.getHeight());
        //add dimension width to incrementalHeight
        this.incrementalWidth += (int)dimension.getWidth();

        //if userHeight and userWidth are greater than incremental height and width, then the
        //user defined dimensions are used. Else, incremental dimensions used
        int actualHeight = (userHeight > incrementalWidth) ? userHeight : incrementalHeight;
        int actualWidth = (userWidth > incrementalWidth) ? userWidth : incrementalWidth;

        //Augment by BUFFER, to ensure desired behaviour
        this.setPreferredSize(new Dimension(actualWidth + BUFFER,actualHeight + BUFFER));
    }

    /**
     * <b>Name:</b> add303Component<br>
     * <b>Purpose:</b> Add component to the root<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param component Cool303 component to be added
     */
    public void add303Component(Cool303Component component) {
        component.setTheme(getTheme());
        adjustSize(component);
        super.add303Component(component);
    }

    /**
     * <b>Name:</b> paintComponent<br>
     * <b>Purpose:</b> Override paintComponent<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param g Graphics used to paint component
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}