package com.djt.MySnake.Controller;

import com.djt.MySnake.Entrance.Application;
import com.djt.MySnake.Model.Direction;
import com.djt.MySnake.Model.Food;
import com.djt.MySnake.Model.Node;
import com.djt.MySnake.Model.Snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener{

    private static int Insets_Top = 30;
    private static int Insets_Bottom = 7;
    private static int Insets_Left = 7;
    private static int Insets_Right = 7;
    private static int contentWidth = 600;
    private  static int contentHeight = 600;
    private static int PanelWidth =  contentWidth+ Insets_Left + Insets_Right + 1;
    private static int PanelHeight = contentHeight+ Insets_Top + Insets_Bottom + 1;
    private static Food food;
    private static Snake snake;
    private static boolean pause = false;

    public GamePanel(){
        snake = new Snake();
        food = new Food();
        setBackground(Color.green);
        setSize(PanelWidth,PanelHeight);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i=0;i<=PanelHeight/40;i++){
            g.drawLine(0,40*i,PanelWidth,40*i);
            g.drawLine(40*i,0,40*i,PanelHeight);
        }
        snake.drawSnake(g);
        food.draw(g);
    }

    public void repaintPanel(){
        Thread thread = new Thread(() ->{
            if(!pause){
               Node node = snake.move();
                if (eat()){
                    snake.getList().add(node);
                }
                isGameOver();
                repaint();
            }
        });
        thread.start();
    }

    public void isGameOver(){
        //蛇头是否出界
        if(snake.getHead().getX()<0|snake.getHead().getX()>PanelWidth|
           snake.getHead().getY()<0|snake.getHead().getY()>PanelHeight){
            snake.getHead().setState(false);
        }
        Node head = snake.getList().getFirst();
        //蛇头是否碰撞蛇身
        for (int i=1;i<snake.getList().size()-1;i++){
            if (head.getX() == snake.getList().get(i).getX()&&head.getY() == snake.getList().get(i).getY()){
                snake.getHead().setState(false);
            }
        }
    }

    public boolean eat(){
       if (snake.getHead().getX()==food.getX()&&snake.getHead().getY()==food.getY()) {
           food.create();
           Application.setScore(Application.getScore()+1);
           return true;
       }
       return false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
       switch (keyEvent.getKeyCode()){
           case KeyEvent.VK_UP:
               if(snake.getHead().getDirection()!=Direction.DOWN)
                  snake.getHead().setDirection(Direction.UP);
               break;
           case KeyEvent.VK_DOWN:
               if(snake.getHead().getDirection()!=Direction.UP)
                 snake.getHead().setDirection(Direction.DOWN);
               break;
           case KeyEvent.VK_LEFT:
               if(snake.getHead().getDirection()!=Direction.RIGHT)
                 snake.getHead().setDirection(Direction.LEFT);
               break;
           case KeyEvent.VK_RIGHT:
               if(snake.getHead().getDirection()!=Direction.LEFT)
                 snake.getHead().setDirection(Direction.RIGHT);
               break;
           case KeyEvent.VK_SPACE:
               pause = !pause;
               break;
       }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
