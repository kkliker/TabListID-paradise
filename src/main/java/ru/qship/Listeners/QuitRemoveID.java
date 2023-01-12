package ru.qship.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ru.qship.qTabV2;

public class QuitRemoveID implements Listener {

    qTabV2 main = qTabV2.getPlugin(qTabV2.class);


    @EventHandler
    public void onRemoveID(PlayerQuitEvent e){


        int id = main.player.get(e.getPlayer().getUniqueId().toString());

        new BukkitRunnable() {

            int seconds = 600;

            @Override
            public void run() {



                seconds--;

                if(seconds <= 0){

                    main.player.remove(e.getPlayer().getUniqueId().toString());
                    main.ids.remove(id);

                }

                if(e.getPlayer().isOnline()){

                    cancel();
                }



            }
        }.runTaskTimer(qTabV2.getPlugin(qTabV2.class),0,20L);



    }


    public void removeid(Integer id){

        main.ids.remove(id);

    }


}
