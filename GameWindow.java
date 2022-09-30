import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    // константы, задающие размеры и расположение окна
    private static final int WND_WIDTH = 507;
    private static final int WND_HEIGHT = 555;
    private static final int WND_POSX = 650;
    private static final int WND_POSY = 250;

    private SettingsWindow settingsWnd;
    private GameField gameField;

    GameWindow() {
        // создаем окно, задаем размеры
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WND_WIDTH, WND_HEIGHT);
        setLocation(WND_POSX, WND_POSY);
        setTitle("Крестики - нолики");
        setResizable(false);
        // создаем кнопки "старт" и "стоп"
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnStop = new JButton("Конец игры");
        // создаем окно настроек игры (будет вызываться при щелчке на кнопке "старт")
        settingsWnd = new SettingsWindow(this);
        // добавляем "слушателей событий" для кнопок (обработка щелчков на кнопках)
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWnd.setVisible(true);
            }
        });
        // помещаем кнопки на панель, а панель в главное окно
        JPanel pnlButtons = new JPanel(new GridLayout(1, 2));
        pnlButtons.add(btnStart);
        pnlButtons.add(btnStop);
        add(pnlButtons, BorderLayout.SOUTH);
        // создаем игровое поле и помещаем его в главное окно
        gameField = new GameField();
        add(gameField);
        // выводим окно на экран
        setVisible(true);
    }
}
