package ru.qship.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.qship.qTabV2;

import java.util.UUID;

public class BanIP implements CommandExecutor {

    qTabV2 main = qTabV2.getPlugin(qTabV2.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] arg) {

        if (commandSender.isOp()) {
            if (arg.length > 0) {

                Integer inputid = Integer.valueOf(arg[0]);

                if (main.ids.get(inputid) != null) {


                    String uuid = main.ids.get(inputid);
                    Player p = Bukkit.getPlayer(UUID.fromString(uuid));

                    Bukkit.getBanList(BanList.Type.NAME).addBan(p.getName(), arg[1], null, commandSender.getName());
                    p.kickPlayer("Вы были забанены по IP по причине: " + arg[1]);

                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fИгрок с &7id <" + arg[0] + "> &fуспешно забанен по ip"));


                } else {

                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fИгрок с таким id не найден!"));
                }


            } else {

                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: usage: &f/banidip id reason"));

            }

        }
            return false;
        }


}
