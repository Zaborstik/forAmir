package src;

import javax.swing.*;
import java.awt.*;

public class Chart {

    public static void drawChart(int[] sizes, long[] times) {
        double[] sizesDouble = new double[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            sizesDouble[i] = sizes[i];
        }

        double[] timesDouble = new double[times.length];
        for (int i = 0; i < times.length; i++) {
            timesDouble[i] = times[i];
        }

        JFrame frame = new JFrame("График зависимости времени выполнения от размера файла");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                plotGraph(g, sizesDouble, timesDouble);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void plotGraph(Graphics g, double[] xData, double[] yData) {
        int padding = 50;
        int width = 700;
        int height = 500;
        int maxX = (int) xData[xData.length - 1];
        int maxY = (int) yData[yData.length - 1];

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width + 2 * padding, height + 2 * padding);

        g.setColor(Color.BLACK);
        g.drawLine(padding, padding, padding, height + padding);
        g.drawLine(padding, height + padding, width + padding, height + padding);

        double xScale = ((double) width - 2 * padding) / maxX;
        double yScale = ((double) height - 2 * padding) / maxY;

        // Нарисовать точки
        g.setColor(Color.RED);
        for (int i = 0; i < xData.length; i++) {
            int x = (int) (xData[i] * xScale + padding);
            int y = (int) (height - yData[i] * yScale + padding);
            g.fillOval(x - 2, y - 2, 4, 4);
        }

        // Нарисовать линии
        g.setColor(Color.BLUE);
        for (int i = 0; i < xData.length - 1; i++) {
            int x1 = (int) (xData[i] * xScale + padding);
            int y1 = (int) (height - yData[i] * yScale + padding);
            int x2 = (int) (xData[i + 1] * xScale + padding);
            int y2 = (int) (height - yData[i + 1] * yScale + padding);
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
