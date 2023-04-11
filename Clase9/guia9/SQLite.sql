-- SQLite
create table Departamento(id int primary key autoincrement , nombre character(30));

create table Empleados(id INT primary key autoincrement, departamento_fk int, dni int, nombre character(30), apellido character(30), nacionalidad character(30), foreign key (departamento_fk) references Departamentos(id));


