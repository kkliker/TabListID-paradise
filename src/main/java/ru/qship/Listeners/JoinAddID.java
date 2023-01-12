package ru.qship.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.qship.qTabV2;

public class JoinAddID implements Listener {

    qTabV2 main = qTabV2.getPlugin(qTabV2.class);

    @EventHandler
    public void addid(PlayerJoinEvent e){

        putid(e.getPlayer());

    }



    public void putid(Player p){

        for(int i = 0;i < 100;){


            if(main.ids.get(i) == null){

                main.ids.put(i,p.getUniqueId().toString());
                main.player.put(p.getUniqueId().toString(),i);
                break;

            }

            i++;



        }
    }




}
