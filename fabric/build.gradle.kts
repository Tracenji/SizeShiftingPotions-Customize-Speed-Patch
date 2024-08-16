import me.ultrusmods.sizeshiftingpotions.gradle.Properties
import me.ultrusmods.sizeshiftingpotions.gradle.Versions
import net.fabricmc.loom.task.RemapJarTask
import org.gradle.jvm.tasks.Jar

plugins {
    id("conventions.loader")
    id("fabric-loom")
    id("me.modmuss50.mod-publish-plugin")
}

repositories {
    maven {
        name = "TerraformersMC"
        url = uri("https://maven.terraformersmc.com/")
    }
}

dependencies {
    minecraft(libs.minecraft);
    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.api)
    modLocalRuntime(libs.modmenu)

    modImplementation(libs.pehkui.fabric)
    modImplementation(libs.midnightlib.fabric)
    include(libs.midnightlib.fabric)
}

loom {
    val aw = file("src/main/resources/${Properties.MOD_ID}.accesswidener");
    if (aw.exists())
        accessWidenerPath.set(aw)
    mixin {
        defaultRefmapName.set("${Properties.MOD_ID}.refmap.json")
    }
    mods {
        register(Properties.MOD_ID) {
            sourceSet(sourceSets["main"])
            sourceSet(sourceSets["test"])
        }
    }
    runs {
        named("client") {
            client()
            configName = "Fabric Client"
            setSource(sourceSets["test"])
            ideConfigGenerated(true)
            vmArgs("-Dmixin.debug.verbose=true", "-Dmixin.debug.export=true")
        }
        named("server") {
            server()
            configName = "Fabric Server"
            setSource(sourceSets["test"])
            ideConfigGenerated(true)
            vmArgs("-Dmixin.debug.verbose=true", "-Dmixin.debug.export=true")
        }
        register("datagen") {
            server()
            configName = "Fabric Datagen"
            setSource(sourceSets["test"])
            ideConfigGenerated(true)
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file("../common/src/generated/resources")}")
            vmArg("-Dfabric-api.datagen.modid=${Properties.MOD_ID}")
            runDir("build/datagen")
        }
    }
}

tasks {
    named<ProcessResources>("processResources").configure {
        exclude("${Properties.MOD_ID}.cfg")
    }
}

publishMods {
    file.set(tasks.named<Jar>("remapJar").get().archiveFile)
    modLoaders.add("fabric")
    changelog = rootProject.file("CHANGELOG.md").readText()
    displayName = "Size Shifting Potions Fabric ${Versions.MOD}+${libs.minecraft.get().version}"
    version = "${Versions.MOD}+${libs.minecraft.get().version}-fabric"
    type = STABLE

    curseforge {
        projectId = Properties.CURSEFORGE_PROJECT_ID
        accessToken = providers.gradleProperty("CF_API_KEY")

        minecraftVersions.add(libs.minecraft.get().version!!)
        javaVersions.add(JavaVersion.VERSION_21)

        clientRequired = true
        serverRequired = true
        requires("pehkui")
        embeds("midnightlib")
    }

    modrinth {
        projectId = Properties.MODRINTH_PROJECT_ID
        accessToken = providers.gradleProperty("MODRINTH_TOKEN")

        minecraftVersions.add(libs.minecraft.get().version!!)
        requires("pehkui")
        embeds("midnightlib")
    }
    github {
        accessToken = providers.gradleProperty("GH_TOKEN")
        parent(project(":").tasks.named("publishGithub"))
    }
}