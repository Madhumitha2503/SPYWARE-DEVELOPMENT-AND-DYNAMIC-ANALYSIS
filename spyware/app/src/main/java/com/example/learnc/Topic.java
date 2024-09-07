package com.example.learnc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class Topic extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ImageView aiw = findViewById(R.id.aiw);
        aiw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open BotActivity
                Intent intent = new Intent(Topic.this, BotActivity.class);
                startActivity(intent);
            }
        });

        // Find each item by its id and set an OnClickListener
        LinearLayout item1 = findViewById(R.id.item1);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopicDetail("Introduction to C", "C is a procedural programming language that offers a comprehensive set of features for efficient and low-level programming. It was created by Dennis Ritchie at Bell Labs in the early 1970s as a successor to the B programming language. One of the main motivations behind developing C was to design a language that could be used to write operating systems, which led to its adoption in the development of Unix, one of the most influential operating systems in computing history.\n" +
                        "\n" +
                        "One of the key features of C is its close relationship with the underlying hardware, providing direct access to memory addresses and system resources. This level of control makes C an ideal choice for tasks that require fine-grained manipulation of hardware, such as device drivers and embedded systems programming. Additionally, C's syntax is relatively simple and compact, making it easy to read and write, despite its low-level capabilities.\n" +
                        "\n" +
                        "Memory management is another important aspect of C programming. Unlike higher-level languages that abstract away memory management details, C requires programmers to manually allocate and deallocate memory using functions like malloc() and free(). While this level of control can lead to more efficient memory usage, it also introduces the risk of memory leaks and segmentation faults if not managed properly.\n" +
                        "\n" +
                        "Despite its age, C remains highly relevant today, with a vast ecosystem of libraries and frameworks that support a wide range of applications. Many modern programming languages, such as C++, Python, and JavaScript, have been influenced by C's syntax and semantics, making it a valuable language to learn for both beginners and experienced programmers alike.\n" +
                        "\n" +
                        "In summary, C is a powerful and versatile programming language with a rich history and a wide range of applications. Its low-level features and direct access to system resources make it well-suited for system programming and performance-critical tasks, while its simplicity and influence on other languages continue to make it an essential skill for programmers in various domains.");
            }
        });

        LinearLayout item2 = findViewById(R.id.item2);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Variables and Data Types";

                // Content explaining the topic in detail, along with an example
                String content = "In the topic of Variables and Data Types, you will learn how to declare variables and explore the different data types in C. Variables are used to store data in a program, and each variable has a data type that determines what kind of data it can store and how it is stored in memory.\n\n" +
                        "C supports several basic data types, including:\n" +
                        "- int: Used to store integer values.\n" +
                        "- char: Used to store single characters.\n" +
                        "- float: Used to store floating-point numbers with single precision.\n" +
                        "- double: Used to store floating-point numbers with double precision.\n\n" +
                        "Here's an example:\n\n" +
                        "// Declare variables\n" +
                        "int age = 25;\n" +
                        "char grade = 'A';\n" +
                        "float temperature = 98.6;\n" +
                        "double pi = 3.14159;\n\n" +
                        "// Perform operations\n" +
                        "int newAge = age + 5;\n" +
                        "float newTemp = temperature - 2.5;\n\n" +
                        "Understanding variables and data types is fundamental to writing C programs, as they form the building blocks of any program's logic and functionality.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

        // Similarly, set onClickListeners for other items
        LinearLayout item3 = findViewById(R.id.item3);
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Operators";

                // Content explaining the topic in detail
                String content = "In the topic of Operators, you will learn about various operators in C such as arithmetic, relational, logical, and bitwise operators. Operators are symbols that perform operations on operands, which can be variables, constants, or expressions. Understanding operators is essential for performing calculations, making decisions, and manipulating data in C programs.\n\n" +
                        "C supports a wide range of operators, including:\n" +
                        "- Arithmetic Operators: Addition (+), Subtraction (-), Multiplication (*), Division (/), and Modulus (%).\n" +
                        "- Relational Operators: Equal to (==), Not equal to (!=), Greater than (>), Less than (<), Greater than or equal to (>=), Less than or equal to (<=).\n" +
                        "- Logical Operators: AND (&&), OR (||), and NOT (!).\n" +
                        "- Bitwise Operators: AND (&), OR (|), XOR (^), Left shift (<<), Right shift (>>), and NOT (~).\n\n" +
                        "Here's an example:\n\n" +
                        "// Arithmetic Operators\n" +
                        "int result = 10 + 5; // result is 15\n" +
                        "int remainder = 15 % 4; // remainder is 3\n\n" +
                        "// Relational Operators\n" +
                        "int a = 10, b = 20;\n" +
                        "boolean isEqual = (a == b); // isEqual is false\n\n" +
                        "// Logical Operators\n" +
                        "boolean condition1 = true, condition2 = false;\n" +
                        "boolean result = (condition1 && condition2); // result is false\n\n" +
                        "// Bitwise Operators\n" +
                        "int x = 5, y = 3;\n" +
                        "int bitwiseAnd = x & y; // bitwiseAnd is 1\n" +
                        "int bitwiseOr = x | y; // bitwiseOr is 7\n" +
                        "int bitwiseXor = x ^ y; // bitwiseXor is 6\n" +
                        "int leftShift = x << 2; // leftShift is 20\n" +
                        "int rightShift = x >> 1; // rightShift is 2\n\n" +
                        "By mastering operators, you'll gain the ability to manipulate data and control the flow of your programs effectively.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

        LinearLayout item4 = findViewById(R.id.item4);
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Control Structures";

                // Content explaining the topic in detail
                String content = "In the topic of Control Structures, you will explore the fundamental constructs in C programming that govern the flow of execution within a program. Control structures allow you to make decisions, perform repetitive tasks, and handle different scenarios dynamically. Mastery of control structures is essential for writing programs that exhibit logic, flexibility, and efficiency.\n\n" +
                        "C provides various control structures, including:\n" +
                        "- If-Else Statement: The if-else statement allows you to execute a block of code conditionally based on the evaluation of a boolean expression. If the condition is true, the code inside the if block is executed; otherwise, the code inside the else block (if present) is executed.\n" +
                        "- Switch-Case Statement: The switch-case statement provides a way to perform multiple conditional checks based on the value of an expression. It evaluates the expression and compares it against different cases, executing the corresponding block of code for the matching case.\n" +
                        "- Loops: Loops are used to repeat a block of code multiple times until a certain condition is met. C supports three types of loops: the for loop, the while loop, and the do-while loop. The for loop is ideal for executing a block of code a specific number of times, the while loop continues to execute as long as a condition remains true, and the do-while loop executes the block of code at least once before checking the condition.\n\n" +
                        "Here's an example demonstrating the use of control structures:\n\n" +
                        "// If-Else Statement\n" +
                        "int age = 20;\n" +
                        "if (age >= 18) {\n" +
                        "    printf(\"You are eligible to vote.\");\n" +
                        "} else {\n" +
                        "    printf(\"You are not eligible to vote.\");\n" +
                        "}\n\n" +
                        "// Switch-Case Statement\n" +
                        "int choice = 2;\n" +
                        "switch (choice) {\n" +
                        "    case 1:\n" +
                        "        printf(\"You chose option 1.\");\n" +
                        "        break;\n" +
                        "    case 2:\n" +
                        "        printf(\"You chose option 2.\");\n" +
                        "        break;\n" +
                        "    default:\n" +
                        "        printf(\"Invalid choice.\");\n" +
                        "}\n\n" +
                        "// Loops\n" +
                        "int i;\n" +
                        "for (i = 1; i <= 5; i++) {\n" +
                        "    printf(\"%d \", i);\n" +
                        "}\n\n" +
                        "Understanding control structures empowers you to write structured, efficient, and maintainable code, enabling you to solve complex problems with clarity and precision.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

        LinearLayout item5 = findViewById(R.id.item5);
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Functions";

                // Content explaining the topic in detail
                String content = "In the topic of Functions, you will explore one of the core concepts of modular programming in C: functions. Functions are self-contained blocks of code that perform a specific task. They promote code reusability, modularity, and abstraction, allowing you to break down complex tasks into smaller, manageable units.\n\n" +
                        "C allows you to define your own functions, which can then be called from other parts of the program. Function declaration typically includes the return type, function name, and parameters (if any). You can pass arguments to functions, and they can return a value upon completion.\n\n" +
                        "Key concepts related to functions include:\n" +
                        "- Function Declaration and Definition: Declaring a function involves specifying its return type, name, and parameters (if any). The function definition contains the actual implementation of the function's behavior.\n" +
                        "- Function Parameters: Functions can accept parameters, which are variables used to pass data into the function. Parameters allow functions to operate on different data each time they are called.\n" +
                        "- Return Values: Functions can return a value to the caller upon completion. The return type specifies the type of value that the function will return.\n\n" +
                        "Here's an example demonstrating the creation and usage of functions:\n\n" +
                        "// Function Declaration\n" +
                        "int add(int a, int b); // Function prototype\n\n" +
                        "// Function Definition\n" +
                        "int add(int a, int b) {\n" +
                        "    return a + b;\n" +
                        "}\n\n" +
                        "// Function Call\n" +
                        "int result = add(5, 3); // Calls the add function with arguments 5 and 3\n\n" +
                        "Understanding functions is crucial for writing modular and maintainable code. By breaking down your program into smaller functions, you can improve code organization, readability, and reusability, leading to more robust and scalable software.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

        LinearLayout item6 = findViewById(R.id.item6);
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Arrays";

                // Content explaining the topic in detail
                String content = "In the topic of Arrays, you will dive into a fundamental data structure in C: arrays. Arrays are collections of elements of the same data type arranged in contiguous memory locations. They provide a convenient way to store and manipulate multiple values of the same type.\n\n" +
                        "C supports one-dimensional arrays, multi-dimensional arrays, and arrays of arrays (also known as multidimensional arrays). Understanding arrays is essential for handling collections of data efficiently.\n\n" +
                        "Key concepts related to arrays include:\n" +
                        "- Declaration and Initialization: Arrays are declared using a specific syntax that includes the data type of the elements and the size of the array. They can be initialized either at the time of declaration or later using assignment statements.\n" +
                        "- Accessing Elements: Elements of an array are accessed using index notation. The index specifies the position of the element within the array. Array indexing in C starts from 0, meaning the first element has an index of 0, the second element has an index of 1, and so on.\n" +
                        "- Manipulating Arrays: Arrays can be modified by assigning new values to individual elements or by performing operations on the entire array.\n\n" +
                        "Here's an example demonstrating the declaration, initialization, and accessing elements of an array:\n\n" +
                        "// Declaration and Initialization\n" +
                        "int numbers[5] = {1, 2, 3, 4, 5};\n\n" +
                        "// Accessing Elements\n" +
                        "int thirdElement = numbers[2]; // Retrieves the third element (index 2)\n\n" +
                        "// Modifying Elements\n" +
                        "numbers[4] = 10; // Changes the value of the fifth element to 10\n\n" +
                        "Understanding arrays enables you to work with collections of data efficiently, facilitating tasks such as sorting, searching, and data manipulation. Arrays are widely used in C programming and form the basis for many other data structures and algorithms.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

        LinearLayout item7 = findViewById(R.id.item7);
        item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Strings";

                // Content explaining the topic in detail
                String content = "In the topic of Strings, you will explore the handling of strings in C programming. A string is a sequence of characters terminated by a null character ('\0'). Strings are widely used for representing text-based data in programs.\n\n" +
                        "In C, strings are typically represented as arrays of characters. Various string manipulation functions are available in the standard C library to perform common operations on strings, such as concatenation, comparison, copying, and tokenization.\n\n" +
                        "Key concepts related to strings include:\n" +
                        "- Declaration and Initialization: Strings can be declared and initialized using character arrays. It's essential to ensure that the array is large enough to accommodate the string and the null terminator.\n" +
                        "- String Manipulation Functions: The standard C library provides functions like strlen(), strcpy(), strcat(), strcmp(), and strtok() for manipulating strings. These functions enable tasks such as determining the length of a string, copying one string to another, concatenating strings, comparing strings, and tokenizing strings.\n" +
                        "- String Input and Output: C provides functions like scanf() and printf() for reading and writing strings from/to the standard input and output streams.\n\n" +
                        "Here's an example demonstrating string handling in C:\n\n" +
                        "// Declaration and Initialization\n" +
                        "char name[20] = \"John\"; // Declares a string 'name' with a maximum length of 20 characters\n\n" +
                        "// String Manipulation\n" +
                        "int length = strlen(name); // Calculates the length of the string\n" +
                        "char destination[20];\n" +
                        "strcpy(destination, name); // Copies 'name' to 'destination'\n" +
                        "strcat(destination, \" Doe\"); // Concatenates 'Doe' to 'destination'\n\n" +
                        "Understanding string handling is crucial for developing applications that deal with textual data. By mastering string manipulation techniques, you can perform a wide range of tasks, from simple text processing to complex parsing and analysis.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

