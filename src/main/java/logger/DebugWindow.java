package logger;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


//todo: logger in other thread for extra debug window and debug console
public class DebugWindow extends Thread {

    private JFrame frame;
    private JLabel label;
    private JScrollPane scrollPane;
    private List<String> messageList = new ArrayList<>();

    protected DebugWindow() {
        this.run();
    }

    @Override
    public void run() {
        frame = new JFrame();
        label = new JLabel();
        scrollPane = new JScrollPane(label);

        frame.setTitle("Debug Window");
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private int countLines  = 0 ;

    private void displayNewMessage(String message) {
        StringBuilder screenText = new StringBuilder(label.getText());
        if (screenText.isEmpty()) {
            screenText.append("<html>");
        } else {
            screenText.delete(screenText.length() - 7, screenText.length());
        }
        screenText.append(countLines)
                .append("&nbsp;&nbsp;&nbsp;")
                .append(message)
                .append("<br></html>");

        countLines++;

        label.setText(screenText.toString());

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }

    public void addMessage(String message) {
        this.messageList.add(message);
        this.displayNewMessage(message);
    }
}