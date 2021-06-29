# PacketAddonDrupi

Requires:
ProtocolLib

Example:

```javascript
const PacketSystem = Java.type('me.losin6450.packetaddondrupi.PacketSystem');
const ListenerPriority = Java.type('com.comphenix.protocol.events.ListenerPriority');
const PacketType = Java.type('com.comphenix.protocol.PacketType');
const ProtocolLibrary = Java.type('com.comphenix.protocol.ProtocolLibrary');

ProtocolLibrary.getProtocolManager().removePacketListeners(plugin);

PacketSystem.addPacketListener(plugin, ListenerPriority.NORMAL, PacketType.Play.Client.CHAT, event => {}, event => {
    server.broadcastMessage(`${event.getPlayer().getName()} wrote ${event.getPacket().getStrings().read(0)}`);
});
```
