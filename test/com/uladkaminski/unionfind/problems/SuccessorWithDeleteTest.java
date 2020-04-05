package com.uladkaminski.unionfind.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuccessorWithDeleteTest {

    private SuccessorWithDelete sut;

    @Before
    public void setUp() throws Exception {
        sut = new SuccessorWithDelete(10);
    }

    @Test
    public void findSuccessor() {
        sut.delete(3);
        sut.delete(4);
        sut.delete(5);

        assertEquals(6, sut.findSuccessor(3));
    }


    @Test
    public void findSuccessor_withoutDelete() {
        assertEquals(3, sut.findSuccessor(3));
        assertEquals(2, sut.findSuccessor(2));
        assertEquals(8, sut.findSuccessor(8));
        assertEquals(9, sut.findSuccessor(9));
    }

    @Test
    public void findSuccessor_perf() {
        sut = new SuccessorWithDelete(1000000001);
        long start = System.nanoTime();
        for (int i = 2; i <= 999999999; i++) {
            sut.delete(i);
        }
        long delete = System.nanoTime();
        System.out.println("Delete: " + (delete - start));
        assertEquals(1000000000, sut.findSuccessor(2));
        System.out.println("Find  : " + (System.nanoTime() - delete));

    }
}