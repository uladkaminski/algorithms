package com.uladkaminski.unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedQuickUnionTest {

    private UnionFind sut;

    @Before
    public void setUp() {
        sut = new BalancedQuickUnion(25);
    }

    @Test
    public void union() {
        assertFalse(sut.isConnected(1,2));
        sut.union(1,2);
        assertTrue(sut.isConnected(1,2));
    }

    @Test
    public void isConnected_Reflective() {
        assertTrue(sut.isConnected(1,1));
    }

    @Test
    public void isConnected_Transitive() {
        sut.union(1, 2);

        assertTrue(sut.isConnected(1,2));
        assertTrue(sut.isConnected(2,1));
    }

    @Test
    public void isConnected_Symmetric() {
        sut.union(1, 2);
        sut.union(2, 3);

        assertTrue(sut.isConnected(1,3));
    }

}