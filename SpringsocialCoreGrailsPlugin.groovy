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

import grails.plugins.springsocial.SpringSecuritySigninService

class SpringsocialCoreGrailsPlugin {
	def version = "0.1.34-SNAPSHOT" // added by set-version
  def grailsVersion = "1.3.0 > *"
  def dependsOn = [:]

  def pluginExcludes = [
      "grails-app/views/error.gsp",
      "grails-app/conf/Config.groovy",
      "grails-app/conf/DataSource.groovy",
      "grails-app/i18n/**",
      'docs/**',
      'src/docs/**'
  ]

  def author = "Domingo Suarez Torres"
  def authorEmail = "domingo.suarez@gmail.com"
  def title = "Spring Social Core"
  def description = "Spring Social Core plugin."

  def documentation = "http://grails.org/plugin/spring-social-core"

  def license = "APACHE"
  def organization = [name: "Sindicato Source", url: "http://sindica.to"]
  def developers = [[name: "Domingo Suarez Torres", email: "domingo.suarez@gmail.com"], [name: "Jose Juan Reyes Zuniga", email: "neodevelop@gmail.com"]]
  def scm = [url: "https://github.com/synergyj/grails-spring-social-core"]
  def issueManagement = [system: "GITHUB", url: "https://github.com/synergyj/grails-spring-social-core/issues"]

  def doWithSpring = {
    xmlns context: "http://www.springframework.org/schema/context"
    context.'component-scan'('base-package': "grails.plugins.springsocial.config.core")

    signInService(SpringSecuritySigninService)
  }

}
