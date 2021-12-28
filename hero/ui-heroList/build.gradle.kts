apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.heroDomain))
    "implementation"(project(Modules.heroInteractors))

    "api"(Coil.coil)

    "implementation"(SqlDelight.androidDriver)

    "api" ("com.github.skydoves:landscapist-glide:1.4.4")
}