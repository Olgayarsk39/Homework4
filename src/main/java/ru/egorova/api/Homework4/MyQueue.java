package ru.egorova.api.Homework4;


import java.util.LinkedList;

public class MyQueue {
    private LinkedList elements = new LinkedList();

    public MyQueue() { }
    public MyQueue(LinkedList linkedList) {
        this.elements = linkedList;
    }

    public void encueue(Object element){
        elements.add(element);
    }

    public Object dequeue(){
        Object first = elements.getFirst();
        elements.removeFirst();
        return first;
    }

    public Object first(){
        return elements.getFirst();
    }

    public LinkedList getElements(){
        return elements;
    }

    public void setElements(MyQueue linkedList){
        this.elements = elements;
    }

}
