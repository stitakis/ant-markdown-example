# Ant Markdown Example

Title:  Ant Markdown Example
Author: Sebastian Titakis
Date:   December 17, 2015

You'll find here following examples:

1. ant markdown4j integration example for Java 7 and Java 8: file `build.xml`
2. java markdown4j example: `Markown4jExample.java`
3. java Pegdown example: `PegDownExample.java`

Required dependencies are in located in the folder `libs`.

##### Note about Ant markdown4j integration

You'll find the example in the ant file 'build.xml'.
The example was implemented with javascript embedded in ant.
Please note that the javascript code are different for java 7 and java 8.
The code basically differ in the way the java classes are imported in javascript.
This is because java 7 use Rhino as js engine but java 8 use Nashorn.


