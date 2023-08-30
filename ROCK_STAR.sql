CREATE DATABASE ROCK_STAR;
USE ROCK_STAR;

CREATE TABLE Rol (
    tipo_rol varchar (50) primary key 
    );

CREATE TABLE Administrador (
    id int primary key auto_increment,
    nombre varchar(50),
    correo varchar(50),
    documento int,
    tipo_rol varchar (50),
    foreign key (tipo_rol) references Rol (tipo_rol)
    );

CREATE TABLE Productos (
    id INT PRIMARY KEY auto_increment,
    nombre VARCHAR(255),
    descripcion TEXT,
    precio DECIMAL(10, 2),
    cantidad INT
);

CREATE TABLE Pedidos (
    id INT PRIMARY KEY auto_increment,
    ciudad varchar (50),
    fecha_envio date,
    fecha_entrega DATE,
    nombre_cliente VARCHAR(255),
    direccion_envio VARCHAR(255),
    total DECIMAL(10, 2)
);


select * from productos;

