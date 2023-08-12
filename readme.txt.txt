readme.txt

--- instrucciones
Para el coorecto funcionamiento del proyecto a continuación les comparto unas instrucciones:
1. La base de datos del proyecto se manejo en mysql con XAMPP, el cual se solicita crear la BD con la siguiente sentencia
-------- create DATABASE pruebaduban --------- Luego crear la tabla empleado con los siguientes datos. 

create table empleado (
    id int PRIMARY KEY auto_increment not null,
    Nombres varchar(50) not null,
    Apellidos varchar(50) not null,
    T_Documento varchar(10) not null,
    Num_Documento varchar(10) not null,
    Fecha_Nacimiento date not null,
    Fecha_Vinculacion date not null,
    Cargo varchar(50) not null,
    Salario double not null
);

Tambien les comparto sentencia para ejecutar el post:
--- http://localhost:8095/EmpleadoRest/empleado ---

Nota: En la clase "application.properties" ubicada en la carpeta raiz "Other Sources" seguida de "src" se solicita que se configure la linea diez en 
caso que su gestor de base de datos lo mantenga con clave, de lo contrario no modificar y en la linea ocho por favor modificar el nombre de usuario 
que maneja en su gestor de base de datos.

Ahora les comparto un ejemplo del body 

{
    "nombres": "Camilo Andres",
    "apellidos": "Suarez",
    "tdocumento": "Cedula",
    "ndocumento": "1002403994",
    "fnacimiento": "1997-03-13",
    "fvinculacion": "2021-08-12",
    "cargo": "Desarrollador Junior",
    "salario": 2000000.0  
}

y ahora de un resultado de la ejecucion del post

{
    "mensaje": null,
    "empleados": [
        {
            "edad": "La edad es: 26 años 4 meses y 30 días",
            "tiempoVinculado": "El tiempo de servicio es: 2 años 0 meses",
            "nombres": "Camilo Andres",
            "apellidos": "Suarez",
            "tdocumento": "Cedula",
            "salario": 2000000.0,
            "fvinculacion": "2021-08-12T00:00:00.000+00:00",
            "ndocumento": "1002403994",
            "fnacimiento": "1997-03-13T00:00:00.000+00:00",
            "cargo": "Desarrollador Junior"
        }
    ]
}

Muchas gracias y espero que sea de ayuda esta pequeña explicación.... Dios los bendiga 
