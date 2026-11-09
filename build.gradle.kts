plugins {
    java
}

group = "dev.iga"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // Paper 26.3 - bei neuerem Build die Nummer anpassen
    compileOnly("io.papermc.paper:paper-api:26.3.build.143-beta")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(25)
}

tasks.jar {
    archiveBaseName.set("IncompleteGoldenApples")
}
