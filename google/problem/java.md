### Double
- when check equal, do not use '=='
- but use 
```java
private final static double EPSILON = 0.00001;
if (x + EPSILON > 0 && x - EPSILON < 0){
...
}
```
