package com.tweska.sweetheads.commands;

import com.tweska.sweetheads.SweetHeadsUtil;
import com.tweska.sweetheads.heads.Head;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FindHeadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            return false;
        }

        Head head = SweetHeadsUtil.getInstance().findFirst(args[0]);

        if (head == null) {
            player.sendMessage("No head was found.");
            return false;
        }

        player.sendMessage(String.format("Giving you 1 %s", head.getName()));

        player.getInventory().addItem(head.getItem());

        return true;
    }
}
