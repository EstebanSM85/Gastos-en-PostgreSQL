📘 Aplicación de Gestión de Gastos (Java + PostgreSQL)
Aplicación sencilla desarrollada en Java utilizando Eclipse, Maven y PostgreSQL.
Permite insertar y eliminar gastos diarios mediante una interfaz gráfica básica construida con Swing.

🚀 Funcionalidades
- ➕ Insertar un nuevo gasto
- ❌ Eliminar un gasto por ID
- 🗄️ Conexión real con PostgreSQL
- 🧱 Operaciones CRUD básicas
- 🖥️ Interfaz gráfica muy simple (dos botones)

🛠️ Tecnologías utilizadas
- Java 23
- Eclipse
- Maven
- PostgreSQL
- JDBC
- Swing

🗂️ Estructura del proyecto

  src/main/java/
   └── com.gastos
        ├── db
        │     └── ConexionPostgres.java
        ├── dao
        │     └── GastoDAO.java
        ├── ui
        │     └── InterfazGastos.java
        └── main
              └── Main.java



🧩 Base de datos
Base de datos: gastos_db
Tabla: gastos
 
    CREATE TABLE gastos (
        id SERIAL PRIMARY KEY,
        concepto VARCHAR(100) NOT NULL,
        cantidad NUMERIC(10,2) NOT NULL,
        fecha DATE NOT NULL
    );



⚙️ Configuración de conexión
Archivo: ConexionPostgres.java
  
    URL: jdbc:postgresql://localhost:5432/gastos_db
    Usuario: postgres
    Contraseña: contraseña oculta por seguridad



▶️ Ejecución
Desde Eclipse:
Run → Main.java
Desde terminal:

    mvn exec:java -Dexec.mainClass="com.gastos.main.Main"



🖼️ Capturas de pantalla
Interfaz principal (dos botones):

   <img width="283" height="143" alt="Captura de pantalla 2026-01-30 195635" src="https://github.com/user-attachments/assets/09f0a324-adda-48ef-b090-bebf782403a7" />

Formulario de inserción:

  <img width="262" height="209" alt="Captura de pantalla 2026-01-30 195730" src="https://github.com/user-attachments/assets/b591e73a-2e50-4ece-82de-71f24fd7d8f2" />

Registro insertado en PostgreSQL:

   <img width="519" height="437" alt="Captura de pantalla 2026-01-30 195351" src="https://github.com/user-attachments/assets/04995483-83e5-41e3-9fb1-7e06576b820d" />

Eliminación de gasto:

  <img width="290" height="122" alt="Captura de pantalla 2026-01-30 195403" src="https://github.com/user-attachments/assets/1f0eb81e-8f7e-4dd4-86a4-b1b16cf8d944" />


   <img width="522" height="305" alt="Captura de pantalla 2026-01-30 195425" src="https://github.com/user-attachments/assets/38cf8989-8f2c-42e6-bdcb-7cc19332370a" />


📄 Licencia
Proyecto de uso educativo.
