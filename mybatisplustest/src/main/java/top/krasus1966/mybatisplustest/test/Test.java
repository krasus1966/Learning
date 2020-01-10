package top.krasus1966.mybatisplustest.test;

import java.util.*;
public class Test {
    public static void main(String[] args) {
        LinkedList  list=new  LinkedList();
        list.add("A");
        list.add(2,"B");
        String s=(String)list.get(1);
        System.out.println(s);
    }
}