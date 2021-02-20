package com.djt.MySnake.Entrance;

import com.djt.MySnake.Model.Snake;
import com.djt.MySnake.View.GameFrame;
import com.djt.MySnake.Controller.GamePanel;
import javax.swing.*;

public class Application{
    private static GameFrame frame;
    private static GamePanel panel;
    private static int longTimeMill = 250;
    private static int score = 0;
    private static boolean flag = true;
    private static double[] rank;
    private static int temp = 0;
    private static double totalTime = 0;

    public static void main(String[] args) {
        frame = new GameFrame();
        panel = new GamePanel();
        frame.addKeyListener(panel);
        frame.add(panel);
        rank = new double[10];
         while(flag){
             if (Snake.getHead().getState()){
                 try{
                     panel.repaintPanel();
                     Thread.sleep(longTimeMill);
                     totalTime = totalTime + 0.25;
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 if(score>150){
                     int value = JOptionPane.showConfirmDialog(null,"恭喜过关,本次用时"+totalTime+Rank()+",是否重开游戏？","游戏胜利",JOptionPane.YES_NO_OPTION);
                     if(value == JOptionPane.YES_OPTION){
                         newGame();
                         totalTime = 0;
                     }else{
                         System.exit(0);
                     }
                 }
             }else{
                 int value = JOptionPane.showConfirmDialog(null,"游戏结束,本局得分:"+score+",是否重开游戏？","游戏结束",JOptionPane.YES_NO_OPTION);
                 if(value == JOptionPane.YES_OPTION){
                     newGame();
                     totalTime = 0;
                 }else{
                     System.exit(0);
                 }
             }
         }
    }

    private static String Rank(){
        int position = 0;
        if(temp!=9){
            rank[temp] = totalTime;
            temp++;
            sortArray();
            for(int i=0;i<temp;i++){
                if (totalTime == rank[i]){
                    return "历史排名第"+(i+1);
                }
            }
        }else{
            if(totalTime>rank[temp]){
                return "未能刷新历史排行";
            }else{
                position = sortArray();
            }
        }
        return "历史排名第"+(position+1);
    }

    public static int sortArray(){
        int flag = 0;
        for(int i=0;i<temp;i++){
            if(rank[i]>=totalTime){
                flag = i;
                break;
            }
        }
        for(int i=flag;i<=temp;i++){
            rank[i+1] = rank[i];
        }
        rank[flag] = totalTime;
        return flag;
    }

    public static void newGame(){
        panel = new GamePanel();
        frame.add(panel);
        score = 0;
        Snake.getHead().setState(true);
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Application.score = score;
    }
}
