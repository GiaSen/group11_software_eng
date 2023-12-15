# SCIENTIFIC COMPLEX CALCULATOR
## Group 11
#### PANTANI Pietro
#### ROBERTO Simone
#### RUSSO Vincenzo Pietro
#### SENATORE Giammarco

### 0. CALCULATOR
Our calculator accept input from both the keyboard and numeric keypad.

<img width="760" alt="calculator" src="https://github.com/GiaSen/group11_software_eng/assets/148695294/c130369b-2745-413c-ba3c-eec17419c4cf">

### 1. FUNCTIONS
Our calculator implements all the requested functions:
- Arithmetic operations (+,-,/,*,+-,squareroot);
- Stack operation (swap,over,dup,drop,clear);
- Variable operation (fromVarToStack,fromStackToVar,sumVar,subVar).

### 2. VALID INPUT
#### Number
The valid format for complex number insertion is a+bj.
a and b are double type number.
- The real number -4.21 is a valid input.
- The imaginary number 0.43j is a valid input.
- The complex number 3.2j+3 is not a valid input.

#### Stack
Allowed stack operation:
- swap: the two top elements are switched by position;
- over: a copy of the second last elements is pushed to the top;
- dup: a copy of the last element is pushed to the top;
- drop: the last element is removed;
- clear: all the elements are removed from the stack;

#### Variable
You can both select variable from the combobox and insert the operation (<var, >var, +var, -var), where var can be any letter from 'a' to 'z'.

##### This calculator is a Software Engineering Project for the University of Salerno.
