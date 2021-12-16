apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(Ktor.clientSerialization)

}