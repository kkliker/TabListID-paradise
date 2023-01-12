package ru.qship.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import ru.qship.qTabV2;

import java.io.File;
import java.io.IOException;

public class UpdatePlayerName implements CommandExecutor {
    qTabV2 main = qTabV2.getPlugin(qTabV2.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        File f =new File("/home/container/plugins/OpenRP/descriptions/userdata.yml");
        FileConfiguration fg = new YamlConfiguration();


        try {
            fg.load(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        Player player = (Player) commandSender;


                String name = fg.getString(player.getUniqueId().toString() + ".Имя");
                String suname = fg.getString(player.getUniqueId().toString() + ".Фамилия");

        int id = main.player.get(player.getUniqueId().toString());

        if(suname.equals("Нет фамилии")) {

            player.setPlayerListName(ChatColor.GRAY + "#" + id + ChatColor.WHITE + " " + name);

        }
        else {
            player.setPlayerListName(ChatColor.GRAY + "#" + id + ChatColor.WHITE + " " + name + " " + suname);
        }




        return false;
    }
}
