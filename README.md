## How to use this template for your mods:

Versions:
- Minecraft `1.19.4`
- Gradle `8.1.1`
- Kotlin `1.8.21`
More details in [Versions.kt](buildSrc/src/main/kotlin/com/example/gradle/Versions.kt)

### 1. Open project with intelliJ

_It should work with other IDE, it only depends on gradle, I did not test it_

Load gradle project, it may crash because of SDK errors, in that case:
- Make sure that you are using java jdk 17 (File > Project Structure > SDK > Select JDK 17 & language level SDK Default)
- Make sure that gradle uses jdk 17 (File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM: Select Project SDK)
- Reload gradle project

### 2. Search & remplace:

- `{license}`: The mod license
- `{githubUser}`: The user that owns the github repo. Example: `lilmods`
- `{githubRepo}`: The name of the github repo. Example: `kotlin-minecraft-mod-template`
- `{author}`:  The author of the mod. It will be in the mod description (forge & fabric)
- `modid`: The mod id. Has to be unique across mc mods.
- `com.example.modid`: The mod package. Has to be unique across mc mods to prevent conflits on runtime.
- `ModName`: The mod name
- `ModDescription`: The mod description

### 3. Updating versions

All the versions of libraries are stored in [Versions.kt](buildSrc/src/main/kotlin/com/example/gradle/Versions.kt).
The file is documented for you to know how to bump versions.

### 4. Releasing new versions

Put a tag on any branch following this format:
- fabric: `1.0.0-MC1.19.x-fabric`
- forge: `1.0.0-MC1.19.x-forge`

The CD workflows are defined in [.github/workflows](.github/workflows) folder. The release will then be "deployed" on
github. In the releases tab, you will see your new version with a changelog that contains everything you did put on
[CHANGELOG.md](CHANGELOG.md).

### 5. Put the common code in the core module!

If you have common code between forge and fabric, you can put it in the `core` module (you can rename it if you want).
The code will then be packaged in the `.jar` produced by fabric and forge.

### 6. The project has a linter

It forced you to follow some conventions. In the root [build.gradle.kts](build.gradle.kts), `ktlint` is imported. You
can remove it if you want, in that case, you have to remove the step in the CI workflows 
[.github/workflows](.github/workflows). There is an IntelliJ plugin to help you. You also can customize the ktlint
configuration by looking on their official documentation.

### 7. Fabric specific stuff to know

This project uses Kotlin. However, mixins does not work with Kotlin for now, so it's written in Java. There are some
examples. The template uses `modmenu` & `cloth-config` to manage the mod settings. Everything is ready.

Run client: execute `runClient` gradle task.

### 8. Forge specific stuff to know

The template uses `cloth-config` to manage the mod settings. Everything is ready.

Run client: execute `runClient` gradle task

### 9. Done !

You can delete everything in the readme from this line, you are ready to go, have fun :)

# ModName

[![build fabric](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-fabric.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-fabric.yml)
[![build forge](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-forge.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-forge.yml)
[![release fabric](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-fabric.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-fabric.yml)
[![release forge](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-forge.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-forge.yml)
