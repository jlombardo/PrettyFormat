# PrettyFormat
This class is a utility for outputting nicely formatted tabular String data where monospaced fonts are used such as at the console and with some GUI components.

It primarily solves the problem of proper column justification where row length and justification needs vary.

The project was created in the Netbeans IDE but should work in any IDE that supports Maven.

Example Input:
```
 String[][] goodTestData1 = {
      {"Part No","Description","Qty","Unit Cost","Ext. Price"},
      {"-------","-----------","---","---------","----------"},
      {"A100","Brewer Hat","2","29.95","59.90"},
      {"B12345","Mosquito Sprayer","20","9.95","199.99"}
  };

 JustifyDirection[] goodPads = {
      JustifyDirection.LEFT,JustifyDirection.LEFT,
      JustifyDirection.RIGHT,JustifyDirection.RIGHT,
      JustifyDirection.RIGHT
  };

 int spacers = 2;
 ```
 Example Output:
 ```
 Part No  Description        Qty  Unit Cost  Ext. Price 
 -------  -----------        ---  ---------  ----------  
 A100     Brewer Hat           2      29.95       59.90      
 B12345   Mosquito Sprayer    20       9.95      199.99     
```
**Notes:**
- master branch is the current production grade branch
- demo1-before-refactor is an example of what this project might look like 
  before refactoring for better encapsulation and cohesion
- demo1-after-refactor is an example of what the project should look like 
  after refactoring for better encapsulation and cohesion. It also adds and 
  reorganizes Junit tests. This branch should mirror the master branch.