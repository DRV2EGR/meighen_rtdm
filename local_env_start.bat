@echo off

@REM echo Hello!
cd txt_utils
type start_banner.txt
cd ..

@REM echo "%*"

SET /A mainservices = 0

SET /A guarder_flg = 0
SET /A presenter_flg = 0
SET /A frontend_flg = 0
SET /A infrastructure_flg = 0

SET /A builder = 0
@REM SET /A deployer = 0

SET /A alltoup_flg = 0

SET /A dockerize_flg = 0

@REM Парсинг аргументов строки
setlocal enabledelayedexpansion
set argCount=0
for %%x in (%*) do (
   set /A argCount+=1
   set "argVec[!argCount!]=%%~x"
)
@REM echo Аргументов обнаружено: %argCount%

@REM Выполнение включения флагов
for /L %%i in (1,1,%argCount%) do (
    @REM echo %%i- "!argVec[%%i]!"

    IF "!argVec[%%i]!" == "-m" (set /A mainservices = 1)
    IF "!argVec[%%i]!" == "-g" (set /A guarder_flg = 1)
    IF "!argVec[%%i]!" == "-p" (set /A presenter_flg = 1)
    IF "!argVec[%%i]!" == "-f" (set /A frontend_flg = 1)
    IF "!argVec[%%i]!" == "-e" (set /A infrastructure_flg = 1)
    IF "!argVec[%%i]!" == "-b" (set /A builder = 1)
    @REM IF "!argVec[%%i]!" == "-d" (set /A deployer = 1)

    IF "!argVec[%%i]!" == "-a" (set /A alltoup_flg = 1)

    IF "!argVec[%%i]!" == "--docker" (set /A dockerize_flg = 1)

    IF "!argVec[%%i]!" == "-h" ( 
        cd txt_utils 
        type main_info.txt 
        cd .. 
    )
    IF "!argVec[%%i]!" == "--help" ( 
        cd txt_utils 
        type main_info.txt 
        cd .. 
     )
)

echo STARTING CREATING MEIGHEN RTDM!

@REM Основные сервисы
IF %mainservices% == 1 ( 
    start _service_start.bat eureka
    start _service_start.bat gateway
)
@REM start _service_start.bat eureka
@REM start _service_start.bat gateway

@REM Сервисы с параметрами


IF %alltoup_flg% == 1 (
    start _service_start.bat eureka
    start _service_start.bat gateway

    start _service_start.bat guarder
    start _service_start.bat presenter
    start _service_start.bat frontend-main
    start _service_start.bat infrastructure

    start _service_start.bat service_bulder
    @REM start _service_start.bat service_builder_kubernetes

    GOTO ENDING
)

IF %guarder_flg% == 1 ( start _service_start.bat guarder )
IF %presenter_flg% == 1 ( start _service_start.bat presenter )
IF %frontend_flg% == 1 ( start _service_start.bat frontend-main )
IF %infrastructure_flg% == 1 ( start _service_start.bat infrastructure )
IF %builder% == 1 ( start _service_start.bat service_bulder )
@REM IF %deployer% == 1 ( start _service_start.bat service_builder_kubernetes )

:ENDING
echo ENDED CREATING MEIGHEN RTDM!
@REM pause