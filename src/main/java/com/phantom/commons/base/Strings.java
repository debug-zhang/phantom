/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.base;

import com.phantom.commons.collect.Arrays;

/**
 * Operations on {@link String} that are {@code null} safe.
 *
 * @author debug-zhang
 * @version Strings.java v 0.1 2021年12月25日0:12 debug-zhang
 * @see String
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

    /******************** Empty/Blank methods ********************/

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
     * Checks if a CharSequence is not empty (""), not null and not whitespace only.
     * <p>
     * Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is not empty and not null and not whitespace only
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }


    /**
     * Checks if any of the CharSequences are empty ("") or null.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if any of the CharSequences are empty or null
     */
    public static boolean isAnyEmpty(final CharSequence... css) {
        if (Arrays.isEmpty(css)) {
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
     * Checks if any of the CharSequences are empty ("") or null or whitespace only.
     * <p>
     * Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if any of the CharSequences are empty or null or whitespace only
     */
    public static boolean isAnyBlank(final CharSequence... css) {
        if (Arrays.isEmpty(css)) {
            return false;
        }
        for (final CharSequence cs : css) {
            if (isBlank(cs)) {
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
     * Checks if none of the CharSequences are empty (""), null or whitespace only.
     * <p>
     * Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if none of the CharSequences are empty or null or whitespace only
     */
    public static boolean isNoneBlank(final CharSequence... css) {
        return !isAnyBlank(css);
    }

    /**
     * Checks if all of the CharSequences are empty ("") or null.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if all of the CharSequences are empty or null
     */
    public static boolean isAllEmpty(final CharSequence... css) {
        if (Arrays.isEmpty(css)) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (isNotEmpty(cs)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all the CharSequences are empty (""), null or whitespace only.
     * <p>
     * Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * @param css the CharSequences to check, may be null or empty
     * @return {@code true} if all of the CharSequences are empty or null or whitespace only
     */
    public static boolean isAllBlank(final CharSequence... css) {
        if (Arrays.isEmpty(css)) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (isNotBlank(cs)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the first value in the array which is not empty.
     * <p>
     * If all values are empty or the array is {@code null}
     * or empty then {@code null} is returned.
     *
     * @param <T>    the specific kind of CharSequence
     * @param values the values to test, may be {@code null} or empty
     * @return the first value from {@code values} which is not empty,
     * or {@code null} if there are no non-empty values
     */
    @SafeVarargs
    public static <T extends CharSequence> T firstNonEmpty(final T... values) {
        if (values != null) {
            for (final T val : values) {
                if (isNotEmpty(val)) {
                    return val;
                }
            }
        }
        return null;
    }

    /**
     * Returns the first value in the array which is not empty (""),
     * {@code null} or whitespace only.
     * <p>
     * Whitespace is defined by {@link Character#isWhitespace(char)}.
     * <p>
     * If all values are blank or the array is {@code null}
     * or empty then {@code null} is returned.
     *
     * @param <T>    the specific kind of CharSequence
     * @param values the values to test, may be {@code null} or empty
     * @return the first value from {@code values} which is not blank,
     * or {@code null} if there are no non-blank values
     */
    @SafeVarargs
    public static <T extends CharSequence> T firstNonBlank(final T... values) {
        if (values != null) {
            for (final T val : values) {
                if (isNotBlank(val)) {
                    return val;
                }
            }
        }
        return null;
    }

    /******************** Contains methods ********************/

    public static boolean contains(final CharSequence seq, final int searchChar) {
        if (isEmpty(seq)) {
            return false;
        }
        return CharSequences.indexOf(seq, searchChar, 0) >= 0;
    }
}
