package com.djt.MySnake.Model;

import java.awt.*;
import java.util.Random;

public class Food extends Node{

    private int foodWidth =40;
    private int foodHeight = 40;
    private int x;
    private int y;

    public Food(){
        create();
    }

    public void create(){
        boolean flag = true;
        Random random = new Random();
        int x,y;
        while(flag){
            x = random.nextInt(15) * 40;
            y = random.nextInt(15) * 40;
            for(int i=0;i<Snake.getList().size();i++){
                if(Snake.getList().get(i).getX() == x&&Snake.getList().get(i).getY() == y){
                    break;
                }else{
                    if(i==Snake.getList().size()-1){
                        this.x = x;
                        this.y = y;
                        flag = false;
                    }
                }
            }
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect( x, y, foodWidth, foodHeight);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