// OnClickListener for item8: Pointers
        LinearLayout item8 = findViewById(R.id.item8);
        item8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Pointers";

                // Content explaining the topic in detail
                String content = "In the topic of Pointers, you will delve into one of the most powerful features of the C programming language: pointers. A pointer is a variable that stores the memory address of another variable. Pointers enable you to work with memory directly, allowing for efficient memory management and manipulation.\n\n" +
                        "Key concepts related to pointers include:\n" +
                        "- Pointer Declaration and Initialization: Pointers are declared using the asterisk (*) symbol followed by the data type they point to. They can be initialized with the address of another variable using the address-of operator (&).\n" +
                        "- Pointer Arithmetic: Pointers support arithmetic operations such as addition, subtraction, and comparison. Pointer arithmetic allows you to navigate through memory efficiently, facilitating tasks like array manipulation and dynamic memory allocation.\n" +
                        "- Pointer Usage: Pointers are used for various purposes in C programming, including dynamic memory allocation, passing parameters to functions by reference, and implementing data structures like linked lists and trees.\n\n" +
                        "Here's a brief example demonstrating pointer usage:\n\n" +
                        "// Declaration and Initialization\n" +
                        "int *ptr; // Declares a pointer to an integer\n" +
                        "int num = 10;\n" +
                        "ptr = &num; // Initializes 'ptr' with the address of 'num'\n\n" +
                        "// Dereferencing\n" +
                        "printf(\"Value of num: %d\", *ptr); // Prints the value stored at the address pointed to by 'ptr'\n\n" +
                        "Understanding pointers is essential for mastering C programming, as they provide a powerful mechanism for accessing and manipulating memory directly.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

