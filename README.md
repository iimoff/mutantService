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
1) Descargar el proyecto en la carpeta deseada mediante git clone
2) Antes de compilar la dependencia, levantar una instancia de mongo para que se puedan ejecutar los casos de prueba
    Linux "sudo service mongod start"
    Windows "mongod"
3) Para compilar el proyecto la carperta raiz del proyecto y generar el war, ejecutando el comando "mvn clean install" en este caso "mutantService"
4) Una vez ejecutado el paso anterior, se pueden revisar las métricas de test coverage en "mutantService\target\site\jacoco\index.html"
5) Para correr el proyecto en forma local, sobre la carperta raiz del proyecto ejecutar "mvnw spring-boot:run"
6) Para subir el proyecto, el mismo fue subido a un Tomcat8, dentro de un nodo EC2 con ubuntu 16.04 de AWS.
8) Urls para probar la instalación local:

	POST http://localhost:8080/mutant 	
	
	GET   http://localhost:8080/stats	

##OBSERVACIONES

La app fue deployada en un nodo EC2, no llegue a poner un load balancer ELB de amazon para distribuir la demanda de request entre distintos nodos de un cluster, y de esta forma poder escalar la app según sea requerido.

##DUDAS Y/O COMENTARIOS

ivanhoff.01@gmail.com
