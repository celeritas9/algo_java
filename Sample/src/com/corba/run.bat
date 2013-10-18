SET JAVA_HOME=C:\cygwin\opt\java\1_6_0

mkdir classes

%JAVA_HOME%\bin\idlj -fall -td classes Hello.idl
%JAVA_HOME%\bin\javac -classpath classes -d classes HelloServant.java Server.java Client.java

REM - Start the ORB daemon

start %JAVA_HOME%\bin\orbd -ORBInitialPort 10001 -ORBDebug orbd
@echo Wait 10-15 seconds for the orbd to start
@pause

REM - Register the persistent server with orbd using servertool

%JAVA_HOME%\bin\java com.sun.corba.se.impl.activation.ServerTool -ORBInitialPort 10001 -cmd register -server Server -classpath classes

%JAVA_HOME%\bin\java -classpath classes Client -ORBInitialPort 10001

@echo Done!
@pause