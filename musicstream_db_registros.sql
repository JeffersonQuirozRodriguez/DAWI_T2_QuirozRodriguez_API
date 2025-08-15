CREATE DATABASE IF NOT EXISTS musicstream_db;
use musicstream_db;
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
