package com.ben.aoc.tree;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    protected T data;
    protected Node<T> parent;
    protected List<Node<T>> children;

    public Node(T data){
        this.children = new LinkedList<>();
        this.data = data;
    }

    public Node<T> addChild(T child){
        Node<T> childNode = new Node<>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }


    public Node<T> getParent(){
        return parent;
    }

    public T getData(){
        return data;
    }

    public List<Node<T>> getChildren(){
        return children;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(!(o instanceof Node n)){
            return false;
        }
        return n.data.equals(data);
    }

    @Override
    public int hashCode(){ return data.hashCode();}

}
