---
Author: "Julio Cesar Cruz Estrada"
date: 05/11/2025"
---

# Docx4j 6.1.4 Notes

Some notes in order to get the jar file.

## Base code

I use 6.1.2 version as base code because this is the most recent version
compatibly with my spring boot project.

## Update pom.xml

In this file only change the java compiler from 1.6 to 1.8

```xml
<!-- snipet -->
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
<!-- snipet -->
      <plugin>
	        <groupId>org.apache.maven.plugins</groupId>
          <!-- snipet -->
	              <rules>
	                <enforceBytecodeVersion>
	                  <maxJdkVersion>1.8</maxJdkVersion>
                </rules>
          <!-- snipet -->
      </plugin>
<!-- snipet -->
```
