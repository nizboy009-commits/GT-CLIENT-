# GT Client — Fabric 1.20.1 starter source

This project is configured for Minecraft Java Edition 1.20.1, Fabric Loader, and Java 17. On client startup it lowers view distance (max 8), simulation distance (max 5), particles (minimal), and entity distance scaling (max 0.75). These settings may improve FPS on some devices but cannot guarantee a particular FPS or work on every customized launcher.

## Build
Run `./gradlew build` with Java 17 and an internet connection. The output JAR is created in `build/libs/`.

This is source code, not a compiled/tested JAR. It has not been compiled in this environment because network access to Gradle/Maven repositories is unavailable. Test in a separate profile before using it in your main game.
