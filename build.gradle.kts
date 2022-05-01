plugins {
    `kotlin-dsl`
    `maven-publish`
    groovy
}

groups = "dev.shuuyu.iridescent"
version = "1.0.0"

gradlePlugin {
    plugins {
        register("iridescent") {
            id = "dev.shuuyu.iridescent"
            implementationClass = "dev.shuuyu.iridescent.mcplatformplugin"
        }
        // This is just so people can use the myosyn title as well.
        register("iridescent-myosyn") {
            id = "dev.myosyn.iridescent"
            implementationClass = "dev.myosyn.iridescent.mcplatformplugin"
        }
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.minecraftforge.net")
    maven("https://jitpack.io")
    maven("https://maven.architectury.dev/")
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    implementation ("com.google.code.gson:gson:2.8.9")
	implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.0")
	implementation ("com.google.guava:guava:31.0.1-jre")
	implementation ("org.ow2.asm:asm:9.3")
	implementation ("org.ow2.asm:asm-analysis:9.3")
	implementation ("org.ow2.asm:asm-commons:9.3")
	implementation ("org.ow2.asm:asm-tree:9.3")
	implementation ("org.ow2.asm:asm-util:9.3")
    implementation ("com.guardsquare:proguard-gradle:7.2.0")

    // All minecraft related dependencies 
    implementation("dev.architectury.loom:dev.architectury.loom.gradle.plugin:0.11.0.260")
    implementation("dev.architectury.architectury-pack200:dev.architectury.architectury-pack200.gradle.plugin:0.1.3")
    implementation("com.github.replaymod:preprocessor:73d8bed")

    // Apparently Remap isn't updated to be 1.6.21 yet, so any version upwards from 1.6.10 breaks.
    // It doesn't matter though, because who actually cares about that?
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")

}