/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.collect;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author debug-zhang
 * @version Arrays.java v 0.1 2021年12月25日1:40 debug-zhang
 */
public class ArraysTest {

    /**
     * Test for {@link Arrays#getLength(java.lang.Object)}.
     */
    @Test
    public void testGetLength() {
        assertEquals(0, Arrays.getLength(null));

        final Object[] emptyObjectArray = {};
        final Object[] notEmptyObjectArray = {"object"};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyObjectArray));
        assertEquals(1, Arrays.getLength(notEmptyObjectArray));

        final int[] emptyIntArray = {};
        final int[] notEmptyIntArray = {1};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyIntArray));
        assertEquals(1, Arrays.getLength(notEmptyIntArray));

        final short[] emptyShortArray = {};
        final short[] notEmptyShortArray = {1};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyShortArray));
        assertEquals(1, Arrays.getLength(notEmptyShortArray));

        final char[] emptyCharArray = {};
        final char[] notEmptyCharArray = {1};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyCharArray));
        assertEquals(1, Arrays.getLength(notEmptyCharArray));

        final byte[] emptyByteArray = {};
        final byte[] notEmptyByteArray = {1};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyByteArray));
        assertEquals(1, Arrays.getLength(notEmptyByteArray));

        final double[] emptyDoubleArray = {};
        final double[] notEmptyDoubleArray = {1.0};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyDoubleArray));
        assertEquals(1, Arrays.getLength(notEmptyDoubleArray));

        final float[] emptyFloatArray = {};
        final float[] notEmptyFloatArray = {1.0F};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyFloatArray));
        assertEquals(1, Arrays.getLength(notEmptyFloatArray));

        final boolean[] emptyBooleanArray = {};
        final boolean[] notEmptyBooleanArray = {true};
        assertEquals(0, Arrays.getLength(null));
        assertEquals(0, Arrays.getLength(emptyBooleanArray));
        assertEquals(1, Arrays.getLength(notEmptyBooleanArray));

        assertThrows(IllegalArgumentException.class, () -> Arrays.getLength("notAnArray"));
    }

    /**
     * Test for {@link Arrays#isEmpty(java.lang.Object[])}.
     */
    @Test
    public void testIsEmptyObject() {
        final Object[] emptyArray = {};
        final Object[] notEmptyArray = {"Value"};
        assertTrue(Arrays.isEmpty((Object[]) null));
        assertTrue(Arrays.isEmpty(emptyArray));
        assertFalse(Arrays.isEmpty(notEmptyArray));
    }
}
