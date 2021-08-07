echo Compiling class files
mkdir "bin"
javac -classpath "bin" -d "bin" src/Calculations.java
wait $!
javac -classpath "bin" -d "bin" src/Main.java
echo Build successful