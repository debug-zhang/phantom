/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.liang;

import com.phantom.commons.lang.Strings;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author debug-zhang
 * @version StringsTest.java v 0.1 2021年12月25日0:29 debug-zhang
 */
public class StringsTest {

    static final String WHITESPACE;

    static {
        final StringBuilder ws = new StringBuilder();
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            if (Character.isWhitespace((char) i)) {
                ws.append((char) i);
            }
        }
        WHITESPACE = " ";
    }

    @Test
    public void testIsEmpty() {
        assertTrue(Strings.isEmpty(null));
        assertTrue(Strings.isEmpty(""));
        assertFalse(Strings.isEmpty(" "));
        assertFalse(Strings.isEmpty("str"));
        assertFalse(Strings.isEmpty("  str  "));
    }

    @Test
    public void testIsBlank() {
        assertTrue(Strings.isBlank(null));
        assertTrue(Strings.isBlank(""));
        assertTrue(Strings.isBlank(WHITESPACE));
        assertFalse(Strings.isBlank("str"));
        assertFalse(Strings.isBlank("  str  "));
    }

    @Test
    public void testIsNotEmpty() {
        assertFalse(Strings.isNotEmpty(null));
        assertFalse(Strings.isNotEmpty(""));
        assertTrue(Strings.isNotEmpty(" "));
        assertTrue(Strings.isNotEmpty("str"));
        assertTrue(Strings.isNotEmpty("  str  "));
    }

    @Test
    public void testIsAnyEmpty() {
        assertTrue(Strings.isAnyEmpty((String) null));
        assertFalse(Strings.isAnyEmpty((String[]) null));
        assertTrue(Strings.isAnyEmpty(null, "str"));
        assertTrue(Strings.isAnyEmpty("", "str"));
        assertTrue(Strings.isAnyEmpty("str", ""));
        assertTrue(Strings.isAnyEmpty("  str  ", null));
        assertFalse(Strings.isAnyEmpty(" ", "str"));
        assertFalse(Strings.isAnyEmpty("str1", "str2"));
        assertFalse(Strings.isAnyEmpty(new String[]{}));
        assertTrue(Strings.isAnyEmpty(new String[]{""}));
    }

    @Test
    public void testIsNoneEmpty() {
        assertFalse(Strings.isNoneEmpty((String) null));
        assertTrue(Strings.isNoneEmpty((String[]) null));
        assertFalse(Strings.isNoneEmpty(null, "str"));
        assertFalse(Strings.isNoneEmpty("", "str"));
        assertFalse(Strings.isNoneEmpty("str", ""));
        assertFalse(Strings.isNoneEmpty("  str  ", null));
        assertTrue(Strings.isNoneEmpty(" ", "str"));
        assertTrue(Strings.isNoneEmpty("str1", "str2"));
        assertTrue(Strings.isNoneEmpty(new String[]{}));
        assertFalse(Strings.isNoneEmpty(new String[]{""}));
    }

    @Test
    public void testIsAllEmpty() {
        assertTrue(Strings.isAllEmpty());
        assertTrue(Strings.isAllEmpty((String) null));
        assertTrue(Strings.isAllEmpty((String[]) null));
        assertFalse(Strings.isAllEmpty(null, "str"));
        assertFalse(Strings.isAllEmpty("", "str"));
        assertFalse(Strings.isAllEmpty("str", ""));
        assertFalse(Strings.isAllEmpty("  str  ", null));
        assertFalse(Strings.isAllEmpty(" ", "str"));
        assertFalse(Strings.isAllEmpty("str1", "str2"));
        assertTrue(Strings.isAllEmpty(new String[]{}));
        assertTrue(Strings.isAllEmpty(new String[]{""}));
    }
}
