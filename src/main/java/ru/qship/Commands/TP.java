package ru.qship.Commands;

import org.bukkit.BanList;
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

public class TP implements CommandExecutor {

    qTabV2 main = qTabV2.getPlugin(qTabV2.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] arg) {

        if (commandSender.isOp()) {
            if (arg.length == 1) {

                Integer inputid = Integer.valueOf(arg[0]);

                if (main.ids.get(inputid) != null) {


                    String uuid = main.ids.get(inputid);
                    Player p = Bukkit.getPlayer(UUID.fromString(uuid));
                    Player sender = (Player) commandSender;
                    sender.teleport(p);


                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fВы телепортированы к игроку с &7id <" + arg[0] + ">"));


                } else {

                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fИгрок с таким id не найден!"));
                }


            } else if (arg.length == 1) {

                Integer inputid = Integer.valueOf(arg[0]);
                Integer inputid2 = Integer.valueOf(arg[1]);

                String uuid = main.ids.get(inputid);
                String uuid2 = main.ids.get(inputid2);


                Player p = Bukkit.getPlayer(UUID.fromString(uuid));
                Player p2 = Bukkit.getPlayer(UUID.fromString(uuid2));

                Player sender = (Player) commandSender;

                p.teleport(p2);


                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: &fТелепортация   &7id <" + arg[0] + "> &f к &7<" + arg[1] + ">" ));


            } else {

                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7CONSOLE: usage: &f/tpid id id"));

            }
        }

            return false;
        }



}
