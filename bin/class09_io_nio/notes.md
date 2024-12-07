# 9 Java I/O and NIO

- [9 Java I/O and NIO](#9-java-io-and-nio)
  - [Java I/O](#java-io)
    - [1. File](#1-file)
      - [Constructors of File Class](#constructors-of-file-class)
      - [Important Methods of File Class](#important-methods-of-file-class)
    - [2. FileWriter](#2-filewriter)
      - [Problems with FileWriter](#problems-with-filewriter)
      - [Constructors of FileWriter Class](#constructors-of-filewriter-class)
      - [Important Methods of FileWriter Class](#important-methods-of-filewriter-class)
    - [3. FileReader](#3-filereader)
      - [Problem with FileReader](#problem-with-filereader)
      - [Constructors for FileReader Class](#constructors-for-filereader-class)
      - [Important Methods of FileReader Class](#important-methods-of-filereader-class)
    - [4. BufferedWriter](#4-bufferedwriter)
      - [Problems with BufferedWriter](#problems-with-bufferedwriter)
      - [Constructors of BufferedWriter Class](#constructors-of-bufferedwriter-class)
      - [Important Methods of BufferedWriter Class](#important-methods-of-bufferedwriter-class)
    - [5. BufferedReader](#5-bufferedreader)
      - [Constructors of BufferedReader Class](#constructors-of-bufferedreader-class)
      - [Important Methods of BufferedReader Class](#important-methods-of-bufferedreader-class)
    - [6. PrintWriter](#6-printwriter)
      - [Constructors of PrintWriter Class](#constructors-of-printwriter-class)
      - [Important Methods of PrintWriter Class](#important-methods-of-printwriter-class)
  - [Java NIO](#java-nio)
    - [Main Classes/Abstractions of Java NIO](#main-classesabstractions-of-java-nio)

## Java I/O

**Note:** We can insert new line through the System class as well by calling `System.lineSeparator()` method as is.

### 1. File

Java I/O was mainly developed with UNIX in mind and as _everything is a file in
UNIX-like OSs_, the same File class in Java is used to represent both files and
directories.

#### Constructors of File Class

File class has three types of constructors:

1. `File f = new File(String name)` Creates a Java File object to represent the
   name of **specified file or directory**, present in the current working
   directory. **Example:** Write the code to create a File named "abc.txt" in
   current working directory.

   ```java
   File f = new File("abc.txt");
   f.createNewFile();             // file created using createNewFile method of the File class
   ```

2. `File f = new File(String subdir, String name)` Creates a Java File object to
   represent the name of specified file or directory, present in a specific
   directory. **Example:** Write the code to create a directory named "dir123"
   in current working directory and create a file named "demo.txt" in that
   directory.

   ```java
   File f = new File("dir123");
   f.mkdir();                                 // dir123 created using mkdir method of File class, which is also similar to the UNIX system command for creating directory
   File f1 = new File("dir123", "demo.txt")   // dir123 must exist before referencing it in this constructor
   f1.createNewFile();
   ```

3. `File f = new File(File subdir, String name)` Same as 2, but this constructor
   takes in a File object representing a specific directory or sub-directory.
   **Example:** Create a named "demo.txt" in "xyz" directory located in Drive E
   on a Windows OS.

   ```java
   File f = new File("E:\\xyz");              // added double backslash to prevent escaping x (\x) which could have given illegal character exception at compile-time
   f.mkdir();                                 // xyz created, and the method is same for any OS
   File f1 = new File(f, "demo.txt")          // directory xyz must exist before referencing it in this constructor
   f1.createNewFile();
   ```

#### Important Methods of File Class

- `boolean f.exists()` : returns true if specified file or directory physically
  exists in the system.
- `boolean f.createNewFile()` : first checks whether physical file exists or not
  in the system. If it is already available then this method returns false
  without creating any physical file. If it is not already available, then this
  method creates new file and returns true.
- `boolean f.isFile()` : returns true if the File object is pointing to a
  physical file on the system.
- `boolean f.mkdir()` : works same but for directories instead of files.
- `boolean f.isDirectory()` : returns true if the File object is pointing to a
  physical directory on the system.
- `String[] f.list("String dir")` : returns the names of all files and/or
  directories present in the specified directory referenced by the File object.
- `long f.length()` : returns the numbers of character present in the file
  referenced by the File object.
- `boolean f.delete()` : deletes the file or directory.

**Example 1:** Code to display all files and directories present in the "rooms"
directory located in Drive C of a Windows based system.

```java
File f = new File("C:\\rooms");
String[] s = f.list();    // returns a list of all the directories and file located in the specified directory
int count = 0;
for (String s1 : s) {
  count++;
  System.out.println(s1);
}
System.out.println("Total items found:" + count);
```

**Example 2:** Change the code to display only the files present in the same
"rooms" directory located in Drive C of a Windows based system.

```java
File f = new File("C:\\rooms");
String[] s = f.list();
int count = 0;
for (String s1 : s) {
  // File object created because isFile() method exists only for a File object
  File f1 = new File(f, s1);      // f1 references s1 (which could be a file or a dir itself) present in the dir referenced by the f File object
  if (f1.isFile()) {
    count++;
    System.out.println(s1);
  }
}
System.out.println("Total files found:" + count);
```

---

### 2. FileWriter

Writes character/text data to a file. If the file to write data to does not exist or is not available, then FileWriter constructors will create that file and then write to it as well.

#### Problems with FileWriter

The biggest problem with FileWriter class are:

1. Its treatment of new lines. It needs an `'\n'` to insert a new line and if the data is coming in a single line without these line-separators then the readability of the data in the file will be affected and everything will be in a single line.Being a programmer, our concern, most of the time, is with data and not the line-separators. So, we have to **insert these line-separators manually**.

2. Sometimes the `'\n'` also gets written to the file instead of being treated as a line-separator because **in some systems, `\n` is not treated as a line-separator rather as a normal character**.

Since we need to add line-separators manually and they vary from system to system, so it becomes very difficult for the programmer to manage it. For this reason, we have BufferedWriter and PrintWriter classes as well to avoid this manual labor. In reality, no one is going to use the FileWriter class but it is the base to these other well-developed classes.

#### Constructors of FileWriter Class

It has two types of constructors, those whose FileWriter object overrides/writes-over the existing data (constructors 1 & 2 below) and those who can append to existing file data (constructors 3 & 4 below):

1. `FileWriter fw = new FileWriter(String fileName)` - An overriding constructor that takes the name of the file as argument.
2. `FileWriter fw = new FileWriter(File f)` - An overriding constructor that takes a File reference object as argument.
3. `FileWriter fw = new FileWriter(String fileName, boolean append)` - An appending constructor that takes boolean value `true` for enabling append operation in the FileWriter object. If it is omitted or `false` then the object will behave as overriding file writer.
4. `FileWriter fw = new FileWriter(File f, boolean append)` - An appending constructor same as 3 before but it takes a File reference object.

#### Important Methods of FileWriter Class

There are 3 write methods and a flush and close methods:

- `write(int ch)` - writes a single character(ch) to the file. Here, the character is treated as a unicode value but it can also take the character directly (because in programming, char to int promotion is always legal).

  ```java
  fw.write(100);    // writes character 'd' to the file
  fw.write('d');    // writes character 'd' to the file
  ```

- `write(char[] ch)` - writes an array of characters to the file.
- `write(String s)` - writes a string to the file.
- `flush()` - guarantees that every last character, that we wanted to write to the file, gets written if the write operation got stuck somewhere during its operation. Therefore, this method must be called after every write operation to ensure that all the data is written properly to the file. This method is also **applicable for all types of writers**.
- `close()` - closes the file writing character stream. This method must be called when we no longer want to write data to the file. This method is also **applicable to all types of readers AND writers**.

---

### 3. FileReader

Reads data from the file. It is the lowest/low-level reader used to read character/text data from the file.

#### Problem with FileReader

By using FileReader we can **read data character by character which is not convenient** to the programmer. For example, if we are reading a file contains millions of customers' cellphone contact numbers to find a particular customer's number. Let's say each number has 10 digits and since FileReader reads char by char, just reading and comparing the first number in the file will require 10 comparison operations which is costly, incovenient and slow. So we have BufferedReader (next level reader) which allows to read file data line by line instead of character by character.

#### Constructors for FileReader Class

1. `FileReader fr = new FileReader(String fileName)` - constructor that takes in the file name as argument.
2. `FileReader fr = new FileReader(File f)` - constructor that uses an existing File reference as an argument.

#### Important Methods of FileReader Class

- `int read()` - reads character by character and returns the unicode value of a single character from the file. If this method is called again, then it reads the unicode value next character upon each subsequent calling and so on. If there is no next character or no character to read at all then it returns -1.
- `int read(char[] ch)` - copies all data in the file into a character array and also returns the number of characters it copies from the file to the array (hence the int return-type).

- `void close()` - closes the character reading stream.

**Example:**

```java
File f = new File("abc.txt");

//--------------------------- Approach 1: using char array with method # 2
// in java the maximum size of array allowed is upto int only so the approach below is useful if the total file characters' data fall into the size of int
char[] ch = new char[ (int) f.length() ];     // f.length() returns a long value which needs to be typecasted to int
FileReader fr = new FileReader(f);
fr.read(ch);

for (char ch1 : ch) {
  System.out.print(ch1);    //print not println b/c the loop is printing character by character
}
fr.close()
//--------------------------- Approach 2: reading char by char using method # 1
// if the file size is longer than int then it is better to use the character by character approach below
FileReader fr1 = new FileReader("abc.txt");
int i = fr1.read();
while (i != -1) {
  // since fr.read() returns int unicode, it also needs to be typecast to char
  System.out.print( (char) i );   // using print because we are printing a single character
  i = fr1.read();   // reading next character
}

fr1.close()
```

---

### 4. BufferedWriter

Overcomes the labor of inserting new lines manually so it a next level writer and we can use the `newLine()` method of BufferedWriter to insert line separators.

#### Problems with BufferedWriter

1. Calling `newLine()` again and again is still inconvenient.
2. But the bigger problem is that we cannot write primitive values directly to the file. For example, if we want to write **100** (or 10.5, true) to a file then doing `bw.write(100)` will write **d** to the file because its unicode value is 100. And if we want to write **100** to the file then we have to do this: `bw.write("100")`, convert 100 to a string to write it to the file. So, creating a String object to represent 100 is not my programming requirement but it is necessary to write 100 to the file using a BufferedWriter. So, overall, performance of the system will be affected because we are creating String objects explicitly multiple times.

Hence, it is both inconvenient and costly to use BufferedWriter.

#### Constructors of BufferedWriter Class

BufferedWriter cannot communicate directly with the file; it can communicate via a Writer object only. The **Writer is an interface in Java** and any of its implementation (FileWriter, PrintWriter, another BufferedWriter) can be used to initialize the BufferedWriter constructor:

1. `BufferedWriter bw = new BufferedWriter(Writer w)`
2. `BufferedWriter bw = new BufferedWriter(Writer w, int bufferSize)` - this constructor also accepts a custom buffer size but most of the time, we don't go for this constructor.

**Example:** Which of the following constructors are valid?

```java
BufferedWriter bw = new BufferedWriter( "abc.txt" );  // INVALID - BW trying to communicate directly with the file
BufferedWriter bw = new BufferedWriter( new File("abc.txt") );  // INVALID - BW trying to communicate directly with the file
BufferedWriter bw = new BufferedWriter( new FileWriter("abc.txt") );  // valid - BW -> FW (1-level buffering)
BufferedWriter bw = new BufferedWriter( new BufferedWriter( new FileWriter("abc.txt") ) );  // valid - BW -> BW -> FW (2-level buffering)
```

#### Important Methods of BufferedWriter Class

- `write(int ch)` - same as FileWriter; writes a single character to the file.
- `write(char[] ch)` - same as FileWriter; writes an array of characters to the file.
- `write(String s)` - same as FileWriter; writes a string data to the file.
- `flush()` - common to the Writer interface and all Writer implementations; gives the guarantee that total data, up to every last character, is written properly to the file.
- `close()` same as FileWriter; closes the character writing stream.
- `newLine()` - inserts a line separator. This method is **unique to the BW class**.

**Example:**

```java
FileWriter fw = new FileWriter("abc.txt");
BufferedWriter bw = new BufferedWriter(fw);   // BW -> FW (1-level buffering)
bw.write(100);                    // write() method with a unicode of a character
bw.write('D');                    // write() method with a single character
bw.newLine();
char[] ch = {'a', 'b', 'c', 'd'};
bw.write(ch);                     // write() method with a character array
bw.newLine();
bw.write("sample text");          // write() method with string
// below two methods must be called at the end of using any Writer
bw.flush();
bw.close();   //! recommended approach - closing BW will automatically close all internal Writers (like FW in this case) no matter how many levels deep they are
```

---

### 5. BufferedReader

Next level Reader which allows to read data line by line instead of character by character so it is more convenient and recommended to use. So it is the best and most enhanced Reader for reading data from a file.

#### Constructors of BufferedReader Class

Just like BufferedWriter, BufferedReader also cannot communicate with a file directly and needs another Reader object to communicate. Whereas, Reader is an interace in Java which is implemented in both FileReader and BufferedReader. So BufferedReader's constructor can take both FileReader or another BufferedReader as an argument.

1. `BufferedReader br = new BufferedReader( Reader r )`
2. `BufferedReader br = new BufferedReader( Reader r, int bufferSize )` - less commonly used because most of the time we do not provide a custom bufferSize

#### Important Methods of BufferedReader Class

- `int read()` - available in both FR and BR
- `int read(char[] ch)` - available in both FR and BR
- `void close()` - available in both FR and BR
- `String readLine()` - reads the first line in the file and upon each subsequent call, continues reading the next lines in one by one manner. When it has completed reading all lines then **calling it again returns `null`**.

**Example:**

```java
FileReader fr = new FileReader( "abc.txt" );
BufferedReader br = new BufferedReader( fr );   // BR -> FR
String line = br.readLine();

while (line != null) {    // if line != nulll then line contains valid data
  System.out.println(line);   // using println because BR is reading line by line
  line = br.readLine();
}
br.close();   // closes both automatically: BR -> FR
```

---

### 6. PrintWriter

It is the most enhanced Writer to write character data to a file. The main advantage of PrintWriter is that it **can write ANY type of primitive data directly to the file**.

#### Constructors of PrintWriter Class

PrintWriter **can communicate either directly** to the file **OR indirectly** via some other Writer object also.

1. `PrintWriter pw = new PrintWriter(String fileName)`
2. `PrintWriter pw = new PrintWriter(File f)`
3. `PrintWriter pw = new PrintWriter(Writer w)`

#### Important Methods of PrintWriter Class

**`write` Methods:**

- `write(int ch);` - same as in FileWriter and BufferedWriter; writes char by char
- `write(char[] ch);` - same as in FileWriter and BufferedWriter; writes an array of characters
- `write(String s);` - same as in FileWriter and BufferedWriter; writes a string to a file
- `flush();` - same as in FileWriter and BufferedWriter; ensures every last character is written properly to the file
- `close();` - same as in FileWriter and BufferedWriter; closes the character write stream

**`print` Methods:**

These methods overcome the limitation of BufferedWriter and allow us to write primitive data directly to the file without typecasting. But still, the methods below cannot add a new line after adding relevant data to the file.

- `print(char ch)`
- `print(int i)`
- `print(double d)`
- `print(boolean b)`
- `print(String s)`

**`println` Methods:**

These methods not only allow to write primitive data to the file but also add line separators each time they are called.

- `println(char ch)`
- `println(int i)`
- `println(double d)`
- `println(boolean b)`
- `println(String s)`

**Example:**

```java
PrintWriter pw = new PrintWriter("abc.txt");    // PW directly referencing the file
pw.write(100);        // this method is common to all Writers and it writes 'd' to the file because 100 is unicode value of 'd'
pw.println(100);      // method special to PW; writes 100 to the file and also adds a line-separator
pw.println(true);     // method special to PW; writes true to the file and all adds a line-separator
pw.println('C');      // method special to PW; writes C to the file and also adds a line-separator
pw.println("sample"); // method special to PW; writes sample to the file and also adds a line-separator
pw.flush();
pw.close();
```

Q. What is the difference between `pw.write(100)` and `pw.print(100)` ?
A. In case of `pw.write(100)`, the corresponding character 'd' will be added to the file. But in case of `pw.print(100)`, the int value 100 will be added directly to the file without creating a String object which is not possible in case of BufferedWriter and FileWriter.

-----

## Java NIO

This package, like Java I/O, can also be used to read and write data to a file. But it provides multithreading capabilities to the I/O library and thereby, enables programmers to read and write data to the file asynchronously. NIO stands for Networking I/O (or more popularly as Non-blocking I/O).

Normally, while using Java I/O package, the read or write thread can get blocked until the whole file is read from or written to. So the NIO package provides an improvement over that in the sense that you can read from a file using one thread but at the same time, also move to another thread and write to a file as well. So you don't block your threads while reading from or writing to (or doing both) a file, hence the name Non-blocking I/O.

### Main Classes/Abstractions of Java NIO

1. _Buffers_, which are containers for data (a plain container for the data).
2. _Channels_ of various types, which represent connections to entities capable of performing I/O operations (channel is like a pipe/wire connecting file to the buffer).
3. _Charsets_ and their associated _encoders_ and _decoders_, which translate between bytes and unicode characters.
4. _Selectors_ and _selection keys_, which work with channels to provide non-blocking I/O facility.

- When you are reading; the read operation will happen from the _Channel_ into the _Buffer_.
- When you are writing; the operation will happen from the _Buffer_ to the _Channel_.

 /.[Go back to title page](./../../README.md) or [go back to top.](#9-java-io-and-nio)
