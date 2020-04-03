package net.comorevi.cosse.jqmessageplus;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.level.Sound;
import cn.nukkit.network.protocol.SetLocalPlayerAsInitializedPacket;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;

public class Main extends PluginBase implements Listener {
    private Config config;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        config = new Config(new File("./plugins/JoinQuitMessagePlus", "config.yml"), Config.YAML);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        if (config.getBoolean("EnableCustomJoinMessage")) event.setJoinMessage(config.getString("CustomJoinMessage").replace("{username}", event.getPlayer().getName()));
    }

    @EventHandler
    public void dataPacketReceive(DataPacketReceiveEvent event) {
        if (!(event.getPacket() instanceof SetLocalPlayerAsInitializedPacket)) return;
        if (config.getBoolean("EnableJoinMessage")) {
            for (String str : config.getStringList("JoinMessage")) {
                event.getPlayer().sendMessage(str);
            }
        }
        if (config.getBoolean("EnableJoinTitle")) event.getPlayer().sendTitle(config.getString("JoinTitle"), config.getString("JoinSubTitle"), 2 * 20, 2 * 20, 20);
        if (config.getBoolean("EnableJoinSound")) event.getPlayer().getLevel().addSound(event.getPlayer().getLocation(), Sound.RANDOM_LEVELUP);
    }

    @EventHandler
    public void playerQuit(PlayerQuitEvent event) {
        if (config.getBoolean("EnableCustomQuitMessage")) {
            event.setQuitMessage(config.getString("CustomQuitMessage").replace("{username}", event.getPlayer().getName()));
        }
    }
}
