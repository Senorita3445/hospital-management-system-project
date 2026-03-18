import javax.swing.*;
import java.awt.*;

public class GradientButton extends JButton {
    private Color color1 = new Color(255, 0, 0); // Start color
    private Color color2 = new Color(0, 0, 255); // End color

    public GradientButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        super.paintComponent(g);
    }
}