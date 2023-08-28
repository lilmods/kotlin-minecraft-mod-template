## How this template can save you a lot of time

_Read the documentation below to know how to initialize your mod from this template. It's fast as you just have to search and replace text._

Don't lose time setting up your project, everything is ready is this template, including:
- 📂 **All your code in the same repository**: Multi module gradle project set up and ready to use including forge, fabric, and common code
- 🆕 **Gradle 8**: Project is ready and uses Gradle 8, for both fabric and forge
- ⚙️ **Mod settings**: For both fabric & forge, mod settings template is ready, you just have to define the settings of your mod. Powered by cloth config.
- 👷 **Continuous integration**: On each push / pull request (customizable), github triggers a workflow that will check and build both fabric and forge. The artefacts are downloadable from the web interface
- 🚚 **Continuous delivery**: On each tag pushed on the main branch (customizable), github triggers a workflow that builds and automatically creates a release with the artefacts and the changelog.
- ⏩ **Easy to update**: All the versions are stored in one file [Versions.kt](buildSrc/src/main/kotlin/com/example/gradle/Versions.kt). It allows you to update the project without modifying gradle files.
- ✅ **Linting**: Linting is included and automatically checks your code to make sure you follow kotlin coding conventions. It can be customized as it relies on ktlint.
- 🇰 **Kotlin**: Be more productive by using Kotlin instead of Java. Try it out, you won't come back to Java.

Versions:
- Minecraft `1.20.1`
- Gradle `8.1.1`
- Kotlin `1.9.10`
More details in [Versions.kt](buildSrc/src/main/kotlin/com/example/gradle/Versions.kt)

## How to use this template for your mods

### 1. Open project with intelliJ

_It should work with other IDE, it only depends on gradle, I did not test it_

Load gradle project, it may crash because of SDK errors, in that case:
- Make sure that you are using java jdk 17 (File > Project Structure > SDK > Select JDK 17 & language level SDK Default)
- Make sure that gradle uses jdk 17 (File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM: Select Project SDK)
- Reload gradle project

### 2. Search & remplace:

- `{license}`: The mod license. Example: `GNU-LGPL-3.0`
- `{githubUser}`: The user that owns the github repo. Example: `lilmods`
- `{githubRepo}`: The name of the github repo. Example: `kotlin-minecraft-mod-template`
- `{author}`:  The author of the mod. It will be in the mod description (forge & fabric)
- `modid` **(and not `modId` !!!)**: The mod id. Has to be unique across mc mods. **Make sure to also rename [modid.mixins.json](fabric/src/main/resources/modid.mixins.json)**
- `com.example.modid`: The mod package. Has to be unique across mc mods to prevent conflits on runtime. Make sure to also rename filenames.
- `ModName`: The mod name. Make sure to also rename filenames.
- `ModDescription`: The mod description
- Replace [LICENSE](LICENSE) file with your license
- Make sure [Versions.kt](buildSrc/src/main/kotlin/com/example/gradle/Versions.kt) is correct.

Now you can reload gradle project. You should be able to build and run clients. If it's not the case, you renamed
something wrong. You can see an example here: https://github.com/lilmods/aim-assistance/commit/44743e66f04cde44ad8ccb9490b680069f874c1d.

#### Troubleshooting:

If the build below says "passing" and it does not work in your environment, it means that you did something wrong because
the CI built the project properly.

- [![build fabric](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/build-fabric.yml/badge.svg?branch=main)](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/build-fabric.yml)
- [![build forge](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/build-forge.yml/badge.svg?branch=main)](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/build-forge.yml)

If you have an issue, it could be because of:
- Wrong rename: 
  - Take a look at https://github.com/lilmods/aim-assistance/commit/44743e66f04cde44ad8ccb9490b680069f874c1d to see an example of template init
  - Open git diff with intelliJ, to check every change you made, something may be wrong
  - You may have forgotten to rename something (folder or filename for example)
- Caching issues
  - Try to stop gradle daemon: `./gradlew --stop`
  - Try to restart intelliJ: `Files > Invalidate caches & restart`
  - Delete gradle cache: `~/.gradle/caches` (you will need to re-download everything)

### 3. Updating versions

All the versions of libraries are stored in [Versions.kt](buildSrc/src/main/kotlin/com/example/gradle/Versions.kt).
The file is documented for you to know how to bump versions.

### 4. Releasing new versions

Put a tag on any branch following this format:
- fabric: `1.0.0-MC1.19.x-fabric`
- forge: `1.0.0-MC1.19.x-forge`

The CD workflows are defined in [.github/workflows](.github/workflows) folder. The release will then be "deployed" on
github. In the releases tab, you will see your new version with a changelog that contains everything you did put on
[CHANGELOG-forge.md](CHANGELOG-forge.md) (for forge) and [CHANGELOG-fabric.md](CHANGELOG-fabric.md) (for fabric).

You can see example of releases published from this repo here https://github.com/lilmods/kotlin-minecraft-mod-template/releases

- [![release fabric](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/release-fabric.yml/badge.svg?branch=main)](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/release-fabric.yml)
- [![release forge](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/release-forge.yml/badge.svg?branch=main)](https://github.com/lilmods/kotlin-minecraft-mod-template/actions/workflows/release-forge.yml)

### 5. Put the common code in the common module!

If you have common code between forge and fabric, you can put it in the `common` module (you can rename it if you want).
The code will then be packaged in the `.jar` produced by fabric and forge.

### 6. The project has a linter

It forced you to follow some conventions. In the root [build.gradle.kts](build.gradle.kts), `ktlint` is imported. You
can remove it if you want, in that case, you have to remove the step in the CI workflows 
[.github/workflows](.github/workflows). There is an IntelliJ plugin to help you. You also can customize the ktlint
configuration by looking on their official documentation.

### 7. The project automatically builds .jar

Everytime the CI runs and succeed, produced artefacts are stored in the workflow run summary. For example, as you can
see in https://github.com/lilmods/kotlin-minecraft-mod-template/actions/runs/5111050925, there is an "Artifacts" block.
You can click on it to download the produced .jar files.

### 8. Fabric specific stuff to know

This project uses Kotlin. However, mixins does not work with Kotlin for now, so it's written in Java. There are some
examples. The template uses `modmenu` & `cloth-config` to manage the mod settings. Everything is ready.

Run client: execute `runClient` gradle task.

### 9. Forge specific stuff to know

The template uses `cloth-config` to manage the mod settings. Everything is ready.

Run client: execute `runClient` gradle task

### 10. Done !

You can delete everything in the readme from this line, you are ready to go, have fun :)

# ModName

[![build fabric](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-fabric.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-fabric.yml)
[![build forge](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-forge.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/build-forge.yml)
[![release fabric](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-fabric.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-fabric.yml)
[![release forge](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-forge.yml/badge.svg?branch=main)](https://github.com/{githubUser}/{githubRepo}/actions/workflows/release-forge.yml)
