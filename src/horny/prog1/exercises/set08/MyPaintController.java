package horny.prog1.exercises.set08;

import javafx.util.Pair;
import rl.util.painttool.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 *
 * @author Ruediger Lunde
 *
 */
public class MyPaintController extends AbstractController
{
    private ArrayList<Point> GivenValues;
    private ArrayList<Point> CalculatedValues;
    /** Returns "Paint Demo". */
    @Override
    public String getTitle() {
        return "Linear Regression Paint Demo";
    }

    /** Returns the names of three buttons. */
    @Override
    public String[] getButtonNames() {
        return new String[] { "Perform Linear Regression" };
    }

    /**
     * Depending on the button number, some random shapes are drawn, a red cross
     * is popped up for some moments, or a dialog box is shown.
     */
    @Override
    public void onButtonPressed(PaintTool ptool, int button) {
        int cWidth = ptool.getCanvas().getWidth();
        int cHeight = ptool.getCanvas().getHeight();
        switch (button) {
            case 0:
                ptool.clearCanvas();
                RegressionCalculator calculator = new RegressionCalculator();
                Pair<ArrayList<Point>, ArrayList<Point>> allPoints = new Pair<>(null, null);
                allPoints = calculator.startProg();
                ptool.setColor(Color.RED);
                for(Point point : allPoints.getKey())
                {
                    DrawableObject obj = ptool.addCircle((int) point.GetX() * 40, cHeight - (int) point.GetY() * 2, 2, true);
                }
                for (Point point : allPoints.getValue())
                {
                    DrawableObject obj = ptool.addCircle((int) point.GetX() * 40, cHeight - (int) point.GetY() * 2, 2, true);
                }
                int i = ptool.getDrawableObjects().size();
                int x = ptool.getDrawableObjects().get(i - 1).getX();
                int y = ptool.getDrawableObjects().get(i - 1).getY();
                ptool.setColor(Color.BLUE);
                DrawableObject obj = ptool
                        .addLine(0, cHeight, x, y);
                ptool.sleep(200);
            default:
                break;
        }
    }

    /**
     * Prints a text on the canvas at the point where the click was done. It
     * describes the state of the mouse.
     */
    @Override
    public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
                             boolean isShiftDown, boolean isControlDown) {
        ptool.setColor(Color.MAGENTA);
        ptool.addText(x, y, "Click at (" + x + ", " + y + "): " + mouseButton
                + " " + isShiftDown + " " + isControlDown);
    }
}
