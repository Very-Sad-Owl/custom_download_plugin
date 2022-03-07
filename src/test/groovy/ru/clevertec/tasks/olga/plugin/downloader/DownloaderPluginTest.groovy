package ru.clevertec.tasks.olga.plugin.downloader

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DownloaderPluginTest {

    @Test
    void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'ru.clevertec.plugins.downloader'

        Assertions.assertNotNull(project.tasks.download_resource)
    }
}
