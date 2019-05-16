Mjolnir
=======
A Bukkit plugin that provides variations on the `/thor` command to strike
lightning.


Commands
--------
In the commands below, note that messages can include colour codes beginning
with an ampersand ('&'). Messages are red by default.

 * `/armageddon [<message>]` - Strike lethal lightning on all players, passing a message, 
   if specified.
   * Aliases: `/thorall`

 * `/excalibur [<message>]` - Strike lethal lightning at and around the location
   you are facing. Players will be killed and blocks damaged by explosions and
   fire. If a message is specified, it is sent to affected players.

 * `/explode` - Blow yourself up. You die.
 
 * `/explodeplayer <player> [<message>]` - Explode the specified player, killing
   them, and send the player a message, if specified.

 * `/ladycailin [<message>]` - Strike non-lethal lightning on all players, 
   passing a message, if specified.
   * Aliases: `/strikeall`

 * `/striket` - Strike non-lethal lightning at the location you are facing.

 * `/striketrg <region> [<message>]` - Strike non-lethal lightning at all 
   players in the specified region (excluding the command sender). If a 
   message is given, it is sent to all affected players.
   * Aliases: `/striketregion`

 * `/thor <player> [<message>]` - Call down lightning and kill a player, sending
   the specified message, or a default if not specified. The player drops his items.

 * `/thorrg <region> [<message>]` - `/thor` all players in a named region,
   except the command sender. Send affected players the message, if specified.
   * Aliases: `/thorregion`


Permissions
-----------
| Permission | Description | Default |
| :---       | :---        | :---    |
| `mjolnir.*` | Permission to use all commands except `/excalibur`. | `op` |
| `mjolnir.armageddon` | Permission to use `/armageddon`. | `op` |
| `mjolnir.excalibur` | Permission to use `/excalibur`. | `op` |
| `mjolnir.explode` | Permission to use `/explode`. | `op` |
| `mjolnir.explodeplayer` | Permission to use `/explodeplayer`. | `op` |
| `mjolnir.ladycailin` | Permission to use `/ladycailin`. | `op` |
| `mjolnir.striket` | Permission to use `/striket`. | `op` |
| `mjolnir.striketrg` | Permission to use `/striketrg`. | `op` |
| `mjolnir.thor` | Permission to use `/thor`. | `op` |
| `mjolnir.thorrg` | Permission to use `/thorrg`. | `op` |


Dependencies
------------
This plugin will use WorldGuard, if present, to support commands that target
regions.

