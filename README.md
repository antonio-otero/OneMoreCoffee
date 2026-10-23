# OneMoreCoffee · estado al cerrar la UD03

Proyecto de Android Studio del hilo conductor de PMDM, tal como queda al final del guion
*OneMoreCoffee · De la UD02 a la UD03*: tres fragmentos con Navigation y Safe Args,
imágenes por tipo y por café, tema propio, icono adaptativo y transiciones entre pantallas.

## Abrirlo

1. Descomprime el zip en una carpeta tuya.
2. Android Studio → **File → Open** → la carpeta `OneMoreCoffee` (la que contiene `settings.gradle.kts`).
3. Deja que haga el *Sync*. La primera vez descarga Gradle 9.6.0 y las dependencias.
4. Si pide instalar la plataforma **Android API 37**, acepta: es el `compileSdk` del proyecto.

## Versiones

| Pieza | Versión | Dónde se cambia |
|---|---|---|
| Android Gradle Plugin | 9.4.1 | `gradle/libs.versions.toml` |
| Gradle | 9.6.0 | `gradle/wrapper/gradle-wrapper.properties` |
| Navigation y Safe Args | 2.10.2 | `libs.versions.toml` y `build.gradle.kts` de la raíz: **las dos, iguales** |
| compileSdk / targetSdk / minSdk | 37 / 36 / 24 | `app/build.gradle.kts` |

No hay plugin `org.jetbrains.kotlin.android`: desde AGP 9.0 el soporte de Kotlin va integrado
y aplicarlo además da error. Safe Args es `androidx.navigation.safeargs.kotlin` y va **el último**
del bloque `plugins` del módulo.

Si tu Android Studio genera proyectos con otro AGP, cambia la línea `agp` del catálogo por la
tuya y ajusta Navigation según la tabla del guion (§1.4).

## Qué está comprobado y qué no

Comprobado fuera de Android Studio:

- Todo el Kotlin compila con `kotlinc` 2.4.21 contra el binding, la clase `R` y las clases de
  Safe Args **generados a partir de los XML de este mismo proyecto**.
- Todas las referencias `@string`, `@color`, `@drawable`, `@anim`… de los XML existen, y los
  nombres de recurso son válidos.
- Los XML están bien formados.

**No comprobado:** no se ha pasado Gradle ni se ha ejecutado en un emulador, porque el entorno
donde se generó no tiene acceso a los repositorios de Google. Si el *Sync* o el *Assemble*
fallan, el primer sospechoso son las versiones del catálogo.

## Lista de prueba

- [ ] Arranca en la selección, con título en la barra y **sin** flecha.
- [ ] Cambiar el tipo cambia la imagen de cabecera sin pulsar nada.
- [ ] «Recoméndame» desliza a la lista del tipo elegido, con su imagen en la banda.
- [ ] «Sorpréndeme» da una sola recomendación (singular en la cabecera).
- [ ] Pulsar un café abre su ficha: foto, nombre, estrellas y descripción.
- [ ] Girar en la ficha: foto a la izquierda, texto a la derecha.
- [ ] La flecha de la barra se ve clara sobre el marrón y hace lo mismo que el «atrás» del sistema.
- [ ] Las filas de la lista llevan icono y `›`; abajo, una curiosidad que cambia al volver a entrar.
- [ ] Bajo el desplegable, la descripción cambia con el tipo.
- [ ] Girar en la lista o en la ficha no pierde el tipo ni el café.
- [ ] Modo oscuro: barra, botones y cabecera cambian de color.
- [ ] Con el emulador en castellano, los textos salen en castellano.

## Las imágenes

Las de `app/src/main/res/drawable-nodpi/` son **provisionales**: ilustraciones sencillas, sin
texto, con el nombre y el tamaño de la tabla del anexo del guion (§8). Para cambiarlas por las
definitivas, sustituye cada archivo por otro **con el mismo nombre**, en WebP, y haz
**Build → Clean Project** y **Build → Assemble Project**.

## Diferencias con el guion

- **El icono** está hecho a mano como vector (`drawable/ic_launcher_foreground.xml`) en lugar de
  con *Image Asset Studio*, para no depender de una imagen. Los PNG de `mipmap-*dpi` son la
  reserva para API 24 y 25. En clase se hace con *Image Asset Studio* (§3.5).
- **Sin fuente propia**: en el guion es opcional.
- `values-es/` trae la traducción al castellano; los textos por omisión están en gallego.
- `tvTitulo` sigue en `fragment_seleccion.xml`, aunque el título ya sale en la barra:
  el guion deja su borrado como pregunta para el grupo (§4.6).
