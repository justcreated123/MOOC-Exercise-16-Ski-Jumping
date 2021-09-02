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

public class UI {
    public UI() {
        List<Jumper> jumpers = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Kumpula ski jumping week" + '\n');
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        System.out.print("   Participant name: ");
        String name = reader.nextLine();
        addName(name, jumpers, reader);
        
        System.out.println('\n' + "The tournament begins!");
        System.out.print('\n' + "Write \"jump\" to jump; otherwise you quit: ");
        String cmd = reader.nextLine();
        
        int i = 1;
        
        while (true) {
            if (!cmd.equalsIgnoreCase("jump")) {
                System.out.println('\n' + "Thanks!");
                System.out.println('\n' + "Tournament results:");
                System.out.println("Position    Name");
                
                int j = 1;
                
                for (Jumper jumper: jumpers) {
                    System.out.println(j + "           " + jumper);
                    System.out.println("            jump lengths: " + jumper.getLengths());
                    j++;
                }
                
                break;
            }
            
            System.out.println('\n' + "Round " + i);
            System.out.println('\n' + "Jumping order: ");

            for (Jumper jumper: jumpers) {
                System.out.println(jumper);
            }
            
            System.out.println('\n' + "Results of round " + i);
            results(jumpers);

            System.out.print('\n' + "Write \"jump\" to jump; otherwise you quit: ");
            cmd = reader.nextLine();
            i++;
        }
    }
    
    public void addName(String name, List jumpers, Scanner reader) {
        jumpers.add(new Jumper(name));
        
        while (!name.equals("")) { 
            System.out.print("   Participant name: ");
            name = reader.nextLine();
            if (name.equals("")) {
                break;
            } else {
                jumpers.add(new Jumper(name));
            }
        }
    }
    
    public ArrayList<Integer> randomNumbers(Random random) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(11) + 10;
            list.add(num);
        }
        
        return list;
    }
    
    public int sum(ArrayList<Integer> list) {
        int sum = 0;
        
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        
        return sum;
    }
    
    public void results(List<Jumper> jumpers) {

        Random random = new Random();
        
        for (Jumper jumper: jumpers) {
            System.out.println("  " + jumper.getName());
            int length = random.nextInt(61) + 60;
            System.out.println("     length: " + length);
            jumper.addLength(length);

            ArrayList list = randomNumbers(random);
            System.out.println("     judge votes: " + list);
            Collections.sort(list);
            list.remove(4);
            list.remove(0);
            int points = sum(list);
            int sumOfPoints = length + points;

            jumper.setPoints(sumOfPoints);
        }
    }
        
}
