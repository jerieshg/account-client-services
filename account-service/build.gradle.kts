plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

springBoot {
	mainClass="com.devsu.jh.accountservice.AccountServiceApplication"
}

dependencies {
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

	compileOnly("org.projectlombok:lombok")

	implementation("org.springframework.boot:spring-boot-starter-actuator:3.5.3")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("jakarta.validation:jakarta.validation-api:3.1.1")
	implementation("com.mysql:mysql-connector-j:9.3.0")
	implementation("org.mapstruct:mapstruct:1.6.3")

	testRuntimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
	useJUnitPlatform()
}
