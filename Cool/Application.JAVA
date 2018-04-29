import JavaCool303.*;
import javax.swing.*;
import java.awt.*;

//Sample application (not included in javadocs)
public class Application {
    public static void main(String[] args){
        //define JFrame and JPanel as content pane for jFrame
        JFrame mainFrame = new JFrame();
        JPanel contentPanel = new JPanel();

        mainFrame.setContentPane(contentPanel);
        contentPanel.setLayout(new FlowLayout());

        //Add the buttons as per application description (ADJUST THEME HERE)
        add303NumericalComponents(contentPanel,new Summer(), 1,2,10);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack(); //very important to pack the frame
        mainFrame.setVisible(true);
    }

    //Helper: programmatically add the roots, containers, and buttons;
    private static void add303NumericalComponents(JPanel contentPanel, Cool303Theme theme, int numRoots, int containersPerRoot, int buttonsPerContainer){
        int counter = 0;
        try {
            for (int i = 0; i < numRoots; i++) {
                Cool303Root root = new Cool303Root(theme); //create root with the theme
                for(int j = 0; j < containersPerRoot;j++){
                    Cool303Container container = new Cool303Container("Click a Button!",new Color(225,247,213)); //NOTE: Some themes may not use defined color
                    root.add303Component(container); //add container to root
                    for(int k = 0; k < buttonsPerContainer; k++){
                        container.add303Component(new Cool303Button(Integer.toString(counter))); //add buttons to containers
                        counter++;
                    }
                }
                contentPanel.add(root); //add root to contentPanel
            }
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }



    }


}
