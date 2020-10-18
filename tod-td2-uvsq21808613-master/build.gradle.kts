plugins {
    java // Apply the java plugin to add support for Java
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    jcenter() // Use jcenter for resolving dependencies.
}

val JUNIT_VERSION = "4.12"

dependencies {
    testImplementation("junit:junit:$JUNIT_VERSION") // Use JUnit test framework
}
