object Versions {
    const val gradle = "4.0.1"
    const val androidGradlePlugin = "4.2.1" // update also build.gradle.kts in buildSrc

    const val kotlin = "1.5.20"  // update also build.gradle.kts in buildSrc
    const val coroutines = "1.5.0"

    object AndroidX {
        const val core = "1.5.0"
        const val cardview = "1.0.0"
        const val recyclerview = "1.2.1"
        const val compat = "1.3.0"
        const val preference = "1.1.1"
        const val navigation = "2.3.5"
        const val lifecycle = "2.3.1"
        const val lifecycleExtensions = "2.2.0"
    }

    const val material = "1.3.0"
    const val dagger = "2.37" // update also build.gradle.kts in buildSrc
    const val leakCanary = "2.7"

    const val constraint_layout = "2.0.4"

    object Retrofit {
        const val core = "2.9.0"
        const val moshi = "2.9.0"
    }
    const val moshi = "1.12.0"

    object OkHttp {
        const val core = "4.9.1"
        const val logging = "4.9.1"
    }

    // testing
    const val espresso = "3.2.0"
    const val mockito = "3.11.2"
    const val mockito_kotlin = "3.2.0"
    const val mockito_android = "3.8.0"
    const val junit = "5.7.2"
    const val robolectric = "4.3.1"
    const val truth = "1.1.3"
    const val lint = "27.2.1"

    const val ktlint = "0.41.0"
}
