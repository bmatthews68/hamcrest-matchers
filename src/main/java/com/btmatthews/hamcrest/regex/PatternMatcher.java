/*
 * Copyright 2013 Brian Thomas Matthews
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.btmatthews.hamcrest.regex;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.not;

/**
 * A {@link Matcher} implementation that is used to check that a {@link String}
 * value matches or does not match a regular expression.
 *
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public final class PatternMatcher extends TypeSafeMatcher<String> {

    /**
     * The compiled regular expression.
     */
    private Pattern pattern;

    /**
     * Initialise the matcher by setting {@link String} as the expected type
     * and then compiling the regular expression.
     *
     * @param regex The regular expression.
     */
    private PatternMatcher(final String regex) {
        super(String.class);
        pattern = Pattern.compile(regex);
    }

    /**
     * A factory method that creates the matcher that verifies that a string
     * value does not match the regular
     * expression {@code regex}.
     *
     * @param regex The regular expression.
     * @return A {@link Matcher} object.
     */
    public static Matcher<String> matches(final String regex) {
        return new PatternMatcher(regex);
    }

    /**
     * A factory method that creates the matcher that verifies that a string
     * value does not match the regular expression {@code regex}.
     *
     * @param regex The regular expression.
     * @return A {@link Matcher} object.
     */
    public static Matcher<String> doesNotMatch(final String regex) {
        return not(matches(regex));
    }

    /**
     * Check that the string {@code value} matches the regular expression.
     *
     * @param value The string.
     * @return {@code true} if the string {@code value} matches the regular
     *         expression. Otherwise, {@code false}.
     */
    @Override
    public boolean matchesSafely(final String value) {
        return pattern.matcher(value).matches();
    }

    /**
     * Build a description of the matcher.
     *
     * @param description The description.
     */
    @Override
    public void describeTo(final Description description) {
        description
                .appendText("string should match ")
                .appendValue(pattern.pattern());
    }
}

