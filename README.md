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
tuya y ajusta Navigation


