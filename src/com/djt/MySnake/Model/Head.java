package com.djt.MySnake.Model;

import java.awt.*;

public class Head extends Node{
    private static int headWidth = 40;
    private static int headHeight = 40;
    private int x;
    private int y;
    private Direction direction;   //蛇头方向 0:up,1:down,2:left,3:right
    private static boolean state;  //是否存活

    public Head(){
        this.x = 7*headWidth;
        this.y = 7*headHeight;
        this.direction = Direction.UP;
        this.state = true;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.x,this.y,headWidth,headHeight);
    }

    public Node moveHead(){
        Node node = new Node();
        node.setX(this.x);
        node.setY(this.y);
        switch(getDirection()){
            case UP:
                this.y=this.y-40;
                break;
            case DOWN:
                this.y=this.y+40;
                break;
            case LEFT:
                this.x=this.x-40;
                break;
            case RIGHT:
                this.x=this.x+40;
                break;
        }
        return node;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
