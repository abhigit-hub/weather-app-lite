import io.gitlab.arturbosch.detekt.Detekt
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "com.compose.weatherapplite"
    testNamespace = "test.com.compose.weatherapplite"

    defaultConfig {
        applicationId = "com.compose.weatherapplite"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        compileSdkPreview = "UpsideDownCake"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    ktlint {
        android = true // Enable Android-specific linting rules
        ignoreFailures = false // Fail the build if KtLint finds any issues
        reporters {
            reporter(ReporterType.PLAIN) // Output KtLint results in plain text format
            reporter(ReporterType.HTML) // Output KtLint results in HTML format
        }
    }

    tasks.withType<Detekt>().configureEach {
        reports {
            html.required.set(true) // observe findings in browser with structure and code snippets
            md.required.set(true) // simple Markdown format
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Compose - BOM - (Bill of Materials)
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Unit Testing
    testImplementation(libs.test.junit)
    testImplementation(libs.test.junit.core)
    testImplementation(libs.test.roboelectric)
    testImplementation(libs.test.mockk)

    // Tooling - Preview
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // Compose - Jetpack Core
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.core.ktx)

    // Compose - UI
    implementation(libs.androidx.compose.ui)

    // Compose - UI - Material 3
    implementation(libs.androidx.compose.material3)

    // Compose - UI - Animation Graphics
    implementation(libs.androidx.compose.animation.graphics)

    // Retrofit (Retrofit, Gson Converter, OkHTTP Logging)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp.logging)

    // Dagger - Hilt
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Compose - Map
    implementation(libs.compose.map)

    // Accompanist - Permission
    implementation(libs.accompanist.permission)

    // Play Services - Location
    implementation(libs.playservices.location)

    // Destinations - Navigation
    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)
}
