# TinyJ

This is a programming language which I wrote in **Java** for my CS316 (Principles of Programming Languages) course. Its a simplified version of Java, where only a small subset of programming rules and grammar is supported. This project taught me how programming languages are made as well as how they run in memory.

## What I Learned

* Learned how to create EBNF Rules to create this programming language.
* Implemented a Parser which uses the EBNF rules to validate the syntax of the code provided. 
* Learned how to create a virtual machine which is used to execute virtual machine instruction. 
* Created virtual machine instructions.
* Learned how programming languages, for the most part, is implemented and managed in memory.

## Example

```java
class SomeClass {
  static int x = 17, y = -3, z = (x + y) * (x - y) / (x*x - y*y);

  public static void main (String argv[])
  {
    System.out.print("292 / 8 = ");
    System.out.println((x*x - y) / (x-y*y));
    System.out.print("289 % 9 = ");
    System.out.println(x * y / y * x % (y * y));
    System.out.print("1 = ");
    System.out.println(z);
    System.out.print("17 = ");
    System.out.println(x);
    System.out.print("-3 = ");
    System.out.println(y);
    System.out.print("-17 = ");
    System.out.println(-x);
    System.out.print("-3 = ");
    System.out.println(-3);
    System.out.println("How did I do?");
  }
}
```

`java -cp . TJasn.TJ SomeClass.java debug.out`

**Output:**
```
****** Execution begins ...
292 / 8 = 36
289 % 9 = 1
1 = 1
17 = 17
-3 = -3
-17 = -17
-3 = -3
How did I do?

****** Execution ended normally
```
