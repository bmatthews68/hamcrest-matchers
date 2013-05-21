Hamcrest Matchers Library
=========================

The **Hamcrest Matchers Library** provides additional Matcher implementations
that work with [Hamcrest](https://code.google.com/p/hamcrest/) for use in
checking the results of operations being unit tested.

Pattern Matching
----------------
* matches - tests that the value matches a regular expression
* doesNotMatch - tests that a value does not match a regular expression

```java
import static org.hamcrest.MatcherAssert.assertThat;
import static com.btmatthews.hamcrest.PatternMatcher.matches;

import org.junit.Test;

class TestPatternMatching {

  @Test
  public void idStringIsNumeric() {
    final Biscuit biscuit = new Biscuit("1234", "Custard Cream"));
    assertThat("id string is numeric", biscuit.getId(), matches("\\d+"));
  }
}
```

Maven Central Coordinates
-------------------------
The **Hamcrest Matchers Library** has been published in
[Maven Central](http://search.maven.org) at the following coordinates:

```xml
<dependency>
    <groupId>com.btmatthews.hamcrest</groupId>
    <artifactId>hamcrest-matchers</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>
```

License & Source Code
---------------------
The **Hamcrest Matchers Library** is made available under the
[Apache License](http://www.apache.org/licenses/LICENSE-2.0.html)
and the source code is hosted on [GitHub](http://github.com) at
https://github.com/bmatthews68/hamcrest-matchers.