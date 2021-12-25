/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.base;

/**
 * Operations on {@link CharSequence} that are {@code null} safe.
 *
 * @author debug-zhang
 * @version CharSequences.java v 0.1 2021年12月25日10:26 debug-zhang
 * @see CharSequence
 */
public class CharSequences {

    /**
     * Represents a failed index search.
     */
    private static final int NOT_FOUND = -1;

    /**
     * Returns the index within {@code cs} of the first occurrence of the
     * specified character, starting the search at the specified index.
     * <p>
     * If a character with value {@code searchChar} occurs in the
     * character sequence represented by the {@code cs}
     * object at an index no smaller than {@code start}, then
     * the index of the first such occurrence is returned. For values
     * of {@code searchChar} in the range from 0 to 0xFFFF (inclusive),
     * this is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote>
     * is true. For other values of {@code searchChar}, it is the
     * smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote>
     * is true. In either case, if no such character occurs inm {@code cs}
     * at or after position {@code start}, then
     * {@code -1} is returned.
     *
     * <p>
     * There is no restriction on the value of {@code start}. If it
     * is negative, it has the same effect as if it were zero: the entire
     * {@code CharSequence} may be searched. If it is greater than
     * the length of {@code cs}, it has the same effect as if it were
     * equal to the length of {@code cs}: {@code -1} is returned.
     * <p>
     * All indices are specified in {@code char} values (Unicode code units).
     *
     * @param cs         the {@code CharSequence} to be processed, not null
     * @param searchChar the char to be searched for
     * @param start      the start index, negative starts at the string start
     * @return the index where the search char was found, -1 if not found
     */
    static int indexOf(final CharSequence cs, final int searchChar, int start) {
        if (cs instanceof String) {
            return ((String) cs).indexOf(searchChar, start);
        }

        final int sz = cs.length();
        if (start < 0) {
            start = 0;
        }

        if (searchChar < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
            for (int i = start; i < sz; i++) {
                if (cs.charAt(i) == searchChar) {
                    return i;
                }
            }
            return NOT_FOUND;
        }

        // supplementary characters (LANG1300)
        if (searchChar <= Character.MAX_CODE_POINT) {
            final char[] chars = Character.toChars(searchChar);
            for (int i = start; i < sz - 1; i++) {
                final char high = cs.charAt(i);
                final char low = cs.charAt(i + 1);
                if (high == chars[0] && low == chars[1]) {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }
}
