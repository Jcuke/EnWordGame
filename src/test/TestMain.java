/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author Administrator
 */
public class TestMain {
    public static void main(String[] args) {
        String s = "w";
        s = s.replaceFirst(String.valueOf(s.charAt(0)), "");
        System.out.println(s);
        //System.out.println(s.substring(1, s.length()));
    }
}
