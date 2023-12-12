# crea un cluster hazelcast
java -jar ./hazelcasr
# Avviare il management-center
# inserire nella cartella user-lib il jar SCNTT-Common-1.0-SNAPSHOT.jar
# nella cartella standalone/management-center

java -jar .\hazelcast-management-center-5.3.3.jar 

# collegarsi con il cluster usando il file client hazelcast-client.xml (presente nel progetto KafkaConsumer)

http://localhost:8080/mancenter


# url swagger
http://localhost:10000/swagger-ui/index.html