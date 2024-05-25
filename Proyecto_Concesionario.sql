-- Crear la base de datos Concesionario
CREATE DATABASE IF NOT EXISTS Concesionario;
USE Concesionario;

-- Crear la tabla Usuario
CREATE TABLE Usuario (
    Nombre CHAR(255) PRIMARY KEY NOT NULL,
    Contraseña CHAR(255) NOT NULL
);

-- Crear la tabla Admin
CREATE TABLE Admin (
    NombreAdmin CHAR(255) PRIMARY KEY NOT NULL,
    ContraseñaAdmin CHAR(255) NOT NULL
);

-- Crear la tabla Auto
CREATE TABLE Auto (
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Modelo VARCHAR(255) NOT NULL,
    Transmision ENUM('Manual', 'Automatico') NOT NULL,
    Anio YEAR NOT NULL,
    Tipo ENUM('Deportivo', 'Todoterreno', 'Sedan', 'Exotico') NOT NULL,
    Precio DOUBLE NOT NULL,
    Fabricante VARCHAR(255) NOT NULL
);

-- Crear indices necesarios para referenciar a la tabla cita
CREATE INDEX idx_auto_modelo ON auto(Modelo);
CREATE INDEX idx_auto_anio ON auto(Anio);
CREATE INDEX idx_auto_precio ON auto(Precio);
CREATE INDEX idx_usuario_nombre ON usuario(Nombre);

-- Crear la tabla Cita
CREATE TABLE cita (
    Folio INT AUTO_INCREMENT PRIMARY KEY,
    NombreCliente VARCHAR(255),
    ModeloAuto VARCHAR(255),
    AnioAuto YEAR,
    PrecioAuto DOUBLE,
    UNIQUE (Folio),
    FOREIGN KEY (NombreCliente) REFERENCES usuario(Nombre),
    FOREIGN KEY (ModeloAuto) REFERENCES auto(Modelo),
    FOREIGN KEY (AnioAuto) REFERENCES auto(Anio),
    FOREIGN KEY (PrecioAuto) REFERENCES auto(Precio)
);

-- Insertar registros en Usuario
INSERT INTO Usuario (Nombre, Contraseña) VALUES
('usuario1', 'contraseña1'),
('usuario2', 'contraseña2'),
('usuario3', 'contraseña3'),
('usuario4', 'contraseña4'),
('usuario5', 'contraseña5');

-- Insertar registros en Admin
INSERT INTO Admin (NombreAdmin, ContraseñaAdmin) VALUES
('admin1', 'adminpass1'),
('admin2', 'adminpass2'),
('admin3', 'adminpass3'),
('admin4', 'adminpass4'),
('admin5', 'adminpass5');

-- Insertar registros en Auto
INSERT INTO Auto (Modelo, Transmision, Anio, Tipo, Precio, Fabricante) VALUES
('Mustang', 'Manual', 2023, 'Deportivo', 50000.00, 'Ford'),
('Civic', 'Automatico', 2022, 'Sedan', 35000.00, 'Honda'),
('Land Cruiser', 'Automatico', 2022, 'Todoterreno', 70000.00, 'Toyota'),
('Aventador', 'Automatico', 2023, 'Exotico', 300000.00, 'Lamborghini'),
('911', 'Manual', 2023, 'Deportivo', 120000.00, 'Porsche');

-- Insertar registros en Cita
INSERT INTO Cita (Nombre, Modelo, Anio, Precio) VALUES
('usuario1', 'Mustang', 2023, 50000.00),
('usuario2', 'Civic', 2022, 35000.00),
('usuario3', 'Land Cruiser', 2022, 70000.00),
('usuario4', 'Aventador', 2023, 300000.00),
('usuario5', '911', 2023, 120000.00);

-- Consulta la información de todas las citas junto con los nombres de los usuarios y los modelos de autos
SELECT C.Folio, U.Nombre AS Nombre_Usuario, A.Modelo AS Modelo_Auto, C.Anio, C.Precio
FROM Cita AS C
JOIN Usuario AS U ON C.Nombre = U.Nombre
JOIN Auto AS A ON C.Modelo = A.Modelo AND C.Anio = A.Anio AND C.Precio = A.Precio;


-- Consulta las citas para un modelo específico
SELECT * FROM Cita WHERE Modelo = 'Mustang';

-- Consulta el número de citas por año
SELECT Anio, COUNT(*) AS Num_Citas FROM Cita GROUP BY Anio;

-- Consulta autos por tipo y ordena por Precio
SELECT * FROM Auto WHERE Tipo = 'Deportivo' ORDER BY Precio DESC;

-- Consulta todas las citas de un usuario específico
SELECT * FROM Cita WHERE Nombre = 'usuario1';