# JSteuernummer

Validate german tax numbers and convert them to country wide schema 

See also https://de.wikipedia.org/wiki/Steuernummer#Aufbau_der_Steuernummer

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## Build

Just install it with maven
```
mvn clean install
```

## Howto

### Maven

Snapshots (Repository http://oss.sonatype.org/content/repositories/snapshots)

```xml
<dependency>
    <groupId>de.kaffeekrone</groupId>
    <artifactId>jsteuernummer</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```


### Usage
```java
        
        Steuernummer.of("151/815/08156", Region.TH);
        Steuernummer.of("02/815/08156").getRegion();

```

