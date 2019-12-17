/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.guides

import groovy.transform.CompileStatic
import org.gradle.api.tasks.TaskAction

/**
 * Generate the Developer Certificate of Origin GitHub Application configuration file.
 *
 * @since 0.15.8
 */
@CompileStatic
abstract class GenerateDeveloperCertificateOfOriginConfiguration extends GeneratorTask {
    @TaskAction
    private doGenerate() {
        outputFile.asFile.get().text = """${hashComment(generatedFileHeader)}

# Disable sign-off checking for members of the Gradle GitHub organization
require:
  members: false
"""
    }
}
