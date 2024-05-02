package logger;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


//todo: logger in other thread for extra debug window and debug console

public class DebugWindow extends  Thread{

    protected DebugWindow(){
        this.run();
    }

    JFrame frame;
    JLabel label;

    List<String> messageList = new ArrayList<>();


    public void run(){
        frame =  new JFrame();
        label   = new JLabel();


        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.add(label);



    }


    private void displayList(){
        StringBuilder screenText =  new StringBuilder();
        screenText.append("<html>");
        for(String raw  : messageList){
            screenText.append(raw).append("<br>");
        }
        screenText.append("</html>");
        label.setText(screenText.toString());

    }


    public void addMessage(String message){
        this.messageList.add(message);
        this.displayList();
    }

}
