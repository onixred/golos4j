# golos4j
Library for interaction with golos

# Compatibility
* Java 8+

# Official Telegram API 
[![Jitpack](https://jitpack.io/v/onixred/golos4j.svg)](https://jitpack.io/#onixred/golos4j)
# how to use an alternative version of the project
    
Just add the library to your project with one of these options:

  1. Using Maven Central Repository:

```xml
		<dependency>
			<groupId>ru.maksimov.andrey</groupId>
			<artifactId>golos4j</artifactId>
			<version>0.0.41</version>
		</dependency>

	<!-- Maven Repository on Git-BitBucket -->
		<repositories>
			<repository>
				<releases>
					<enabled>false</enabled>
				</releases>
				<snapshots>
					<enabled>true</enabled>
				</snapshots>
				<id>snapshots</id>
				<url>https://api.bitbucket.org/1.0/repositories/onixred/maven-repo/raw/snapshots</url>
			</repository>
			<repository>
				<releases>
					<enabled>true</enabled>
				</releases>
				<snapshots>
					<enabled>false</enabled>
				</snapshots>
				<id>releases</id>
				<url>https://api.bitbucket.org/1.0/repositories/onixred/maven-repo/raw/releases</url>
			</repository>
		</repositories>
```




# Properties (settings)
* default url node https://ws.golos.io

# Library documentation
 [wiki](https://github.com/onixred/golos4j/wiki)
 [New JavaDocs](https://onixred.bitbucket.io/golos4j/apidocs/)
 [Old JavaDocs](https://onixred.github.io/golos4j)


# Build and test
mvn package (local assembly)
For the assembly and testing of software we use the resource travis-ci.org.
https://travis-ci.org/onixred/golos4j


# Релиз новой версии
mvn clean release:prepare release:perform
выпуск javadoc deploy--javadoc.bat

# Старый вариант
mvn deploy заливка на git-hub
отмена коммита  git reset --hard HEAD^


