apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.heroDomain))
    "implementation"(project(Modules.heroInteractors))

    "implementation"(Coil.coil)

    "implementation"(SqlDelight.androidDriver)

    "implementation" ("com.github.skydoves:landscapist-glide:1.4.4")

//    "implementation" ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    "kapt" ("androidx.hilt:hilt-compiler:1.0.0")

    "androidTestImplementation"(project(Modules.heroDataSourceTest))
    "androidTestImplementation"(ComposeTest.uiTestJunit4)
    "debugImplementation"(ComposeTest.uiTestManifest)
    "androidTestImplementation"(Junit.junit4)
}