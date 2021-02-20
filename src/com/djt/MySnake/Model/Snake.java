package com.djt.MySnake.Model;

import java.awt.*;
import java.util.LinkedList;

public class Snake{

    private static Head head;
    private static LinkedList<Node> list;

    public Snake() {
        this.list = new LinkedList();
        this.head = new Head();
        this.list.add(head);
    }

    public void drawSnake(Graphics g){
        for (Node node:list){
            node.draw(g);
        }
    }

    public Node move(){
        Node node = new Node();
        if (list.size() != 1){
            list.add(1,new Node(head.getX(),head.getY(), 40,40));
            node = list.getLast();
            list.removeLast();
        }
        node = head.moveHead();
        return node;
    }

    public static Head getHead() {
        return head;
    }

    public static LinkedList<Node> getList() {
        return list;
    }
}
