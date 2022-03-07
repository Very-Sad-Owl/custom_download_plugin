package ru.clevertec.tasks.olga.plugin.downloader

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.clevertec.tasks.olga.plugin.downloader.exception.ServiceException

class DownloaderPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def map = [description: "download resource", group: "other", type: DefaultTask.class]
        def extension = project.extensions.create('resources', DownloadPluginExtension)
        project.task(map, "download_resource") {
            doLast {
                try {
                    DownloaderService.getInstance().download("${extension.uri}", "${extension.path}")
                    println(String.format("File has been successfully downloaded from %s to %s",
                            "${extension.uri}", "${extension.path}"))
                } catch (ServiceException e){
                    println(e.getMessage())
                }
            }
        }
    }
}
class DownloadPluginExtension {
    String uri
    String path
}
