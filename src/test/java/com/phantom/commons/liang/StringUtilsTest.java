/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.liang;

import com.phantom.commons.lang.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author debug-zhang
 * @version StringUtilsTest.java v 0.1 2021年12月25日0:29 debug-zhang
 */
public class StringUtilsTest {

    @Test
    public void testIsEmpty() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty(" "));
        assertFalse(StringUtils.isEmpty("str"));
        assertFalse(StringUtils.isEmpty("  str  "));
    }

    @Test
    public void testIsNotEmpty() {
        assertFalse(StringUtils.isNotEmpty(null));
        assertFalse(StringUtils.isNotEmpty(""));
        assertTrue(StringUtils.isNotEmpty(" "));
        assertTrue(StringUtils.isNotEmpty("str"));
        assertTrue(StringUtils.isNotEmpty("  str  "));
    }

    @Test
    public void testIsAnyEmpty() {
        assertTrue(StringUtils.isAnyEmpty((String) null));
        assertFalse(StringUtils.isAnyEmpty((String[]) null));
        assertTrue(StringUtils.isAnyEmpty(null, "str"));
        assertTrue(StringUtils.isAnyEmpty("", "str"));
        assertTrue(StringUtils.isAnyEmpty("str", ""));
        assertTrue(StringUtils.isAnyEmpty("  str  ", null));
        assertFalse(StringUtils.isAnyEmpty(" ", "str"));
        assertFalse(StringUtils.isAnyEmpty("str1", "str2"));
        assertFalse(StringUtils.isAnyEmpty(new String[]{}));
        assertTrue(StringUtils.isAnyEmpty(new String[]{""}));
    }

    @Test
    public void testIsNoneEmpty() {
        assertFalse(StringUtils.isNoneEmpty((String) null));
        assertTrue(StringUtils.isNoneEmpty((String[]) null));
        assertFalse(StringUtils.isNoneEmpty(null, "str"));
        assertFalse(StringUtils.isNoneEmpty("", "str"));
        assertFalse(StringUtils.isNoneEmpty("str", ""));
        assertFalse(StringUtils.isNoneEmpty("  str  ", null));
        assertTrue(StringUtils.isNoneEmpty(" ", "str"));
        assertTrue(StringUtils.isNoneEmpty("str1", "str2"));
        assertTrue(StringUtils.isNoneEmpty(new String[]{}));
        assertFalse(StringUtils.isNoneEmpty(new String[]{""}));
    }

    @Test
    public void testIsAllEmpty() {
        assertTrue(StringUtils.isAllEmpty());
        assertTrue(StringUtils.isAllEmpty((String) null));
        assertTrue(StringUtils.isAllEmpty((String[]) null));
        assertFalse(StringUtils.isAllEmpty(null, "str"));
        assertFalse(StringUtils.isAllEmpty("", "str"));
        assertFalse(StringUtils.isAllEmpty("str", ""));
        assertFalse(StringUtils.isAllEmpty("  str  ", null));
        assertFalse(StringUtils.isAllEmpty(" ", "str"));
        assertFalse(StringUtils.isAllEmpty("str1", "str2"));
        assertTrue(StringUtils.isAllEmpty(new String[]{}));
        assertTrue(StringUtils.isAllEmpty(new String[]{""}));
    }
}
