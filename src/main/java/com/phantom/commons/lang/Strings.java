/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.lang;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author debug-zhang
 * @version Strings.java v 0.1 2021年12月25日0:12 debug-zhang
 */
public class Strings {

    /**
     * A String for a space character.
     */
    public static final String SPACE = " ";

    /**
     * The empty String {@code ""}.
     */
    public static final String EMPTY = "";

    /**
     * A String for linefeed LF ("\n").
     */
    public static final String LF = "\n";

    /**
     * A String for carriage return CR ("\r").
     */
    public static final String CR = "\r";

    /**
     * Represents a failed index search.
     */
    public static final int INDEX_NOT_FOUND = -1;

    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    /**
     * Checks if a CharSequence is empty ("") or null.
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is empty or null
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * Checks if a CharSequence is empty (""), null or whitespace only.
     * <p>
     * <Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace only
     */
    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a CharSequence is not empty ("") and not null.
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is not empty and not null
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }


    /**
     * Checks if any of the CharSequences are empty ("") or null.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if any of the CharSequences are empty or null
     */
    public static boolean isAnyEmpty(final CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return false;
        }
        for (final CharSequence cs : css) {
            if (isEmpty(cs)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if none of the CharSequences are empty ("") or null.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if none of the CharSequences are empty or null
     */
    public static boolean isNoneEmpty(final CharSequence... css) {
        return !isAnyEmpty(css);
    }

    /**
     * Checks if all of the CharSequences are empty ("") or null.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if all of the CharSequences are empty or null
     */
    public static boolean isAllEmpty(final CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (isNotEmpty(cs)) {
                return false;
            }
        }
        return true;
    }
}
