@echo off
cd target\
javac -classpath ".;lib/jpos-1.7.0.jar;lib/jdom-1.1.jar;lib/commons-cli-2.0.jar" -d . ..\source\net\iso8583\server\*
java -classpath ".;lib/jpos-1.7.0.jar;lib/jdom-1.1.jar;lib/commons-cli-2.0.jar" net.iso8583.server.Application
cd ..