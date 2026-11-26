@echo off
setlocal EnableExtensions DisableDelayedExpansion
chcp 65001 >nul
if "%~1"=="" goto usage
set "EXAMPLE_DIR=%~dp0examples\%~1"
if not exist "%EXAMPLE_DIR%\main-class.txt" (
  echo Unknown example: %~1
  exit /b 2
)
set "JAVAC_EXE=javac"
set "JAVA_EXE=java"
if exist "%JAVA_HOME%\bin\javac.exe" (
  set "JAVAC_EXE=%JAVA_HOME%\bin\javac.exe"
  set "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
) else if exist "C:\Program Files\Android\Android Studio\jbr\bin\javac.exe" (
  set "JAVAC_EXE=C:\Program Files\Android\Android Studio\jbr\bin\javac.exe"
  set "JAVA_EXE=C:\Program Files\Android\Android Studio\jbr\bin\java.exe"
)
set "BUILD_DIR=%~dp0build\%~1"
if not exist "%BUILD_DIR%" mkdir "%BUILD_DIR%"
set /p MAIN_CLASS=<"%EXAMPLE_DIR%\main-class.txt"
set "MAIN_SOURCE=%MAIN_CLASS:.=\%.java"
"%JAVAC_EXE%" -encoding UTF-8 -classpath "%BUILD_DIR%" -sourcepath "%EXAMPLE_DIR%\src" -d "%BUILD_DIR%" "%EXAMPLE_DIR%\src\%MAIN_SOURCE%"
if errorlevel 1 exit /b 1
pushd "%~dp0runtime"
"%JAVA_EXE%" -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 -cp "%BUILD_DIR%" "%MAIN_CLASS%" %2 %3 %4 %5 %6 %7 %8 %9
set "RUN_RESULT=%ERRORLEVEL%"
popd
exit /b %RUN_RESULT%
:usage
echo Usage: run-example.cmd EXAMPLE_ID [program arguments]
echo Examples:
echo   run-example.cmd ch3-p06
echo   run-example.cmd ch4-p29
echo   run-example.cmd ch5-p40 test3.txt
echo   run-example.cmd extra-grade 80 95 70 60
echo See examples.json or the page mapping document for all IDs.
exit /b 0
