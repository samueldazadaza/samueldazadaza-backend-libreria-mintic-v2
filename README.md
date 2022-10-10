"# api-books"

##### Intrucciones para correr y utilizar la api en local:

CLONAR REPOSITORIO:
https://github.com/samueldazadaza/backend-libreria-mintic
---
instrucciones para correr api en VISUAL STUDIO CODE
se crea una base de datos en mysql llamada 👉 springboot

y se ejecuta en la raiz del proyecto la sigiente linea

mvnw.cmd spring-boot:run

##### para utilizar la api books

---

CREATE /// para crear libro ejecuta en postman en POST a la url: http://localhost:8080/books
{
"titulo": "2 ///////// Años de Soledad22",
"autor": "Gabriel García Márquez",
"genero": "Realismo Mágico",
"fecha_publicacion": "1967-06-05",
"editorial": "Sudamericana de Buenos Aires",
"cantidad": 12,
"precio": 50000
}

READ /// para LEER libros ejecuta en postman en GET a la url: http://localhost:8080/books
//arrojara un array con los libros en base de datos mysql

UPDATE /// para modificar libro (agregas id a modificar en el endpoint EN FORMATO JSON) ejecuta en postman en POST a la url: http://localhost:8080/books
{
"id_libro": 3,
"titulo": "2 ///////// Años de Soledad22",
"autor": "Gabriel García Márquez",
"genero": "Realismo Mágico",
"fecha_publicacion": "1967-06-05",
"editorial": "Sudamericana de Buenos Aires",
"cantidad": 12,
"precio": 50000
}

DELETE /// para eliminar un libro, digita el id en la POSTMAN con el metodo DELETE, ejemplo: http://localhost:8080/books/1
//DIGITA EN EL ENDPOINT EL ID DEL LIBRO
// el back responde ----> "Se eliminó el libro con id 1"


para ver lista de libros por titulo: http://localhost:8080/libros/titulo?titulo=libro6
para ver lista de libros por autor: http://localhost:8080/libros/autor?autor=dan brown
para ver lista de libros por ID LIBRO: http://localhost:8080/libros/14


---

configuracion local anterior:

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto = update

---

configuracion remota: //(TODAVIA NO FUNCIONA BIEN)

# port

server.port=${PORT:8080}

spring.datasource.url = jdbc:mysql://db4free.net:3306/stocklibreria
spring.datasource.username = grupo09

# spring.datasource.password = Grupo092022*

spring.jpa.hibernate.ddl-auto = update

---

importar cors para acceso desde navegador:

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/libros")
public class LibrosController {

    --------------------

para correr en local es necesario correr XAMPP y activar APACHE y MYSQL
y ejecuta
mvnw.cmd spring-boot:run
👇👇👇// EL SERVIDOR QUEDARA ACTIVO EN LA URL👇
http://localhost:8080/books/


nueva base de datos en la nube: 
# port
server.port=${PORT:8090}

spring.datasource.url = jdbc:mysql://db4free.net:3306/libreriamintic
spring.datasource.username = grupo09mintic
spring.datasource.password = Grupo092022*mintic
spring.jpa.hibernate.ddl-auto = update 
# back-mintic2
# backend-libreria-mintic-v2
# samueldazadaza-backend-libreria-mintic-v2
