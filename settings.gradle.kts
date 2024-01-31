pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "Shop"
include(":app")
include(":common:common_utils")
include(":feature_auth:auth_domain")
include(":feature_auth:auth_data")
include(":feature_auth:auth_presentation")
include(":feature_home:home_presentation")
include(":feature_catalog:catalog_presentation")
include(":feature_basket:basket_presentation")
include(":feature_stocks:stocks_presentation")
include(":feature_profile:profile_presentation")
include(":navigation")
