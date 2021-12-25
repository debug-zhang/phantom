/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.base;

import org.testng.annotations.Test;

import static com.phantom.commons.base.Supplementary.*;
import static org.testng.Assert.*;

/**
 * Unit tests {@link com.phantom.commons.base.Strings}
 *
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

    /******************** Empty/Blank methods ********************/

    /**
     * Test for {@link Strings#isEmpty(CharSequence)}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(Strings.isEmpty(null));
        assertTrue(Strings.isEmpty(""));
        assertFalse(Strings.isEmpty(" "));
        assertFalse(Strings.isEmpty("str"));
        assertFalse(Strings.isEmpty("  str  "));
    }

    /**
     * Test for {@link Strings#isBlank(CharSequence)}.
     */
    @Test
    public void testIsBlank() {
        assertTrue(Strings.isBlank(null));
        assertTrue(Strings.isBlank(""));
        assertTrue(Strings.isBlank(WHITESPACE));
        assertFalse(Strings.isBlank("str"));
        assertFalse(Strings.isBlank("  str  "));
    }

    /**
     * Test for {@link Strings#isNotEmpty(CharSequence)}.
     */
    @Test
    public void testIsNotEmpty() {
        assertFalse(Strings.isNotEmpty(null));
        assertFalse(Strings.isNotEmpty(""));
        assertTrue(Strings.isNotEmpty(" "));
        assertTrue(Strings.isNotEmpty("str"));
        assertTrue(Strings.isNotEmpty("  str  "));
    }

    /**
     * Test for {@link Strings#isNotBlank(CharSequence)}.
     */
    @Test
    public void testIsNotBlank() {
        assertFalse(Strings.isNotBlank(null));
        assertFalse(Strings.isNotBlank(""));
        assertFalse(Strings.isNotBlank(" "));
        assertTrue(Strings.isNotBlank("str"));
        assertTrue(Strings.isNotBlank("  str  "));
    }

    /**
     * Test for {@link Strings#isAnyEmpty(CharSequence[])}.
     */
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

    /**
     * Test for {@link Strings#isAnyBlank(CharSequence[])}.
     */
    @Test
    public void testIsAnyBlank() {
        assertTrue(Strings.isAnyBlank((String) null));
        assertFalse(Strings.isAnyBlank((String[]) null));
        assertTrue(Strings.isAnyBlank(null, "str"));
        assertTrue(Strings.isAnyBlank("", "str"));
        assertTrue(Strings.isAnyBlank("str", ""));
        assertTrue(Strings.isAnyBlank("  str  ", null));
        assertTrue(Strings.isAnyBlank(" ", "str"));
        assertFalse(Strings.isAnyBlank("str1", "str2"));
        assertFalse(Strings.isAnyBlank(new String[]{}));
        assertTrue(Strings.isAnyBlank(new String[]{""}));
    }

    /**
     * Test for {@link Strings#isNoneEmpty(CharSequence[])}.
     */
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

    /**
     * Test for {@link Strings#isNoneBlank(CharSequence[])}.
     */
    @Test
    public void testIsNoneBlank() {
        assertFalse(Strings.isNoneBlank((String) null));
        assertTrue(Strings.isNoneBlank((String[]) null));
        assertFalse(Strings.isNoneBlank(null, "str"));
        assertFalse(Strings.isNoneBlank("", "str"));
        assertFalse(Strings.isNoneBlank("str", ""));
        assertFalse(Strings.isNoneBlank("  str  ", null));
        assertFalse(Strings.isNoneBlank(" ", "str"));
        assertTrue(Strings.isNoneBlank("str1", "str2"));
        assertTrue(Strings.isNoneBlank(new String[]{}));
        assertFalse(Strings.isNoneBlank(new String[]{""}));
    }

    /**
     * Test for {@link Strings#isAllEmpty(CharSequence[])}.
     */
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

    /**
     * Test for {@link Strings#isAllBlank(CharSequence[])}.
     */
    @Test
    public void testIsAllBlank() {
        assertTrue(Strings.isAllBlank());
        assertTrue(Strings.isAllBlank((String) null));
        assertTrue(Strings.isAllBlank((String[]) null));
        assertTrue(Strings.isAllBlank(null, " "));
        assertFalse(Strings.isAllBlank(null, "str"));
        assertFalse(Strings.isAllBlank("", "str"));
        assertFalse(Strings.isAllBlank("str", ""));
        assertFalse(Strings.isAllBlank("  str  ", null));
        assertFalse(Strings.isAllBlank(" ", "str"));
        assertFalse(Strings.isAllBlank("str1", "str2"));
        assertTrue(Strings.isAllBlank(new String[]{}));
        assertTrue(Strings.isAllBlank(new String[]{""}));
    }

    /**
     * Test for {@link Strings#firstNonEmpty(CharSequence[])}.
     */
    @Test
    public void testFirstNonEmpty() {
        assertNull(Strings.firstNonEmpty());
        assertNull(Strings.firstNonEmpty((String[]) null));
        assertNull(Strings.firstNonEmpty(null, null, null));
        assertEquals(" ", Strings.firstNonEmpty(null, "", " "));
        assertEquals(" ", Strings.firstNonEmpty(null, null, " "));
        assertEquals("abc", Strings.firstNonEmpty(null, "abc"));
        assertEquals("abc", Strings.firstNonEmpty("abc"));
        assertEquals("abc", Strings.firstNonEmpty(null, "abc"));
        assertEquals("xyz", Strings.firstNonEmpty(null, "xyz", "abc"));
    }

    /**
     * Test for {@link Strings#firstNonBlank(CharSequence[])}.
     */
    @Test
    public void testFirstNonBlank() {
        assertNull(Strings.firstNonBlank());
        assertNull(Strings.firstNonBlank((String[]) null));
        assertNull(Strings.firstNonBlank(null, null, null));
        assertNull(Strings.firstNonBlank(null, "", " "));
        assertNull(Strings.firstNonBlank(null, null, " "));
        assertEquals("abc", Strings.firstNonBlank(null, "abc"));
        assertEquals("abc", Strings.firstNonBlank("abc"));
        assertEquals("abc", Strings.firstNonBlank(null, "abc"));
        assertEquals("xyz", Strings.firstNonBlank(null, "xyz", "abc"));
    }

    /******************** Contains methods ********************/


    /**
     * Test for {@link Strings#contains(CharSequence, CharSequence)}.
     */
    @Test
    public void testContainsChar() {
        assertFalse(Strings.contains(null, ' '));
        assertFalse(Strings.contains("", ' '));
        assertFalse(Strings.contains("", null));
        assertFalse(Strings.contains(null, null));
        assertTrue(Strings.contains("abc", 'a'));
        assertTrue(Strings.contains("abc", 'b'));
        assertTrue(Strings.contains("abc", 'c'));
        assertFalse(Strings.contains("abc", 'z'));
    }

    /**
     * Test for {@link Strings#contains(CharSequence, CharSequence)}.
     */
    @Test
    public void testContainsString() {
        assertFalse(Strings.contains(null, null));
        assertFalse(Strings.contains(null, ""));
        assertFalse(Strings.contains(null, "a"));
        assertFalse(Strings.contains("", null));
        assertTrue(Strings.contains("", ""));
        assertFalse(Strings.contains("", "a"));
        assertTrue(Strings.contains("abc", "a"));
        assertTrue(Strings.contains("abc", "b"));
        assertTrue(Strings.contains("abc", "c"));
        assertTrue(Strings.contains("abc", "abc"));
        assertFalse(Strings.contains("abc", "z"));
    }

    /**
     * Test for {@link Strings#contains(CharSequence, CharSequence)}.
     */
    @Test
    public void testContainsStringWithBadSupplementaryChars() {
        // Test edge case: 1/2 of a (broken) supplementary char
        assertFalse(Strings.contains(CharUSuppCharHigh, CharU20001));
        assertFalse(Strings.contains(CharUSuppCharLow, CharU20001));
        assertFalse(Strings.contains(CharU20001, CharUSuppCharHigh));
        assertTrue(Strings.contains(CharU20001, CharUSuppCharLow));
        assertTrue(Strings.contains(CharU20001 + CharUSuppCharLow + "a", "a"));
        assertTrue(Strings.contains(CharU20001 + CharUSuppCharHigh + "a", "a"));
    }


    /**
     * Test for {@link Strings#contains(CharSequence, CharSequence)}.
     */
    @Test
    public void testContainsStringWithSupplementaryChars() {
        assertTrue(Strings.contains(CharU20000 + CharU20001, CharU20000));
        assertTrue(Strings.contains(CharU20000 + CharU20001, CharU20001));
        assertTrue(Strings.contains(CharU20000, CharU20000));
        assertFalse(Strings.contains(CharU20000, CharU20001));
    }
}
