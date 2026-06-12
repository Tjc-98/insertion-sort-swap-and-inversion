# Insertion Sort Swap and Inversion

A Java program that sorts an integer array using insertion sort and counts the inversions and swaps involved.

---

## About

Written in Java, this program implements the insertion sort algorithm based on the approach described in *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne. Before sorting, it identifies and prints every inversion in the array - pairs of elements that are out of order - along with a total inversion count. During sorting, it prints the array state after each swap and reports the total number of swaps performed.

## Usage

The program runs two back-to-back tests on startup:

1. **Interactive test** - prompts you to enter an array size and then each element one by one.
2. **Example test** - runs automatically against the hardcoded array `{1, 2, 4, 3, 5, 0}`.

For each test the program prints:

- The original array
- Each inversion as `[i, array[i]], [j, array[j]]` and the total inversion count
- The array state after every swap during sorting
- The total number of swaps performed

## Getting Started

### Prerequisites

- Java 21 or later
- Maven 3.8 or later

### Building

**Unix / macOS**
```bash
mvn package
```

**Windows**
```cmd
mvn package
```

### Running

**Unix / macOS**
```bash
mvn exec:java -Dexec.mainClass="Main"
```

**Windows**
```cmd
mvn exec:java -Dexec.mainClass="Main"
```

Alternatively, compile and run directly:

**Unix / macOS**
```bash
javac src/main/java/Main.java -d out
java -cp out Main
```

**Windows**
```cmd
javac src\main\java\Main.java -d out
java -cp out Main
```

## License

MIT - see [LICENSE](LICENSE).
