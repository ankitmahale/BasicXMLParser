CS542 Design Patterns
SPRING 2016
PROJECT <5> README FILE

Due Date: PROJECT DUE DATE:May 8, 2016
Submission Date: March 8, 2016
Grace Period Used This Project:0 days
Grace Period Remaining: 0 days
Author(s): Ankit Mahale
e-mail(s): amahale2@binghamton.edu


PURPOSE:
To implement Observer Pattern

PERCENT COMPLETE:
I believe I have completed 100% of this project


FILES:


SAMPLE OUTPUT:


[java] Total number of Mismatched Objects are : 0


[java] ClassName : class driver.MyAllTypesFirst
     [java] myInt : 69
     [java] myLong : 3379579102296078182
     [java] myString : YfkCBpOe7e
     [java] myBool : true

     [java] ClassName : class driver.MyAllTypesSecond
     [java] myDouble : 0.9082340365990902
     [java] myFloat : 0.67559487
     [java] myShort : 3434
     [java] myChar : G

     [java] ClassName : class driver.MyAllTypesFirst
     [java] myInt : 20
     [java] myLong : 4332371471786460365
     [java] myString : BXrUI521Mz
     [java] myBool : false

     [java] ClassName : class driver.MyAllTypesSecond
     [java] myDouble : 0.0020490103560769635
     [java] myFloat : 0.77699745
     [java] myShort : 29861
     [java] myChar : Y

     [java] ClassName : class driver.MyAllTypesFirst
     [java] myInt : 49
     [java] myLong : -5913745532890639703
     [java] myString : JHa7Wq3Yec
     [java] myBool : true

     [java] ClassName : class driver.MyAllTypesSecond
     [java] myDouble : 0.7932325502881713
     [java] myFloat : 0.6197866
     [java] myShort : 25877
     [java] myChar : K

     [java] ClassName : class driver.MyAllTypesFirst
     [java] myInt : 26
     [java] myLong : 3686288256179280050
     [java] myString : FsssMKOPWW
     [java] myBool : false

     [java] ClassName : class driver.MyAllTypesSecond
     [java] myDouble : 0.8433699985401083
     [java] myFloat : 0.05235058
     [java] myShort : 4023
     [java] myChar : U

     [java] ClassName : class driver.MyAllTypesFirst
     [java] myInt : 41
     [java] myLong : -7944565552751329485
     [java] myString : nKkO3FlosB
     [java] myBool : false

     [java] ClassName : class driver.MyAllTypesSecond
     [java] myDouble : 0.08878077516212757
     [java] myFloat : 0.7238298
     [java] myShort : 28435
     [java] myChar : g
To clean:

ant -buildfile src/build.xml clean

To COMPILE:
ant -buildfile src/build.xml all

To RUN by specifying arguments from command line:

ant -buildfile src/build.xml run -Darg0=serdeser or deser -Darg1=5 -Darg2=output.txt


To create tarball for submission
ant -buildfile src/build.xml tarzip


Datastructure:
Complexity: Vector are good for retrieving elements from a specific position in the container or for adding and removing elements from the end of the container. All of these operations can be performed in constant time -- O(1). However, adding and removing elements from any other position proves more expensive -- linear to be exact: O(n-i), where n is the number of elements and i is the index of the element added or removed. These operations are more expensive because you have to shift all elements at index i and higher over by one element.
