@echo off

copy  _mvn_package.bat %1
cd %1
start /WAIT _mvn_package.bat
del _mvn_package.bat
cd ..

cd %1
cd target
echo "%1 IS READY TO START"
java -jar %1-0.0.1-SNAPSHOT.jar