package com.example.lostincrowds;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

/**
 * The type Crowds unit test.
 */
public class CrowdsUnitTest {
    /**
     * Test add person.
     */
    @Test
    public void testAddPerson() {
        Crowds.addPerson("A");
        Crowds.addPerson("B");

        Set<String> keySet = new HashSet<>();
        keySet.add("A");
        keySet.add("B");

        assertEquals(keySet, Crowds.people.keySet());
        assertEquals(false,Crowds.people.get("A").indicator);
        Crowds.allClear();
    }

    /**
     * Test delete person.
     */
    @Test
    public void testDeletePerson() {
        Crowds.addPerson("A");
        Crowds.addPerson("B");
        Crowds.connect("A","B");
        Crowds.deletePerson("B");

        Set<String> set = new HashSet<>();
        set.add("A");

        assertEquals(set, Crowds.people.keySet());
        assertEquals(new HashSet<String>(), Crowds.people.get("A").linkedPerson);
        Crowds.allClear();
    }

    /**
     * Test connect.
     */
    @Test
    public void testConnect(){
        Crowds.addInfector("A");
        Crowds.addPerson("B");
        Crowds.addPerson("C");
        Crowds.connect("A","B");
        Crowds.connect("A","C");

        Set<String> set1 = new HashSet<>();
        set1.add("B");
        set1.add("C");

        Set<String> set2 = new HashSet<>();
        set2.add("A");

        float f = 100;

        assertEquals(set1, Crowds.people.get("A").linkedPerson);
        assertEquals(set2, Crowds.people.get("C").linkedPerson);
        assertEquals(100, Crowds.people.get("C").status,1);
        Crowds.allClear();
    }

    /**
     * Test simulation.
     */
    @Test
    public void testSimulation(){
        Crowds.addInfector("A");
        Crowds.addPerson("B");
        Crowds.addPerson("C");
        Crowds.connect("A","B");
        Crowds.connect("A","C");
        Crowds.connect("B","C");

        assertEquals(true,Crowds.simulateAll());
        Crowds.allClear();

        Crowds.addInfector("A");
        Crowds.addPerson("B");
        Crowds.addPerson("C");
        Crowds.connect("A","B");
        Crowds.connect("A","C");
        Crowds.connect("B","C");

        Crowds.contagion = 80;

        assertEquals(false,Crowds.simulateAll());
        Crowds.allClear();

    }


}