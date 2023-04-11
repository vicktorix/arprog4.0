-- SQLite
CREATE TABLE EMPLEADO(
   ID INT PRIMARY KEY     NOT NULL,
   DEPARTAMENTO_FK INT NOT NULL,
   DNI INT,
   NOMBRE CHAR(30),
   APELLIDO CHAR(30),
   NACIONALIDAD CHAR(30),
   FOREIGN KEY (DEPARTAMENTO_FK) REFERENCES DEPARTAMENTO(ID)
);