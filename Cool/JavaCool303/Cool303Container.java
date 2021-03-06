package JavaCool303;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * <h1>Cool303Container</h1>
 * <b>File Name:</b> Cool303Container.java<br>
 * <b>Purpose:</b> Implement Cool303Container component <br>
 * <b>File I/O:</b> No files are required or generated by the application
 * @author Sheldon Benard
 */
public class Cool303Container extends Cool303ContainerComponent{

    /**
     * <b>Name:</b> Cool303Container<br>
     * <b>Purpose:</b> Cool303Container constructor<br>
     * <b>Author:</b> Sheldon Benard<br>
     */
    public Cool303Container(){setLayout(new FlowLayout());}

    /**
     * <b>Name:</b> Cool303Container<br>
     * <b>Purpose:</b> Cool303Container constructor<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param title Cool303Container title
     */
    public Cool303Container(String title){
        setLayout(new FlowLayout());
        setTitle(title);
    }

    /**
     * <b>Name:</b> Cool303Container<br>
     * <b>Purpose:</b> Cool303Container constructor<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param color Cool303Container background color
     */
    public Cool303Container(Color color){
        setLayout(new FlowLayout());
        setColor(color);
    }

    /**
     * <b>Name:</b> Cool303Container<br>
     * <b>Purpose:</b> Cool303Container constructor<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param title Cool303Container title
     * @param color Cool303Container background color
     */
    public Cool303Container(String title, Color color){
        setLayout(new FlowLayout());
        setColor(color);
        setTitle(title);
    }

    /**
     * <b>Name:</b> setTitle<br>
     * <b>Purpose:</b> set Cool303Container title<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param title String for container's title
     */
    public void setTitle(String title){
        Border empty = BorderFactory.createEmptyBorder();
        TitledBorder border = new TitledBorder(empty,title);
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.LEFT);
        border.setTitleFont( border.getTitleFont().deriveFont(Font.BOLD));
        this.setBorder(border);
    }

    /**
     * <b>Name:</b> setTheme<br>
     * <b>Purpose:</b> set Cool303Container theme<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param theme Cool303Theme for container
     */
    public void setTheme(Cool303Theme theme) {
        super.setTheme(theme);
        this.setPreferredSize(theme.getContainerPreferredSize());
        for(Cool303Component component: super.get303Components())
            component.setTheme(theme);
    }

    /**
     * <b>Name:</b> paintComponent<br>
     * <b>Purpose:</b> Override paintComponent<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param g Graphics used to paint component
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(getTheme() != null)
            getTheme().paintContainer(this,g);
        this.repaint();
        this.revalidate();
    }

}
