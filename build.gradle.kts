plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.28") // Use the latest version
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.addAll(listOf("--module-path", classpath.asPath))
    options.annotationProcessorPath = configurations["annotationProcessor"]
}

tasks.test {
    useJUnitPlatform()
}