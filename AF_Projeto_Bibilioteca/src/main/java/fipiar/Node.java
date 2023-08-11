/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fipiar;

/**
 *
 * @author marco
 */
public class Node {

    private int intValue;
    private String string1;
    private String string2;
    Node left;
    Node right;

    public Node(int intValue, String string1, String string2) {
        this.intValue = intValue;
        this.string1 = string1;
        this.string2 = string2;
        this.left = null;
        this.right = null;
    }


    public int getIntValue() {
        return intValue;
    }

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }
}


