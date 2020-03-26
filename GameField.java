import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;
    int CELLS_COUNT = 3; // нужно получить из окна настроек игры

    GameField() {
        //setBackground(Color.BLUE);
    }

    public void startNewGame() {
        //
    }

    // рисуем сетку на поле
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // получаем размеры ячеек
        int w = this.getWidth();
        int horizontalCellSize = w / CELLS_COUNT;
        int h = this.getHeight();
        int verticalCellSize = h / CELLS_COUNT;
        for (int i = 0; i < CELLS_COUNT; i++) {
            // горизонтальные линии
            g.drawLine(0, i * verticalCellSize, w, i * verticalCellSize);
            // вертикальные линии
            g.drawLine(i * horizontalCellSize, 0, i * horizontalCellSize, h);
        }
    }
}
