package com.github.cheesesoftware.PowerfulPerms;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Updater {

    public Updater() {

    }

    public void update(Plugin plugin) {
        try {
            int resourceId = 8143;
            be.maximvdw.mvdwupdater.MVdWUpdater updater = (be.maximvdw.mvdwupdater.MVdWUpdater) Bukkit.getPluginManager().getPlugin("MVdWUpdater");
            if (updater.hasBought(updater.getSpigotUser(), resourceId)) {

                List<be.maximvdw.mvdwupdater.spigotsite.api.resource.Resource> premiums = updater.getPurchasedResources(updater.getSpigotUser());
                for (be.maximvdw.mvdwupdater.spigotsite.api.resource.Resource premium : premiums) {
                    if (premium.getResourceId() == resourceId) {
                        // Resource id found
                        Bukkit.getLogger().info(PowerfulPerms.consolePrefix + "Checking for new updates...");

                        // Compare versions
                        be.maximvdw.mvdwupdater.Version currentPluginVersion = new be.maximvdw.mvdwupdater.Version(plugin.getDescription().getVersion());
                        be.maximvdw.mvdwupdater.Version newPluginVersion = new be.maximvdw.mvdwupdater.Version(updater.getResourceVersionString(resourceId));

                        if (currentPluginVersion.compare(newPluginVersion) == 1) {
                            Bukkit.getLogger().info(PowerfulPerms.consolePrefix + "An update is available.");
                            Bukkit.getLogger().info(PowerfulPerms.consolePrefix + "Current version: " + currentPluginVersion.toString() + " - New version: " + newPluginVersion.toString());

                            // If not folder "update" exists, create it
                            if (!Bukkit.getUpdateFolderFile().exists())
                                Bukkit.getUpdateFolderFile().mkdir();

                            // Define output file
                            File outputFile = null;
                            try {
                                outputFile = new File(Bukkit.getUpdateFolderFile(), "PowerfulPerms.jar");
                            } catch (Exception ex) {

                            }

                            // Download the plugin to the "update" folder
                            if (outputFile != null) {
                                Bukkit.getLogger().info(PowerfulPerms.consolePrefix + "Downloading update...");
                                be.maximvdw.mvdwupdater.spigotsite.api.resource.Resource premiumResource = updater.getSpigotSiteAPI().getResourceManager()
                                        .getResourceById(premium.getResourceId(), updater.getSpigotUser());
                                premiumResource.downloadResource(updater.getSpigotUser(), outputFile);

                                Bukkit.getLogger().info(PowerfulPerms.consolePrefix + "The new update will be automatically installed on next restart.");
                            }
                        }

                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
