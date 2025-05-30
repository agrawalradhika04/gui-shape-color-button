// Followed a similar pattern as Q3 (Traffic Lights) on Finals

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;       
import java.awt.geom.*;
import java.util.*;

public class ShapeAndColorButton{
    public static void main(String[] args){
        EventQueue.invokeLater(()-> {
            JFrame f = new ShapeFrame();
            f.setTitle("Shape and Color Buttons");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}

class ShapeFrame extends JFrame{
    private JPanel buttonPanel;
    private DrawPanel drawPanel;
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 900;

    boolean showRectangle = false;
    boolean showSquare = false;
    boolean showCircle = false;
    Color color = Color.BLACK;

    public ShapeFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new DrawPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        drawPanel = new DrawPanel();

        JButton rectangleButton = new JButton("Rectangle");
        JButton squareButton = new JButton("Square");
        JButton circleButton = new JButton("Circle");
        JButton redButton = new JButton("Red");
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");

        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);

        buttonPanel.add(rectangleButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(circleButton);

        buttonPanel.add(new JPanel());
        buttonPanel.add(drawPanel);
        buttonPanel.add(new JPanel());

        rectangleButton.addActionListener(new rectangleAction());
        squareButton.addActionListener(new squareAction());
        circleButton.addActionListener(new circleAction());
        redButton.addActionListener(new redAction());
        yellowButton.addActionListener(new yellowAction());
        blueButton.addActionListener(new blueAction());

        add(buttonPanel);
    }

    class rectangleAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            showRectangle = true;
            showSquare = false;
            showCircle = false;
            repaint();
        }
    }

    class squareAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            showRectangle = false;
            showSquare = true;
            showCircle = false;
            repaint();
        }
    }

    class circleAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            showRectangle = false;
            showSquare = false;
            showCircle = true;
            repaint();
        }
    }

    class redAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            color = Color.RED;
            repaint();
        }
    }

    class yellowAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            color = Color.YELLOW;
            repaint();
        }
    }

    class blueAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            color = Color.BLUE;
            repaint();
        }
    }

    class DrawPanel extends JPanel{
        public DrawPanel(){
            setPreferredSize(new Dimension(00, 300));
        }

        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(color);

            if(showRectangle){
                Rectangle2D rectangle = new Rectangle2D.Double(50, 50, 200, 100);
                g2.fill(rectangle);
            }
            if(showSquare){
                Rectangle2D square = new Rectangle2D.Double(50, 50, 150, 150);
                g2.fill(square);
            }
            if(showCircle){
                Ellipse2D circle = new Ellipse2D.Double(50, 50, 150, 150);
                g2.fill(circle);
            }
        }
    }

}
            