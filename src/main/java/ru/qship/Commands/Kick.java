package ru.qship.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.qship.qTabV2;

import java.util.UUID;

public class Kick implements CommandExecutor{

qTabV2 main = qTabV2.getPlugin(qTabV2.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] arg) {

if(commandSender.isOp()) {

    if (arg.length > 0) {

        Integer inputid = Integer.valueOf(arg[0]);

        if (main.ids.get(inputid) != null) {


            String uuid = main.ids.get(inputid);
            Player p = Bukkit.getPlayer(UUID.fromString(uuid));
            if (p.isOnline()) {
                Bukkit.getPlayer(UUID.fromString(uuid)).kickPlayer("Вы были кикнуты с сервера по причине: " + arg[1]);
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fИгрок с &7id <" + arg[0] + "> &fуспешно кикнут"));
            } else {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fИгрок с &7id <" + arg[0] + "> &fсейчас не в сети"));
            }
        } else {

            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fИгрок с таким &7id не найден!"));
        }


    } else {

        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: usage: &f/kickid id reason"));

    }


}
        return false;
    }
}
