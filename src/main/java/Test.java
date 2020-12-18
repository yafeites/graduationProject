import Java.frame;
import Java.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * @author 汪一江
 * @Destriction
 * @Date 2020/11/3
 */
public class Test {
    private static void createAndShowGUI() {
//         确保一个漂亮的外观风格
//        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        frame frame = new frame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello World" 标签
//        JLabel label = new JLabel("Hello World");
//        label.setLocation(frame.getX()/2,frame.getY()/2);
//        frame.getContentPane().add(label);
//        ScrollPane scrollPane=new ScrollPane();
//        scrollPane.setLocation(50,50);
////        scrollPane.se
//        scrollPane.add(new TextField("ScrollPane"));


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
        frame.setTitle("Cells");
        panel panel=new panel(frame);
//        panel.add(new Button("i am a button"));
//        panel.setSize(2000,2000);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
