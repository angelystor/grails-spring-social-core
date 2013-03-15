/* Copyright 2012 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.dependency.resolution = {
  inherits("global") {
    // uncomment to disable ehcache
    // excludes 'ehcache'
  }
  log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
  repositories {
    grailsPlugins()
    grailsHome()
    grailsCentral()

    // from public Maven repositories
    mavenLocal()
    mavenCentral()

    mavenRepo "http://maven.springframework.org/release"
    mavenRepo "http://maven.springframework.org/snapshot"
    mavenRepo "http://maven.springframework.org/milestone"

    grailsRepo "http://grails.org/plugins"
  }
  dependencies {
    def springSocialVersion = "1.1.0.M2"

    compile("org.springframework.social:spring-social-core:${springSocialVersion}") { transitive = false }
    compile("org.springframework.social:spring-social-web:${springSocialVersion}") { transitive = false }

    compile("org.springframework.security:spring-security-crypto:3.1.0.RELEASE") { transitive = false }
    compile("javax.inject:javax.inject:1")
  }
  plugins {
    /*
    This validation is for prevent load the following plugins in previous Grails versions.
    In some Grails versions from 1.3.* the 'export = false' does not work. For Grails 2.* works properly
    */
    if (grailsVersion.startsWith('2')) {
      compile(":spring-security-core:1.2.7.3")
      test(":code-coverage:1.2.5") { export = false }
      build(":release:2.0.0") { export = false }
      build(":rest-client-builder:1.0.2") { export = false }
    }
  }
}

grails.release.scm.enabled = false
grails.project.repos.default = "grailsCentral"

coverage {
  exclusions = [
      "DefaultSpringSocialConfig*",
      "SpringSocialCoreDefaultConfig*"
  ]
  enabledByDefault = true
}