# ESTRUCTURA BASE DEL PROYECTO


## 1. Estructura general del proyecto   

---

El proyecto **EscuelaDeMusica** está organizado con el estándar de **Maven** y utiliza **JavaFX** para la interfaz gráfica. La estructura evidencia una separación de componentes y recursos.


## 2. Descripción por secciones

---
### **a. Código fuente**
Ubicado en `src/main/java/org/example/escuelademusica/`, contiene las clases principales:
- **HelloApplication.java** es la clase principal que inicia el JavaFX.
- **HelloController.java** es la gestiona la lógica de la interfaz.
- **Launcher.java** es una clase auxiliar para el lanzamiento del programa.
- `module-info.java`  define el módulo y dependencias del proyecto.

### **b) Recursos**
En `src/main/resources/org/example/escuelademusica/`, se almacena la vista:
- **hello-view.fxml** que es un archivo FXML con la estructura visual de la aplicación.

### **c) Archivos de configuración**
- **pom.xml**  gestiona dependencias y el ciclo de construcción con Maven.

### **d) Documentación**
- Carpeta `info/`  contiene archivos de referencia y mockups.
- Carpeta `model/`  incluye diagramas y modelos del sistema en formato HTML, PNG y texto.

---

# FIN POR AHORA


