plugins {
    id("replacename.kotlin.feature.library")
}

kapt {
    useBuildCache = true
}

dependencies {
    implementation(project(":core:core_data"))
    implementation(project(":domain:domain_data"))

    core()
    network()

    test()
    lintChecks(project(":lint-rules"))
}
