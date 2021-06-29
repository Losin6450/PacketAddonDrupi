package me.losin6450.packetaddondrupi;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.oracle.truffle.api.object.dsl.Nullable;
import org.bukkit.plugin.Plugin;
import org.graalvm.polyglot.Value;

public class PacketSystem {
    public static void addPacketListener(Plugin plugin, ListenerPriority priority, PacketType type, @Nullable Value onPacketSending, @Nullable Value onPacketReceived) {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(plugin, priority, type) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                onPacketReceived.executeVoid(event);
            }

            @Override
            public void onPacketSending(PacketEvent event) {
                onPacketSending.executeVoid(event);
            }
        });
    }
}
