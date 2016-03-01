package com.github.cheesesoftware.PowerfulPerms;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.cheesesoftware.PowerfulPerms.common.ICommand;
import com.github.cheesesoftware.PowerfulPerms.common.PermissionCommand;
import com.github.cheesesoftware.PowerfulPermsAPI.PermissionManager;

public class PermissionCommandExecutor implements ICommand, CommandExecutor {

    private PermissionManager permissionManager;

    protected PermissionCommandExecutor(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PermissionCommand cmd = new PermissionCommand(permissionManager);
        return cmd.onCommand(this, sender.getName(), args);
    }

    @Override
    public void sendSender(String sender, String reply) {
        CommandSender commandSender = null;
        if (sender.equalsIgnoreCase("console"))
            commandSender = Bukkit.getConsoleSender();
        else
            commandSender = Bukkit.getPlayerExact(sender);

        if (commandSender != null) {
            commandSender.sendMessage(reply);
        }
    }

    @Override
    public String getVersion() {
        return PowerfulPerms.getPlugin().getDescription().getVersion();
    }

    @Override
    public boolean hasPermission(String name, String permission) {
        if (name.equals("console"))
            return true;
        Player player = Bukkit.getPlayerExact(name);
        if (player != null && (player.hasPermission("powerfulperms.admin") || player.hasPermission(permission)))
            return true;
        return false;
    }

}
