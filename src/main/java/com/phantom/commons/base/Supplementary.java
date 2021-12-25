/*
 * Copyright (c) 2021-2021 All Rights Reserved.
 */
package com.phantom.commons.base;

/**
 * Supplementary character test fixtures.
 * <p>
 * See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
 *
 * @author debug-zhang
 * @version Supplementary.java v 0.1 2021年12月25日15:06 debug-zhang
 */
public class Supplementary {

    /**
     * Supplementary character U+20000 See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    static final String CharU20000 = "\uD840\uDC00";

    /**
     * Supplementary character U+20001 See http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    static final String CharU20001 = "\uD840\uDC01";

    /**
     * Incomplete supplementary character U+20000, high surrogate only. See
     * http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    static final String CharUSuppCharHigh = "\uDC00";

    /**
     * Incomplete supplementary character U+20000, low surrogate only. See
     * http://www.oracle.com/technetwork/articles/javase/supplementary-142654.html
     */
    static final String CharUSuppCharLow = "\uD840";
}
