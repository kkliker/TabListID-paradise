package ru.qship.TabManagment;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ru.qship.qTabV2;

import java.io.File;
import java.io.IOException;

public class SetNameInTab implements Listener {

    qTabV2 main = qTabV2.getPlugin(qTabV2.class);

    @EventHandler
    public void JoinEvent(PlayerJoinEvent e) throws IOException, InvalidConfigurationException {



       File f =new File("/home/container/plugins/OpenRP/descriptions/userdata.yml");
        FileConfiguration fg = new YamlConfiguration();


        fg.load(f);

        Player player = e.getPlayer();


        new BukkitRunnable() {
            @Override
            public void run() {

                String name = fg.getString(player.getUniqueId().toString() + ".Имя");
                String suname = fg.getString(player.getUniqueId().toString() + ".Фамилия");


        int id = main.player.get(e.getPlayer().getUniqueId().toString());

                if(suname.equals("Нет фамилии")) {

                    player.setPlayerListName(ChatColor.GRAY + "#" + id + ChatColor.WHITE + " " + name);

                }
                else {
                    player.setPlayerListName(ChatColor.GRAY + "#" + id + ChatColor.WHITE + " " + name + " " + suname);
                }


            }
        }.runTaskLater(qTabV2.getPlugin(qTabV2.class),20L);

    }

}
