echo Compiling class files
echo .
javac -classpath "bin" -d "bin" src/Calculations.java
wait $!
echo .
javac -classpath "bin" -d "bin" src/Main.java
echo .
echo Build successful