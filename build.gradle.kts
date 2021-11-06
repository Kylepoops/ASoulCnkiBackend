plugins {
    java
    `maven-publish`
    id("org.springframework.boot") version "2.5.6"
    id("com.bmuschko.docker-spring-boot-application") version "7.1.0"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:2.3.4.RELEASE")
    implementation("com.esotericsoftware:kryo-shaded:3.0.3")
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE")
    implementation("org.projectlombok:lombok:1.18.20")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.4.0")
    implementation("com.alibaba:druid:1.1.5")
    implementation("org.apache.commons:commons-lang3:3.4")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("com.google.guava:guava:19.0")
    implementation("org.slf4j:slf4j-api:1.7.25")
    implementation("com.baomidou:mybatis-plus-generator:3.4.0")
    implementation("org.apache.velocity:velocity-engine-core:2.2")
    implementation("com.alibaba:fastjson:1.2.76")
    implementation("javax.validation:validation-api:2.0.1.Final")
    // 处理配置
    implementation("org.springframework.boot:spring-boot-configuration-processor:2.3.4.RELEASE")
    // 数据校验依赖
    implementation("org.hibernate.validator:hibernate-validator:6.0.17.Final")
    // Redis 缓存依赖
    implementation("org.springframework.boot:spring-boot-starter-data-redis:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-cache:2.3.4.RELEASE")
    // caffeine 缓存依赖
    implementation("com.github.ben-manes.caffeine:caffeine:2.8.5")
    // es 搜索
    implementation("org.elasticsearch.client:elasticsearch-rest-high-level-client:7.14.0")
    implementation("org.elasticsearch.client:elasticsearch-rest-client:7.14.0")
    implementation("org.elasticsearch:elasticsearch:7.14.0")
    // 单测框架
    implementation("org.testng:testng:7.0.0")
    // 阿里巴巴规约插件
    implementation("com.alibaba.p3c:p3c-pmd:1.3.6")
    runtimeOnly("mysql:mysql-connector-java:8.0.21")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.3.4.RELEASE")
}

group = "asia.asoucnki"
version = "latest"
description = "api"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.test {
    useTestNG()
}
