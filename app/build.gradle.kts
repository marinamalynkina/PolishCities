plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.Android.compileSdkVersion)
    buildToolsVersion(Versions.Android.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdkVersion)
        targetSdkVersion(Versions.Android.targetSdkVersion)

        applicationId = Flavors.App.applicationId
        versionCode = Versions.App.buildNumber
        versionName = Versions.App.appVersion

        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {}
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
        }
    }

    lintOptions.isAbortOnError = false

    compileOptions {
        sourceCompatibility(1.8)
        targetCompatibility(1.8)
    }
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }

}

dependencies {
    implementation(Depends.kotlinStdLib)
    implementation(Depends.kotlinReflect)

    implementation(Depends.androidLifecycleExtensions)
    kapt(Depends.androidLifecycleCompiler)
    implementation(Depends.androidLifecycleLiveDataKtx)
    implementation(Depends.androidFragmentKtx)

    implementation(Depends.androidAppCompat)
    implementation(Depends.androidCoreKtx)
    implementation(Depends.androidMaterial)
    implementation(Depends.androidCardView)
    implementation(Depends.androidConstraintLayout)
    implementation(Depends.androidRecyclerView)
    implementation(Depends.androidPaging)

    implementation(Depends.androidNavigationFragmentKtx)
    implementation(Depends.androidNavigationUiKtx)

    api(Depends.guava)

    implementation(Depends.playServicesMaps)

    implementation(Depends.rxJava)
    implementation(Depends.rxAndroid)

    implementation(Depends.retrofit)
    implementation(Depends.retrofitRxJava2Adapter)
    implementation(Depends.retrofitGsonConverter)
    implementation(Depends.okhttpLoggingInterceptor)

    implementation(Depends.dagger)
    kapt(Depends.daggerCompiler)
    implementation(Depends.daggerAndroid)
    implementation(Depends.daggerAndroidSupport)
    kapt(Depends.daggerProcessor)

    api(Depends.roomRuntime)
    kapt(Depends.roomCompiler)
    implementation(Depends.roomKtx)
    implementation(Depends.roomRxJava2)
    testImplementation(Depends.roomTesting)

    testImplementation(Depends.jUnit)
    androidTestImplementation(Depends.jUnitExt)
    androidTestImplementation(Depends.jUnitCore)
    androidTestImplementation(Depends.jUnitRunner)
    androidTestImplementation(Depends.espressoCore)
    androidTestImplementation(Depends.mochito)
}