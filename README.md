# Java Unit Testing

## Getting Started

### Maven Setup

Start with this initial `pom.xml`:

```xml
<project>
    <modelVersion>4.0.0</modelVersion>
		     
    <groupId>org.spilth</groupId>
    <artifactId>testing</artifactId>
    <version>1.0.0-SNAPSHOT</version>

    <name>Testing</name>
    <description>A project to show off Java Unit Testing</description>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
</project>
```

## Unit Testing Libraries

### [JUnit 5](https://junit.org/junit5/)

#### Maven Confugration

Add the following sections to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.6.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
    
<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.2</version>
        </plugin>
    </plugins>
</build>
```

#### Usage Example

Create the file `src/test/java/org/example/PigLatinJUnitTest.java`:

```java
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PigLatinJUnitTest {
    @Test
    void itConvertsEnglishToPigLatin() {
        PigLatin translator = new PigLatin();

        String actual = translator.translate("apple");

        assertEquals("appleway", actual);
        
        // Or
        assertEquals("appleway", translator.translate("apple"));
    }
}
```

*Note: The PigLatin implementation is left as an exercise for the reader.*

#### Resources

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
 
### [AssertJ](https://assertj.github.io/doc/)

#### Maven Dependency

Add the following to the `<dependencies>` in your `pom.xml`:

```xml
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.16.1</version>
    <scope>test</scope>
</dependency>
```

#### Example Usage

Create the file `src/test/java/org/example/PigLatinAssertJTest.java`:

```java
package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PigLatinAssertJTest {
    @Test
    void itConvertsEnglishToPigLatin() {
        PigLatin translator = new PigLatin();

        String actual = translator.translate("apple");

        assertThat(actual).isEqualTo("appleway");
        
        // Or
        assertThat(translator.translate("apple")).isEqualTo("appleway");
    }
}
```

### [Hamcrest](https://github.com/hamcrest/JavaHamcrest)

#### Maven Configuration

Add the following to the `<dependencies>` in your `pom.xml`:

```xml
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest</artifactId>
    <version>2.2</version>
    <scope>test</scope>
</dependency>
```

#### Example Usage

Create the file `src/test/java/org/example/PigLatinHamcrestTest.java`:

```java
package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PigLatinHamcrestTest {
    @Test
    void itConvertsEnglishToPigLatin() {
        PigLatin translator = new PigLatin();

        String actual = translator.translate("apple");

        assertThat("appleway", equalTo(actual));

        // Or
        assertThat("appleway", equalTo(translator.translate("apple")));

        // Or
        assertThat("appleway", is(equalTo(actual)));

        // Or
        assertThat("appleway", is(equalTo(translator.translate("apple"))));
    }
}
```


### [Mockito](https://site.mockito.org/)

#### Maven Configuration

Add the following to the `<dependencies>` in your `pom.xml`:

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.3.3</version>
    <scope>test</scope>
</dependency>
```

#### Example Usage

Create the file `src/test/java/org/example/GetTranslationTest.java`:

```java
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import spark.Request;
import spark.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class GetTranslationTest {
    private GetTranslation getTranslation;

    @Mock
    PigLatin pigLatin;

    @Mock
    private Request request;

    @Mock
    private Response response;

    @BeforeEach
    void setup() {
        initMocks(this);

        getTranslation = new GetTranslation(pigLatin);
    }

    @Test
    void handle() {
        when(request.queryParams("english")).thenReturn("apple");
        when(pigLatin.translate("apple")).thenReturn("appleway");

        Object result = getTranslation.handle(request, response);

        assertThat(result).isInstanceOfAny(String.class);
        assertThat(result).isEqualTo("appleway");
    }
}
```

### [JSONassert](https://github.com/skyscreamer/JSONassert)

#### Maven Configuration

Add the following to the `<dependencies>` in your `pom.xml`:

```xml
<dependency>
    <groupId>org.skyscreamer</groupId>
    <artifactId>jsonassert</artifactId>
    <version>1.5.0</version>
    <scope>test</scope>
</dependency>
```

### [JsonPath](https://github.com/jayway/JsonPath)

#### Maven Configuration

Add the following to the `<dependencies>` in your `pom.xml`:

```xml
<dependency>
    <groupId>com.jayway.jsonpath</groupId>
    <artifactId>json-path</artifactId>
    <version>2.4.0</version>
</dependency>
```
