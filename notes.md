---
author: "Julio Cesar Cruz Estrada"
date: "05/11/2025"
---

# Docx4j 6.1.4 Notes

Some notes in order to get the jar file.

## Base code

I use 6.1.2 version as base code because this is the most recent version
compatibly with my spring boot project.

## Update pom.xml

In this file only change the maven compiler plugin from 1.6 to 1.8

```xml
<!-- snippet -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>2.3.2</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
 					<verbose>false</verbose>
				</configuration>
			</plugin>
<!-- snippet -->
      <plugin>
	        <groupId>org.apache.maven.plugins</groupId>
          <!-- snippet -->
	              <rules>
	                <enforceBytecodeVersion>
	                  <maxJdkVersion>1.8</maxJdkVersion>
                </rules>
          <!-- snippet -->
      </plugin>
<!-- snippet -->
```

## Add Namespaces

I just replace the file [NamespacePrefixMappings.java](src/main/java/org/docx4j/jaxb/NamespacePrefixMappings.java)
with the same you can find in version 8.3.15

> [!NOTE]
> I don´t have to do any changes to this code.

## Get the jar file

In a terminal execute the next code to get the jar file

```bash
mvn clean install -DskipTests
```

If you don´t want a local installation, you can use this command.

```bash
mvn clean package -DskipTests
```

With `DskipTests` flag I skip test. Unfortunately, test always return error when compile
without this flag.

> [!IMPORTANT]
> When I imported this project to Eclipse IDE appear a lot of errors.
> I solved all of them, but when I want to generate the jar file, compilation always fail.
> For this reason I recommend **to not** make more changes or try to solve this weird errors.
