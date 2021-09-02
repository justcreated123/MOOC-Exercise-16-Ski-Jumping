/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charizard
 */

import java.util.*;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int points;
    private ArrayList<Integer> lengths;
    
    public Jumper(String name) {
        this.name = name;
        this.lengths = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setPoints(int newPoints) {
        points += newPoints;
    }
    
    public void addLength(int length) {
        lengths.add(length);
    }
    
    public String getLengths() {
        String buffer = "";
        
        for (Integer length: lengths) {
            buffer += length + "m, ";
        }
        
        return buffer;
    }
    
    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }
    
    @Override
    public int compareTo(Jumper jumper) {
        return points - jumper.points;
    }
    
}
