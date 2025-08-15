//PARA PROBAR EN POSTMAN:
Es recomendable tener usar el musicstream_db_registros.sql
Todos los artistas
GET: http://localhost:8080/api/artistas

Un solo artista
GET: http://localhost:8080/api/artistas/3

Crear artista
POST: http://localhost:8080/api/artistas ->
{
"nombreArtista": "Gian Marco",
"paisOrigen": "Peru",
"generoMusical": "Pop",
"fechaDebut": "1990-01-01",
"canciones": [
{
"titulo": "Se me olvidó",
"duracionSegundos": 245,
"fechaLanzamiento": "2002-01-01",
"numeroReproducciones": 900000
}
]
}

Editar artista
PUT: http://localhost:8080/api/artistas/3
{
"nombreArtista": "Good Kind",
"paisOrigen": "Canadá",
"generoMusical": "Rock",
"fechaDebut": "2015-05-01",
"canciones": []
}

Eliminar artista
DELETE: http://localhost:8080/api/artistas/9

>>>Para las canciones:

Listar todas las canciones:
http://localhost:8080/api/canciones

Una cancion:
http://localhost:8080/api/canciones/4

Crear una cancion:
http://localhost:8080/api/canciones
{
"titulo": "Dos historias",
"duracionSegundos": 230,
"fechaLanzamiento": "1990-10-10",
"numeroReproducciones": 1800000,
"artista": {
"idArtista": 10
}
}

Eliminar una cancion:
http://localhost:8080/api/canciones/10

>>Reportes

Reportes por genero:
http://localhost:8080/api/reportes/genero/Pop

Reportes por estadisticas:
http://localhost:8080/api/reportes/estadisticas
Top artistas:
http://localhost:8080/api/reportes/top-artistas/2