// OnClickListener for item9: Structures and Unions
        LinearLayout item9 = findViewById(R.id.item9);
        item9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Title of the topic
                String title = "Structures and Unions";

                // Content explaining the topic in detail
                String content = "In the topic of Structures and Unions, you will learn how to define and use complex data types in C programming. Structures and unions allow you to group together related data items under a single name, providing a convenient way to represent real-world entities.\n\n" +
                        "Structures: A structure is a collection of variables (or members) of different data types grouped together under a single name. Each member of a structure can have its own data type and name. Structures are widely used for representing objects with multiple attributes.\n\n" +
                        "Unions: A union is similar to a structure, but all members share the same memory location. Unlike structures, where each member has its own memory space, all members of a union occupy the same memory location. Unions are useful when you need to store different types of data in the same memory space.\n\n" +
                        "Here's an example demonstrating the usage of structures and unions:\n\n" +
                        "// Structure Declaration\n" +
                        "struct Person {\n" +
                        "    char name[50];\n" +
                        "    int age;\n" +
                        "};\n\n" +
                        "// Union Declaration\n" +
                        "union Data {\n" +
                        "    int integer;\n" +
                        "    float floating;\n" +
                        "};\n\n" +
                        "Understanding structures and unions enables you to organize and manipulate complex data structures effectively, making your programs more modular and maintainable.";

                // Open the topic detail activity with the provided title and content
                openTopicDetail(title, content);
            }
        });

