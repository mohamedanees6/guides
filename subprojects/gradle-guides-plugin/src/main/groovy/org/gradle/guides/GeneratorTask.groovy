package org.gradle.guides

import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputFile

abstract class GeneratorTask extends DefaultTask {
    @OutputFile
    abstract RegularFileProperty getOutputFile()

    @Internal
    protected List<String> getGeneratedFileHeader() {
        return [
                "File auto-generated by ${gitHubCodeUrl(this.class)}",
                "Do not modify unless the '${this.path}' tasks is disabled in the build script."
        ]
    }

    protected static String slashComment(List<String> lines) {
        return lines.collect { "// ${it}" }.join('\n')
    }

    protected static String hashComment(List<String> lines) {
        return lines.collect { "# ${it}" }.join('\n')
    }

    protected static String htmlComment(List<String> lines) {
        return lines.collect { "<!-- ${it} -->" }.join('\n')
    }

    private static String gitHubCodeUrl(Class<? extends Task> taskType) {
        String gitHubUrlPath = taskType.canonicalName.replaceAll('\\.', '/').replace('_Decorated', '')
        return "https://github.com/gradle-guides/gradle-guides-plugin/tree/master/src/main/groovy/${gitHubUrlPath}.groovy"
    }
}