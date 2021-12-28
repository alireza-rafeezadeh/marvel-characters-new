plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        applicationId = Android.appId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary true
//        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose =  true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {

    implementation(project(Modules.core))
    implementation(project(Modules.heroDomain))
    implementation(project(Modules.heroInteractors))
    implementation(project(Modules.ui_heroList))

    implementation (AndroidX.coreKtx)
    implementation (AndroidX.appCompat)
    implementation (AndroidX.lifeCycleRuntime)

    implementation(Coil.coil)

    implementation (Compose.ui)
    implementation (Compose.material)
    implementation (Compose.tooling)
    implementation (Compose.activity)

    implementation (Google.material)

    implementation (Hilt.android)
    kapt(Hilt.compiler)

//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
//    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
//    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
}