Pasos para Levantar el ApiRest 
1.- clonar el proyecto 
  -> "git clone https://github.com/mulloa1984/demo-bci.git"
2.- ingresar a IDE: Spring Tool Suite 4
  -> Import -> Exists Maven Projects
  -> seleccionar Path de proyecto
3.- En Caso de seleccionar H2 => Bd en Memoria  ó  Mysql.
  -> Por Defecto las "demo-bci\src\main\resources\application.properties" estan apuntando a H2
  -> en Caso Usar Mysql -> descomentar las lineas "Linea 5 hasta linea 8" y Comentar las Lineas "Linea 11 hasta Linea 21"
  -> Ejecutar Script de Ruta "demo-bci\src\main\resources\script.sql" en el Motor Mysql para crear la Base de Datos
4.- Deployed:  seleccionar proyect con segundo click Derecho
  -> Run As -> Spring Boot App -> click Izquierdo

Pasos para Probar mediante Postman
1.- importar proyecto Postman 
  -> import ruta "demo-bci\src\main\resources\Demo BCI.postman_collection.json"
  -> se encontrara un servicio con la ruta "http://localhost:8080/auth/v1/register" y su respectivo JsonRequest
