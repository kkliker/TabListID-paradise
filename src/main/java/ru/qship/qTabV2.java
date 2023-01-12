package ru.qship;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.qship.Commands.Ban;
import ru.qship.Commands.BanIP;
import ru.qship.Commands.Kick;
import ru.qship.Commands.TP;
import ru.qship.Listeners.JoinAddID;
import ru.qship.Listeners.QuitRemoveID;
import ru.qship.TabManagment.SetNameInTab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class qTabV2 extends JavaPlugin {


  public    HashMap<Integer,String> ids = new HashMap<Integer,String>();

  public    HashMap<String,Integer> player = new HashMap<String,Integer>();

    @Override
    public void onEnable() {

      List<String> footer = new ArrayList<>();
      footer.add("0");
      footer.add(ChatColor.translateAlternateColorCodes('&',"&7dsc.gg/&fparadisebeta"));

      getServer().getPluginManager().registerEvents( new SetNameInTab(),this);
      getServer().getPluginManager().registerEvents( new JoinAddID(),this);
      getServer().getPluginManager().registerEvents( new QuitRemoveID(),this);


      getCommand("banid").setExecutor(new Ban());
        getCommand("banidip").setExecutor(new BanIP());
        getCommand("kickid").setExecutor(new Kick());
        getCommand("tpid").setExecutor(new TP());


      new BukkitRunnable() {
        @Override
        public void run() {

String players = "0";

          switch(Bukkit.getOnlinePlayers().size() % 10){

            case 1:
                players = ChatColor.translateAlternateColorCodes('&',"&fСейчас в штате: &a" + Bukkit.getOnlinePlayers().size() + " &fжитель\n");
                footer.set(0,players);
                break;

            case 2:
            case 3:
            case 4:
                players = ChatColor.translateAlternateColorCodes('&',"&fСейчас в штате: &a" + Bukkit.getOnlinePlayers().size() + " &fжителя\n");
                footer.set(0,players);
                break;

                case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                players = ChatColor.translateAlternateColorCodes('&',"&fСейчас в штате: &a" + Bukkit.getOnlinePlayers().size() + " &fжителей\n");
                footer.set(0,players);
                break;


          }


          convert(footer);

      for(Player p : Bukkit.getOnlinePlayers()) {

        p.setPlayerListHeader(ChatColor.translateAlternateColorCodes('&', "&6&lШтат Парадайс"));
        p.setPlayerListFooter(footer.get(0) + footer.get(1));
      }





        }
      }.runTaskTimer(this,20L,50L);


    }


  String convert(List<String> list){

    return String.join("\n",list);

  }
}
