echo Compiling class files
mkdir "target/classes"
javac -classpath "target/classes" -d "target/classes" src/main/java/utility/Constants.java
wait $!
javac -classpath "target/classes" -d "target/classes" src/main/java/utility/InputOutOfRangeException.java
wait $!
javac -classpath "target/classes" -d "target/classes" src/main/java/model/Employee.java
wait $!
javac -classpath "target/classes" -d "target/classes" src/main/java/payslip/InputParser.java
wait $!
javac -classpath "target/classes" -d "target/classes" src/main/java/payslip/App.java
wait $!
echo Build successful