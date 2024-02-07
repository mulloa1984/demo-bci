# Demo Bci

## Installation

Descargar el Spring Tool Suite, Motor Base Dato Mysql, Google Chrome.

### Pasos para Levantar el Servicio

```sh
1.- clonar el proyecto -> "git clone https://github.com/mulloa1984/demo-bci.git"
2.- ingresar a IDE: Spring Tool Suite 4 
    -> Import -> Exists Maven Projects -> seleccionar Path de proyecto
3.- En Caso de seleccionar H2 => Bd en Memoria ó Mysql. 
    -> Por Defecto las "demo-bci\src\main\resources\application.properties" estan apuntando a H2 
    -> Caso Mysql -> descomentar las lineas "Linea 5 hasta linea 8" y Comentar las Lineas "Linea 11 hasta Linea 21" 
    -> Ejecutar Script Path "demo-bci\src\main\resources\script.sql" en Mysql para crear la Base de Datos
4.- Deployed: 
    -> Seleccionar Proyect click Derecho -> Run As -> Spring Boot App -> click Izquierdo
```


## Pasos para Probar mediante Postman
```sh
1.- importar proyecto Postman -> import ruta "demo-bci\src\main\resources\Demo BCI.postman_collection.json" 
    -> se encontrara un servicio con la ruta "http://localhost:8080/auth/v1/register" y su respectivo JsonRequest
```

> Note: `Opcion Mysql` las tablas se crean de forma dinamica solo es necesario tener creado BD `securitydb`

Verifique la implementación navegando a la dirección de su servidor en
su navegador preferido..

```sh
http://localhost:8080/auth/v1/register
```

## Json Request
```JSON
{
"name": "miller ulloa gomez",
"email": "yugo1@gmail.com",
"password": "1234",
"phones": [
        {
        "number": "1234567",
        "citycode": "1",
        "contrycode": "57"
        },
        {
        "number": "12345678",
        "citycode": "2",
        "contrycode": "58"
        }
    ]
}
```

# Manual Uso Swagger

```sh
http://localhost:8080/doc/swagger-ui/index.html
```
> Note: `Cambiar Json de Ejemplo Swagger` Editar, Copia y pegar `Json Request` anterior mencionado. 

## Pasos Swagger
```sh
1.- click en boton POST /user-controller/register
2.- click en boton try it out
3.- Borrar Json Ejemplo y Pegar Json Request del manual.
4.- click en boton Execute
5.- revisar las respuestas.
```


## Autor

**Miller Ulloa Gomez**

[![N|Solid](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:yugo147@gmail.com)  

[![N|Solid](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/miller-ulloa-gomez/)  
