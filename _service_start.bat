@echo off

echo "STARTING: " %1

setlocal enabledelayedexpansion
@REM Проверяем, кого мы развертываем
IF /i %1==presenter (GOTO BACKEND)
IF /i %1==guarder (GOTO BACKEND)
IF /i %1==eureka (GOTO BACKEND)
IF /i %1==gateway (GOTO BACKEND)
IF /i %1==service_bulder (GOTO BACKEND)
IF /i %1==service_builder_kubernetes (GOTO BACKEND)
IF /i %1==frontend-main (GOTO FRONTEND)
IF /i %1==infrastructure (GOTO INFRASTRUCTURE)

GOTO DONE

:FRONTEND
cd %1
npm start
GOTO DONE

:BACKEND
copy  _mvn_package.bat %1
cd %1
start /WAIT _mvn_package.bat
del _mvn_package.bat
cd ..

cd %1
cd target
echo "%1 IS READY TO START"
java -jar %1-0.0.1-SNAPSHOT.jar
GOTO DONE

:INFRASTRUCTURE
docker run -d -p 31000:5000 --restart=always --name registry registry:2
start minikube_start_dev.bat
GOTO DONE

:DONE
echo STARTED: %1 LOCALLY
ECHO Done!