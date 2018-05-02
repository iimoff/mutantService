# mutantService

##ENTORNO DE DESARROLLO UTILIZADO:

java version  1.8.0_151-b12
maven version 3.5.3
windows 10 version 10.0
Spring Tool Suite Version: 3.9.4.RELEASE

##PRECONDICIONES:

1) Dada que la dependencia "matrixFinder" no se encutra subida a un repo maven, la misma debe ser descargada desde 
	"https://github.com/iimoff/matrixFinder.git" y luego compilada sieguiendo los pasos descriptos en su README.md
2) Se debe tener una instancia de mongoDb levantada para que los casos de prueba puedan ser ejecutados y el war compilado.

##PASOS:
1) Descargar el proyecto en la carpeta deseadadb
2) Antes de compilar la dependencia, levantar una instancia de mongo para que se puedan ejecutar los casos de prueba
    Linux "sudo service mongod start"
    Windos "mongod"
3) Para compilar el proyecto la carperta raiz del proyecto y generar el war ejecutar el comando "mvn clean install" en esta caso "mutantService"
4) Una vez ejecutado el paso anterior, se pueden revisar las metricas de test coverage en "mutantService\target\site\jacoco\index.html"
5) Para correr el proyecto en forma local, sobre la carperta raiz del proyecto ejecutar "mvnw spring-boot:run"
6) Para subir el proyecto, el mismo se subio a un Tomcat8, dentro de un nodo EC2 con ubuntu 16.04 de AWS.

##DUDAS Y/O COMENTARIOS

ivanhoff.01@gmail.com