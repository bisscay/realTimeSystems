# realTimeSystems
#### Lab A
- Create a new project called LabA_Exercise2, and add a MyMath class that will contain a set of methods to calculate simple mathematical operations. 
- Write a test application using a second class named MyMathTest that has a main method and tests each method in the MyMath class. 
- Compute an estimate of the total time the sum(int a, int b) operation takes, use System.currentTimeMillis() for this task. 
- Calculate time estimates when the operation is repeated 1,000, 10,000, 100,000, and 1,000,000 times. Compare this to the print operation.  

#### Lab B
- Create a class called SimpleTask which inherits from the TimerTask class. 
- The purpose of this class will be to store the value of a counter, and print this value to console every time the task runs. 
- Create a second class called SimpleTimer that will setup a repeating timer, with a period of one second, and release time of two seconds. 
- Schedule an instance of SimpleTask to run every time the timer expires.

#### Lab C
- Create a class called Frames that computes the three frame size constraint rules. 
- Add methods to calculate each rule, such as calculateRuleOne(), calculateRuleTwo(), calculateRuleThree(), calculateGCD() etc 
- These three methods should be run from the main method, and results printed to the output screen.
- And thus determine valid possible frame sizes.

#### Lab D
- Create a FIFO Scheduler:
- Use Netbeans to emulate a First In First Out scheduler with N jobs.
- For ease of development, keep N below 5.
- Note: This will not be a graphical application, but will simply use the console to display updates. 

#### Lab E
- Develop a program that prompts the user to enter three tasks as input and produces a graph of the time demand analysis function of the taks.
- Simple time demand analysis function for each task is defined as: Wi(t) = ei + Sum(k=1 to i-1)[t/pk]ek
- You can use any programming language / graphics environment you want ( java swing etc). 
- Also, if graphics are beyond you, you may generate a text output that describes each function over time instead for less marks.
 
