# Instrucciones de uso - MusicStream API

## 1️⃣ Crear la base de datos `musicstream_db` y ejecutar la aplicacion.
Primero se tiene que crear la base de datos "musicstream_db" en MySqL.
Después, se tiene que ejecutar la aplicación para generar las tablas. 

A continuación, ejecutar en MySQL:

```sql
CREATE DATABASE IF NOT EXISTS musicstream_db;
USE musicstream_db;

INSERT INTO artista (nombre_artista, pais_origen, genero_musical, fecha_debut) VALUES
('Coldplay', 'Reino Unido', 'Rock Alternativo', '1996-01-01'),
('Shakira', 'Colombia', 'Pop', '1991-02-15'),
('Ed Sheeran', 'Reino Unido', 'Pop', '2011-09-09'),
('Adele', 'Reino Unido', 'Soul', '2008-01-28'),
('Bruno Mars', 'Estados Unidos', 'Pop', '2010-10-04'),
('Bad Bunny', 'Puerto Rico', 'Reguetón', '2016-12-10'),
('Dua Lipa', 'Reino Unido', 'Pop', '2015-08-01'),
('The Weeknd', 'Canadá', 'R&B', '2013-07-01'),
('Imagine Dragons', 'Estados Unidos', 'Rock Alternativo', '2012-09-04'),
('Luis Fonsi', 'Puerto Rico', 'Pop Latino', '1998-05-13');

INSERT INTO cancion (titulo, duracion_segundos, fecha_lanzamiento, numero_reproducciones, id_artista) VALUES
('Viva La Vida', 242, '2008-05-25', 5000000, 1),
('Hips Don''t Lie', 218, '2006-02-28', 1800000, 2),
('Shape of You', 233, '2017-01-06', 3500000, 3),
('Rolling in the Deep', 228, '2010-11-29', 1200000, 4),
('Uptown Funk', 270, '2014-11-10', 3000000, 5),
('Dakiti', 205, '2020-10-30', 1500000, 6),
('Levitating', 203, '2020-03-27', 1800000, 7),
('Blinding Lights', 200, '2019-11-29', 4000000, 8),
('Radioactive', 186, '2012-10-29', 9000000, 9),
('Despacito', 229, '2017-01-13', 7500000, 10);
```

---
Con la aplicación corriendo se puede seguir con el siguiente punto.
## 2️⃣ Probar en Postman

Es recomendable usar el archivo `musicstream_db_registros.sql` antes de realizar pruebas.

### 🎤 Endpoints de Artistas

- **Todos los artistas**
```
GET: http://localhost:8080/api/artistas
```
- **Un solo artista**
```
GET: http://localhost:8080/api/artistas/3
```
- **Crear artista**
```
POST: http://localhost:8080/api/artistas
Body (JSON):
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
```
- **Editar artista**
```
PUT: http://localhost:8080/api/artistas/3
Body (JSON):
{
    "nombreArtista": "Good Kind",
    "paisOrigen": "Canadá",
    "generoMusical": "Rock",
    "fechaDebut": "2015-05-01",
    "canciones": []
}
```
- **Eliminar artista**
```
DELETE: http://localhost:8080/api/artistas/9
```

---

### 🎵 Endpoints de Canciones

- **Listar todas las canciones**
```
GET: http://localhost:8080/api/canciones
```
- **Una canción**
```
GET: http://localhost:8080/api/canciones/4
```
- **Crear una canción**
```
POST: http://localhost:8080/api/canciones
Body (JSON):
{
    "titulo": "Dos historias",
    "duracionSegundos": 230,
    "fechaLanzamiento": "1990-10-10",
    "numeroReproducciones": 1800000,
    "artista": {
        "idArtista": 10
    }
}
```
- **Eliminar una canción**
```
DELETE: http://localhost:8080/api/canciones/10
```

---

### 📊 Endpoints de Reportes

- **Reportes por género**
```
GET: http://localhost:8080/api/reportes/genero/Pop
```
- **Reportes por estadísticas**
```
GET: http://localhost:8080/api/reportes/estadisticas
```
- **Top artistas**
```
GET: http://localhost:8080/api/reportes/top-artistas/2
```

---
📌 **Nota:** Asegúrate de que el servidor Spring Boot esté ejecutándose antes de probar los endpoints.
