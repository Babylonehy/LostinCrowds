
/******************************************************************************
 * Copyright (c) 2019. Taichi Aso From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// This is just a draft of the inside logic.
// The structure might have to be changed later on.
// Considering the case there is only one infected person now.

/**
 * The type Crowds.
 */
public class Crowds {

    /**
     * The constant contagion.
     */
    public static int contagion = 33;

    /**
     * The constant people.
     */
    public static HashMap<String, Node> people = new HashMap<>();

    /**
     * The type Node.
     */
    static class Node{
        /**
         * The Indicator.
         */
        Boolean indicator;
        /**
         * The Status.
         */
        float status;        // infected percentage the people has
        /**
         * The Linked person.
         */
        Set<String> linkedPerson;  // the list the person is connected to

        /**
         * Instantiates a new Node.
         *
         * @param indicator    the indicator
         * @param status       the status
         * @param linkedPerson the linked person
         */
        Node(Boolean indicator, float status, Set<String> linkedPerson){
            this.indicator=indicator;
            this.status=status;
            this.linkedPerson=linkedPerson;
        }

    }

    /**
     * Add person.
     *
     * @param s the s
     */
    public static void addPerson(String s){
        Node node = new Node(false,0, new HashSet<String>());
        people.put(s, node);
    }

    /**
     * Add infector.
     *
     * @param s the s
     */
    public static void addInfector(String s){
        Node node = new Node(true,0, new HashSet<String>());
        people.put(s, node);
    }


    /**
     * Delete person.
     *
     * @param s the s
     */
    public static void deletePerson(String s){
        if(people.containsKey(s)){
            Node node = people.get(s);
            people.remove(s);
            for(String p : node.linkedPerson){
                Node n = people.get(p);
                n.linkedPerson.remove(s);
            }
            update();
        }
    }

    /**
     * Connect.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     */
// links two people
    public static void connect(String s1, String s2){
        Node n1 = people.get(s1);
        n1.linkedPerson.add(s2);
        Node n2 = people.get(s2);
        n2.linkedPerson.add(s1);
        update();
    }

    /**
     * Cutoff.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     */
// cut the link
    public static void cutoff(String s1, String s2){
        Node n1 = people.get(s1);
        n1.linkedPerson.remove(s2);
        Node n2 = people.get(s2);
        n2.linkedPerson.remove(s1);
        update();
    }

    /**
     * Update.
     */
// updates the status
    public static void update(){
        Set<String> infectedPeople = getInfectedPeople();
        for(String key:infectedPeople){
            for(String s:people.get(key).linkedPerson){
                Node node = people.get(s);
                int size = node.linkedPerson.size();
                if(size==0){}
                else if(!node.indicator){
                    int countIndicator = getCount(node.linkedPerson);
                    node.status = (100*countIndicator)/size;
                }else{
                    int countIndicator = getCount(node.linkedPerson);
                    node.status = (countIndicator*100)/size;
                }
            }
        }

        for(String key:people.keySet()){
            if(!people.get(key).indicator){
                int count=0;
                for(String s:people.get(key).linkedPerson){
                    if(infectedPeople.contains(s)){
                        count++;
                    }
                }
                if(count==0){
                    people.get(key).status=0;
                }
            }
        }
    }

    /**
     * All clear.
     */
    public static void allClear(){
        people = new HashMap<>();
    }

    /**
     * Get count int.
     *
     * @param set the set
     * @return the int
     */
// gets the number of infected people in a set
    public static int getCount(Set<String> set){
        int count = 0;
        for(String key:set){
           if(people.get(key).indicator){
               count++;
           }
        }
        return count;
    }

    /**
     * Get percentage float.
     *
     * @param s the s
     * @return the float
     */
    public static float getPercentage(String s){
        return people.get(s).status;
    }


    /**
     * Get infected people set.
     *
     * @return the set
     */
// gets infected people as a set in a dictionary
    public static Set<String> getInfectedPeople(){
        Set set = new HashSet<String>();
        for(String key:people.keySet()){
            if(people.get(key).indicator){
                set.add(key);
            }
        }
        return set;
    }

    /**
     * Is all infected boolean.
     *
     * @return the boolean
     */
// checks its all infected or not
    public static boolean isAllInfected(){
        return getInfectedPeople().size()==people.size();
    }


    /**
     * Simulation hash map.
     *
     * @return the hash map
     */
// simulates only one movement, and returns a map showing which infected person infects which person
    public static HashMap<String,String> simulation(){
        Set<String> infectedPeople = getInfectedPeople();
        HashMap<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String s1:infectedPeople){
            for(String s2:people.get(s1).linkedPerson){
                Node node = people.get(s2);
                if(!node.indicator&&node.status>=contagion){
                    node.indicator=true;
                    update();
                    set.add(s2);
                    map.put(s2,s2);
                }else if(set.contains(s2)){
                    map.put(s2,s2);
                }
            }
        }
        return map;
    }

    /**
     * Simulate all boolean.
     *
     * @return the boolean
     */
// simulates all node as long as its possible, and return True if all people were infected
    public static boolean simulateAll(){
        while(simulation().size()!=0){}

        if(isAllInfected()){
            return true;
        }else{
            return false;
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        com.example.lostincrowds.Crowds crowds = new Crowds();

        crowds.addInfector("I1");
        crowds.addInfector("I2");

        crowds.addPerson("A");
        crowds.addPerson("B");
        crowds.addPerson("C");


        crowds.connect("I1","A");
        //crowds.connect("I2","A");
        crowds.connect("B","A");
        crowds.connect("A","C");


        //simulateAll();

        for (String key:crowds.people.keySet()){
            System.out.println(key+": "+crowds.people.get(key).indicator+", "+crowds.people.get(key).status+", "+crowds.people.get(key).linkedPerson);
        }
        System.out.println("\n"+"simulate "+simulation()+"\n");

        for (String key:crowds.people.keySet()){
            System.out.println(key+": "+crowds.people.get(key).indicator+", "+crowds.people.get(key).status+", "+crowds.people.get(key).linkedPerson);
        }
        System.out.println("\n"+"simulate "+simulation()+"\n");

        for (String key:crowds.people.keySet()){
            System.out.println(key+": "+crowds.people.get(key).indicator+", "+crowds.people.get(key).status+", "+crowds.people.get(key).linkedPerson);
        }
        System.out.println("\n"+"simulate "+simulation()+"\n");


    }

}
