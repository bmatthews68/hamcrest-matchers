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
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.Mock;

import static com.btmatthews.hamcrest.regex.PatternMatcher.doesNotMatch;
import static com.btmatthews.hamcrest.regex.PatternMatcher.matches;
import static org.hamcrest.CoreMatchers.not;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Unit tests for {@link PatternMatcher}.
 *
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public class TestPatternMatcher {

    /**
     * Aggregates multiple failures within the {@link #checkMatches()} and
     * {@link #checkDoesNotMatch()} test cases.
     */
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    /**
     * Mock the {@link Description} object used in the
     * {@link #checkDescribeTo()} test case.
     */
    @Mock
    private Description description;

    /**
     * Prepare for test case execution by intialising the mock objects.
     */
    @Before
    public void setup() {
        initMocks(this);
    }

    /**
     * Verify the behaviour of {@link PatternMatcher#matches(String)}.
     */
    @Test
    public void checkMatches() {
        collector.checkThat(null, not(matches("\\d")));
        collector.checkThat("1", matches("\\d"));
        collector.checkThat("a", not(matches("\\d")));
    }

    /**
     * Verify the behaviour of {@link PatternMatcher#doesNotMatch(String)}.
     */
    @Test
    public void checkDoesNotMatch() {
        collector.checkThat(null, doesNotMatch("\\d"));
        collector.checkThat("1", not(doesNotMatch("\\d")));
        collector.checkThat("a", doesNotMatch("\\d"));
    }

    /**
     * Verify the behaviour of{@link PatternMatcher#describeTo(Description)}.
     */
    @Test
    public void checkDescribeTo() {
        when(description.appendText(anyString())).thenReturn(description);
        final Matcher<String> matcher = PatternMatcher.matches("\\d");
        matcher.describeTo(description);
        verify(description).appendText(eq("string should match "));
        verify(description).appendValue(eq("\\d"));
    }
}
