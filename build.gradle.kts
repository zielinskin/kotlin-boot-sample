import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.0-M3"
	war
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.7.10"
	id("org.ajoberstar.grgit") version "5.0.0"
}
group = "zielinskin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

apply(plugin = "io.spring.dependency-management")

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("javax.persistence:javax.persistence-api:2.2")
	implementation("io.springfox:springfox-swagger2:2.9.2")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")

	runtimeOnly("com.h2database:h2")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

afterEvaluate {
	val reg =  Regex("^([^0-9]*)?([0-9]*)?(\\.([0-9]*))?(\\.([0-9]*))?((?i)(?!ITC).)*(?i)(ITC-[0-9]*)*.*$")
	var ver : String = "0.0.0"
	if(!grgit.tag.list().isEmpty()) {
		var match = reg.find(grgit.tag.list().last().name);
		ver = (match?.groups?.get(2)?.value ?: "0") + "." + (match?.groups?.get(4)?.value
			?: "0") + "." + (match?.groups?.get(6)?.value ?: "0")
	}
	logger.log(org.gradle.api.logging.LogLevel.ERROR, "version is: $ver")
	version = ver
}