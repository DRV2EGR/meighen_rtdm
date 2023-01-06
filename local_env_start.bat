@echo off

echo Hello!
@REM echo "%*"

SET /A guarder_flg = 0
SET /A presenter_flg = 0

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
    echo %%i- "!argVec[%%i]!"

    IF "!argVec[%%i]!" == "-g" (set /A guarder_flg = 1)
    IF "!argVec[%%i]!" == "-p" (set /A presenter_flg = 1)
)

@REM Основные сервисы
start _service_start.bat eureka
start _service_start.bat gateway

@REM Сервисы с параметрами
IF %guarder_flg% == 1 ( start _service_start.bat guarder )
IF %presenter_flg% == 1 ( start _service_start.bat presenter )

pause