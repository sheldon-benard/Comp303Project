package JavaCool303;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * <h1>Pastel</h1>
 * <b>File Name:</b> Pastel.java<br>
 * <b>Purpose:</b> Implement Cool303Theme and provide a theme strategy <br>
 * <b>File I/O:</b> No files are required or generated by the application
 * @author Sheldon Benard
 */
public class Pastel implements Cool303Theme {

    /**
     * <b>Name:</b> getButtonPreferredSize<br>
     * <b>Purpose:</b> Define the preferred size of button objects<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @return Dimension of button
     */
    @Override
    public Dimension getButtonPreferredSize() {return new Dimension(125,75);}

    /**
     * <b>Name:</b> getContainerPreferredSize<br>
     * <b>Purpose:</b> Define the preferred size of container objects<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @return Dimension of container
     */
    @Override
    public Dimension getContainerPreferredSize() {
        return new Dimension(400,400);
    }

    /**
     * <b>Name:</b> getTextFieldPreferredSize<br>
     * <b>Purpose:</b> Define the preferred size of text field objects<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @return Dimension of textfield
     */
    @Override
    public Dimension getTextFieldPreferredSize() {
        return new Dimension(50,25);
    }

    /**
     * <b>Name:</b> paintButton<br>
     * <b>Purpose:</b> Customize button; button.getText() can be used to get button text<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param button paintButton that user defined; g Graphics - used to paint
     */
    @Override
    public void paintButton(Cool303Button button, Graphics g) {
        Dimension dimension = getButtonPreferredSize();

        //get dimensions
        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();
        int length = button.getText().length()-1;

        //hide old button
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(0,0,0,0));

        //draw new button and new button label
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(new Color(201,201,255));
        g2.fillRoundRect(0,0,width,height,25,25);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        g2.drawString(button.getText(),width/2-2-5*length,height/2+5);


    }

    /**
     * <b>Name:</b> paintTextField <br>
     * <b>Purpose:</b> Customize textField; textField.getText() can be used to get textField text<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param textField Cool303TextField that user defined; g Graphics - used to paint
     */
    @Override
    public void paintTextField(Cool303TextField textField, Graphics g) {
        Dimension dimension = getTextFieldPreferredSize();

        //get dimension
        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();
        int length = textField.getText().length();

        //hide old text field
        textField.setOpaque(false);
        textField.setBorder(new EmptyBorder(0,0,0,0));

        //Draw new text field and label
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(241,203,255));
        g2.fillRoundRect(0,0,width,height,25,25);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        g2.drawString(textField.getText(),width/2-3*length,height/2+5);
    }

    /**
     * <b>Name:</b> paintContainer<br>
     * <b>Purpose:</b> Customize container; container.getColor() can be used to get container color set during construction<br>
     * <b>Author:</b> Sheldon Benard<br>
     * @param container Cool303Container that user defined; g Graphics - used to paint
     */
    @Override
    public void paintContainer(Cool303Container container, Graphics g) {
        Dimension dimension = getContainerPreferredSize();

        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();

        //if color is defined, draw roundRect using that color; else invisible background
        if (container.getColor() != null) {
            container.setOpaque(false);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(container.getColor());
            g2.fillRoundRect(0, 0, width, height, 20, 20);
        }

    }
}
