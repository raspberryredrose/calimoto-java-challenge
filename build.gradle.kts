plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.26")
    implementation("org.jmockit:jmockit:1.49")
    implementation("org.jmockit:jmockit:1.49")
    testImplementation("junit:junit:4.13.1")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.jmockit:jmockit:1.49")
}

tasks.test {
    useJUnitPlatform()
}