echo Compiling class files
mkdir "bin"
javac -classpath "bin" -d "bin" src/utility/Constants.java
wait $!
javac -classpath "bin" -d "bin" src/model/Employee.java
wait $!
javac -classpath "bin" -d "bin" src/main/Main.java
echo Build successful