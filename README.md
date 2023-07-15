## CheckStyle

Get abstract syntax tree for a class

```
java -jar custom-checkstyle/lib/checkstyle-10.12.1-all.jar -T static-analysis/src/main/java/com/jeanneboyarsky/staticanalysis/Denver.java 
```

UI for loading files and expanding/collapsing parts of tree.

```
java -cp custom-checkstyle/lib/checkstyle-10.12.1-all.jar com.puppycrawl.tools.checkstyle.gui.Main
```

Run at command line for ease in debugging

```
java -cp "static-analysis/generated-libs/custom-checkstyle-1.0-SNAPSHOT.jar:custom-checkstyle/lib/checkstyle-10.12.1-all.jar" com.puppycrawl.tools.checkstyle.Main -c static-analysis/config/checkstyle/checkstyle.xml static-analysis
```

## Spotbugs

Just code. See subproject

## PMD

Open rule designer (Note need to download javafx first https://gluonhq.com/products/javafx/)

```
export JAVAFX_HOME="/Library/Java/JavaFx/javafx-sdk-20.0.1"
custom-pmd/lib/bin/pmd designer 
```


