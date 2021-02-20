package com.djt.MySnake.Model;

import java.awt.*;

public class Node{

    private static int Width = 40;   //节点宽度
    private static int Height = 40;  //节点长度
    private int x;   //x坐标
    private int y;   //y坐标

    public Node(){
        this.x = getX();
        this.y = getY();
    }

    public Node(int x, int y,int width,int height) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x,y,Width,Height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
