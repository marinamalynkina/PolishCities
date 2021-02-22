object Depends {

    object BuildPlugins {
        const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidGradlePluginVersion}"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val googleServicesPlugin = "com.google.gms:google-services:${Versions.googleServicesVersion}"
        const val androidNavigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidNavigationVersion}"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"

    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitVersion}"
    const val jUnitCore = "androidx.test:core:${Versions.jUnitCoreVersion}"
    const val jUnitRunner = "androidx.test:runner:${Versions.jUnitRunnerVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val mochito = "org.mockito:mockito-core:${Versions.mochitoVersion}"


    // optional - Test helpers for LiveData
    const val testingLiveData = "androidx.arch.core:core-testing:${Versions.testingLiveDataVersion}"
    const val androidFragmentTestingKtx = "androidx.fragment:fragment-testing:${Versions.androidFragmentKtxVersion}"

    const val androidLegacySupport = "androidx.legacy:legacy-support-v4:${Versions.androidLegacySupportVersion}"
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompatVersion}"
    const val androidCoreKtx = "androidx.core:core-ktx:${Versions.androidCoreKtxVersion}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterialVersion}"

    const val androidCardView = "androidx.cardview:cardview:${Versions.androidCardViewVersion}"
    const val androidRecyclerView = "androidx.recyclerview:recyclerview:${Versions.androidRecyclerViewVersion}"
    const val androidLifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidLifecycleVersion}"
    // Annotation processor
    const val androidLifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.androidLifecycleVersion}"
    // LiveData
    const val androidLifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidLifecycleVersion}"
    // ViewModel
    const val androidLifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidLifecycleVersion}"
    // Saved state module for ViewModel
    const val androidLifecycleViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.androidLifecycleVersion}"
    const val androidFragmentKtx = "androidx.fragment:fragment-ktx:${Versions.androidFragmentKtxVersion}"
    const val androidConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidConstraintLayoutVersion}"
    const val androidNavigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.androidNavigationVersion}"
    const val androidNavigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.androidNavigationVersion}"
    const val androidSwipeLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.androidSwipeLayoutVersion}"
    const val androidPaging = "androidx.paging:paging-runtime:${Versions.androidPagingVersion}"

    const val playServicesAuth = "com.google.android.gms:play-services-auth:${Versions.playServicesAuthVersion}"
    const val playServicesMaps = "com.google.android.gms:play-services-maps:${Versions.playServicesMapsVersion}"

    const val guava = "com.google.guava:guava:${Versions.guavaVersion}"
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"

    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitRxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomRxJava2 = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    const val roomTesting = "androidx.room:room-testing:${Versions.roomVersion}"

    const val facebookShimer = "com.facebook.shimmer:shimmer:${Versions.facebookShimerVersion}"

}
