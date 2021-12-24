/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.collect;

import java.lang.reflect.Array;

/**
 * @author debug-zhang
 * @version Arrays.java v 0.1 2021年12月25日1:30 debug-zhang
 */
public class Arrays {

    /**
     * Returns the length of the specified array.
     * This method can deal with {@code Object} arrays and with primitive arrays.
     * <p>
     * If the input array is {@code null}, {@code 0} is returned.
     *
     * @param array the array to retrieve the length from, may be null
     * @return The length of the array, or {@code 0} if the array is {@code null}
     * @throws IllegalArgumentException if the object argument is not an array.
     */
    public static int getLength(final Object array) {
        return array == null ? 0 : Array.getLength(array);
    }

    /**
     * Checks if an array of Objects is empty or {@code null}.
     *
     * @param array  the array to test
     * @return {@code true} if the array is empty or {@code null}
     */
    public static boolean isEmpty(final Object[] array) {
        return getLength(array) == 0;
    }
}
