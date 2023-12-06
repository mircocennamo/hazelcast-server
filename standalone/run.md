

# START SERVER HAZELCAST SU  UBUNTU MACHINE
java -jar .\hazelcast-server.jar -Dhazelcast.config=hazelcast.xml

# START MANAGEMENT CENTER SU  UBUNTU MACHINE 
cd C:\hazelcast-5.3.6\management-center\bin
./start.sh 

#NB : nella cartella C:\hazelcast-5.3.6\management-center\bin\user-lib
è presente il jar SCNTT-Common-1.0-SNAPSHOT.jar 