// OnClickListener for item10: Dynamic Memory Allocation

        LinearLayout item10 = findViewById(R.id.item10);
        item10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopicDetail("Dynamic Memory Allocation",
                        "Understand dynamic memory allocation, using malloc, calloc, realloc, and free. " +
                                "In the topic of Dynamic Memory Allocation, you will explore a crucial aspect of memory management in C programming. Dynamic memory allocation allows you to allocate memory at runtime, providing flexibility in memory usage and enabling efficient utilization of memory resources.\n\n" +
                                "C provides several functions for dynamic memory allocation:\n" +
                                "- malloc(): Allocates a block of memory of the specified size in bytes. It returns a pointer to the beginning of the allocated memory block.\n" +
                                "- calloc(): Allocates memory for an array of elements, initializes all bytes to zero, and returns a pointer to the beginning of the allocated memory block.\n" +
                                "- realloc(): Resizes the previously allocated memory block to the new size specified. It returns a pointer to the resized memory block, preserving the existing data if possible.\n" +
                                "- free(): Deallocates the memory block previously allocated by malloc(), calloc(), or realloc(), releasing the memory space for reuse.\n\n" +
                                "Dynamic memory allocation is commonly used in scenarios where the size of data structures or arrays is not known at compile-time, or when memory needs to be allocated and deallocated dynamically during program execution.\n\n" +
                                "Here's a brief example demonstrating dynamic memory allocation:\n\n" +
                                "// Allocate memory for an integer\n" +
                                "int *ptr = (int *)malloc(sizeof(int));\n" +
                                "if (ptr == NULL) {\n" +
                                "    printf(\"Memory allocation failed.\\n\");\n" +
                                "    return 1;\n" +
                                "}\n\n" +
                                "// Assign value to the allocated memory\n" +
                                "*ptr = 10;\n\n" +
                                "// Deallocate the memory\n" +
                                "free(ptr);\n\n" +
                                "Understanding dynamic memory allocation is crucial for managing memory efficiently, preventing memory leaks, and optimizing memory usage in C programs."
                );
            }
        });

    }

    private void openTopicDetail(String title, String content) {
        Intent intent = new Intent(Topic.this, TopicDetailActivity.class);
        intent.putExtra("TITLE", title);
        intent.putExtra("CONTENT", content);
        startActivity(intent);
    }
}
