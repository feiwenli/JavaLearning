cd sub1
mvn clean install
echo "install done"
java -classpath "target/test4.jar" com.hand.WalkingDirectory
# java -jar target/test4.jar
echo "sub1 done"
cd ..

