# SendMessageBinding
Este proyecto se trata de una aplicación de mensajería codificada en java, pensada para usarse como aplicación Android en dispositivos móviles la cual muestra 2 contenedores de texto, uno con el usuario y la otra para introducir el mensaje, acto seguido, si se pulsa el boton de enviar/send, se abrirá otra pantalla mostrando el usuario introducido y el mensaje, gracias al viewBinding y el dataBinding aprendidos en clase.

Además de lo anterior, he aprendido el ciclo de vida de una activity, a cómo depurar y utilizar los recursos para cambiar el icono de la aplicación, hacer la aplicación para varios idiomas,...

## Output
![IMG_20221006_183044](https://user-images.githubusercontent.com/114143275/194369683-6c0ca7eb-45b6-40ee-8007-109639a11a9e.jpg)
![IMG_20221006_183102](https://user-images.githubusercontent.com/114143275/194369783-3f35024e-9c77-4c94-88a0-b2d6934d9b21.jpg)

## Clases

- public class User implements Serializable, Parcelable 
	Miembros:
			private String name;
			private String email;

- public class Message implements Serializable, Parcelable
	Miembros:
			private User user;
			private String content;

- public class SendMessageActivity extends AppCompatActivity

- public class ViewMessageActivity extends AppCompatActivity

- public class SendMessageApplication extends Application
## Comenzando 🚀
### Pre-requisitos 📋

```
Tener un disposivo móvil físico o virtual al que instalar esta aplicación
(Opcional)Disponer de Android Studio para probar la aplicación en mejor medida.
```

### Instalación 🔧

```
Asociar el dispositivo móvil al PC
Instalar el fichero apk en dicho dispositivo
```
## Construido con 🛠️


* [Android Studio](https://developer.android.com/studio?hl=es&gclid=Cj0KCQjwsrWZBhC4ARIsAGGUJurGAdx-oPvuyAU9ddQ2TA83jo1hjQ6ikda6c51NJQlYTCQwH56ulDMaAtcxEALw_wcB&gclsrc=aw.ds) - El SDK + IDE usado

## Autores ✒️

* **Fernando Escaño Martín** - *Trabajo Inicial*
* **Fernando Escaño Martín** - *Documentación*

## Licencia 📄

