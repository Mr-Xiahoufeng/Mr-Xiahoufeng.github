pluginManagement {
    repositories {

        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/repositories/google") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/groups/public") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/repositories/jcenter") }

        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {

        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/repositories/google") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/groups/public") }
        maven { url = uri("https://maven.aliyun.com/nexus/content/repositories/jcenter") }

        google()
        mavenCentral()
    }
}

rootProject.name = "My Application_1"
include(":app")
include(":mybutton")
include(":myedittext")
include(":myinmageview")
include(":myprogressbar")
include(":mylinearlayout")
include(":myrelativelayout")
include(":myframelayout")
include(":myconstraintlayout")
include(":mymenu")
