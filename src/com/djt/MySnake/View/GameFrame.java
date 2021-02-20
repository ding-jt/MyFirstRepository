package com.djt.MySnake.View;

import javax.swing.*;

public class GameFrame extends JFrame{

    private static String version = "1.0";
    private static int Insets_Top = 30;
    private static int Insets_Bottom = 7;
    private static int Insets_Left = 7;
    private static int Insets_Right = 7;
    private static int contentWidth = 600;
    private  static int contentHeight = 600;
    private static int FrameWidth =  contentWidth+ Insets_Left + Insets_Right + 1;
    private static int FrameHeight = contentHeight+ Insets_Top + Insets_Bottom + 1;

    public GameFrame(){
        setTitle("贪吃蛇"+version);
        setSize(FrameWidth,FrameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
