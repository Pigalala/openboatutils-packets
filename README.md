# OpenBoatUtils Packets
[OpenBoatUtils protocol](https://openboatutils.github.io/developers/protocol.html)
## How to use
Add the following dependency:
```groovy
// Repository
mavenCentral()

// Dependencies
implementation 'dev.piggle:minestom-openboatutils-packets:<see releases>'
```

### Init
Call the `OpenBoatUtils.init()` method when you are ready to start sending/receiving packets
(ideally before the server starts accepting player connections)

### Sending packets
Sendable packets are located in `dev.piggle.obupackets.packet.clientbound.<type>.*`

Use `OpenBoatUtils.sendPacket(player, packet)` to send an OBU packet to a player

Example:
```java
OpenBoatUtils.sendPacket(player, new SettingsReset());
```

### Receiving packets
Receivable packets are located in `dev.piggle.obupackets.packet.serverbound.<type>.*`

Listen to the `dev.piggle.obupackets.event.BoatUtilsPacketReceiveEvent` event for incoming packets.

Example:
```java
MinecraftServer.getGlobalEventHandler().addListener(BoatUtilsPacketReceiveEvent.class, event -> {
    if (event.packet() instanceof ConfigurationVersion(int version, boolean unstable)) {
        // Maybe kick player if unstable..
        event.getPlayer().kick("Bye bye");
    }
});
```

## Goals
- Strongly typed records for each packet
- Follow the [OpenBoatUtils protocol](https://openboatutils.github.io/developers/protocol.html)
- Handle serialization and deserialization between packet records and plugin message bytes
- Support Minestom and PaperMC
## Non-goals
- Provide Serialization and deserialization between other formats and the packet records (JSON, plain text, etc)
- Support OpenBoatUtils clients with version <19
