package com.kudo;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.Copy;

public class CopyApkPlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        CopyApkExtension ext = target.getExtensions().create("copyApk", CopyApkExtension.class);
        Copy copyTask = target.getTasks().create("copyApkToDesktop", Copy.class);

        target.afterEvaluate(project -> {
            copyTask.from("build/outputs/apk");
            copyTask.include("**/*.apk");
            copyTask.into(ext.destination);
        });
    }
}
