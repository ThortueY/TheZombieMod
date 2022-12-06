@echo off 
--variables

set title=CONSOLE FranceRP
set jar=spigot-1.16.5.jar
set minram=1G
set maxram=2G

--code 
color 73
title Console - %title%
cls
echo ========================
echo !!                    !!
echo !!  CONSOLE FranceRP  !!
echo !!                    !!
echo ========================
echo.
echo.
echo starting server
echo.
echo.
java.exe -Xms%minram% -Xmx%maxram% -jar %jar% nogui
echo.
echo.
color 0c
echo server stopped
pause>nul