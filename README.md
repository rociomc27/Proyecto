# Proyecto
Repositorio donde se va a guardar nuestro trabajo :)

INFO PARA CORRECTO FUNCIONAMIENTO DEL BRANCH JAVAVERSION EN ECLIPSE

-------------------------------------------------------------------

Una vez descargado el repositorio y tener configurado un Workspace de eclipse habrá que importar el nuevo proyecto
como un proyecto ya existente de eclipse:

-File > Import... > Existing Project into Workspace > seleccionar la ruta del repositorio

Al importarse, lo siguiente será indicarle la ruta del servidor Apache Tomcat para que pueda crear las dependencias correspondientes:

-Click derecho en el proyecto > Targeted Runtimes > Seleccionar el servidor correspondiente

Si no aparece el servidor o estando seleccionado sigue sin funcionar, puede ser que no tengamos correctamente configurado un servidor.
Para configurarlo:

-Window > Preferences > Desplegamos "Server" > Runtime Enviroment

En caso de no haber ninguno:

-Add.. > Seleccionamos la carpeta en la que esté instalado Apache Tomcat

Si ya tenemos uno, verificamos que la ruta sea correcta.

Una vez hecho esto, en el estado actual del proyecto hay que añadir la carpeta "src" (tal cual, en minusculas) a la carpeta del proyecto.
Sin esta carpeta, Eclipse no puede "buildear" el proyecto y no compilará los fragmentos de codigo java además de que quedarán sin carpeta
ni estructura de archivos.
