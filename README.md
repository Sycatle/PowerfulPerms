![logo](http://i.imgur.com/iwFaydf.jpg)

You can modify and create permissions for groups and players in-game and it will sync across your whole network of servers -immediately-, without having your players relog. It has one optional plugin Bungee-side, and one optional for Bukkit-side, designed to cooperate together to enhance your permissions experience greatly. It has complete wildcard and permission negation support.

Now open-source, and free.

Wiki at PowerfulPerms Wiki
API on GitHub
Source on GitHub
Need help? Join the Discord help chat

![features](http://i.imgur.com/41r4rPr.png)

- Supports online mode, offline mode and mixed mode networks.
- Supports Bungeecord permissions and Bukkit permissions.
- Supports timed player permissions, timed group permissions and timed player groups.
- Supports wildcard permissions such as "worldedit.*", "something.something.some.*" and a single "*".
- Supports negated permissions by adding "-" in front of the permission. Also supports negated wildcard permissions such as "-something.something.*"
- Supports sequences in any command with brackets, for example "/pp group yourgroup add essentials.{pay,balance,tpa,sethome,...} {YourServer1,YourServer2,...}"
- On the fly permission editing by the help of Redis (A Redis server has to be installed, it notifies other servers of changes and tells them to reload the permissions. It will work without Redis but other servers won't be notified of permission changes so you have to reload them manually).
- Cached permissions. All database access in done in a separate thread. Performance is important.
- Easy in-game commands, similar to PermissonsEx.
- 100% UUID support, supporting namechanges.
- Everything stored in MySQL with an easy format, to make it easy for you to develop web interfaces and other applications using the data. MongoDB will be supported in the future.
- Per-server and per-world Bukkit permissions.
- Per-server BungeeCord permissions.
- Vault support for retrieving and modifying both permission and chat info for online and offline players.
- Supports Importer, Party and Friends
- Supports offline player permission checks.
- Support for infinite groups per player.
- Group ladders and group ranks.
- Promotions and demotions.
- Per-server groups.
- Group inheritance - Groups derive permissions from other groups.
- Chat format support with colored prefixes and suffixes. No need to use an external chat plugin, though I recommend DeluxeChat, VentureChat or any other PlaceholderAPI-supporting chat plugin.
- Support for PlaceholderAPI. (Expansion avaliable for download in PlaceholderAPI cloud)
- API for developers on GitHub.
- PermissionsEx importer on GitHub.
- Note the following:
- Every server has to have its server name in PowerfulPerms config. It's the same as the server name in BungeeCord config. This is for per-server Bukkit permissions and Redis to work properly.
- Full tab completion.

PlaceholderAPI placeholders:

- {powerfulperms_prefix}
- {powerfulperms_suffix}
- {powerfulperms_ownprefix}
- {powerfulperms_ownsuffix}
- {powerfulperms_primarygroup}
- {powerfulperms_group_<ladder>}
- {powerfulperms_prefix_<ladder>}
- {powerfulperms_suffix_<ladder>}
- {powerfulperms_firstprefix_<ladder 1>_<ladder 2>_<ladder 3 etc>}
- {powerfulperms_firstsuffix_<ladder 1>_<ladder 2>_<ladder 3 etc>}
- {powerfulperms_firstgroup_<ladder1>_<ladder 2>_<ladder 3 etc>}
- There are more, read the wiki.
#
#
#
![commands](http://i.imgur.com/RK0mjMh.png)

/powerfulperms aliases: /pp /pop /pow
/powerfulpermsbungee aliases: /ppbungee, popbungee, /powbungee

- /pp user <user>
- /pp user <user> promote <ladder>
- /pp user <user> demote <ladder>
- /pp user <user> setrank <group>
- /pp user <user> addgroup/removegroup <group> (server) (expires)
- /pp user <user> add/remove <permission> (server) (world) (expires)
- /pp user <user> create/clearperms/delete
- /pp user <user> prefix/suffix set <prefix/suffix>
- /pp user <user> prefix/suffix remove
- /pp user <user> haspermission <permission> (server) (world)
- /pp groups
- /pp group <group>
- /pp group <group> create (ladder) (rank)
- /pp group <group> delete/clearperms/members
- /pp group <group> add/remove <permission> (server) (world) (expires)
- /pp group <group> parents add/remove <parent>
- /pp group <group> prefix/suffix set <prefix/suffix> (server)
- /pp group <group> prefix/suffix remove (server)
- /pp group <group> setladder <ladder>
- /pp group <group> setrank <rank>
- /pp group <group> rename <name>
- /pp group <group> haspermission <permission> (server) (world)
- /pp ladders
- /pp haspermission <permission>
- /pp reload/globalreload
- /pp test redis/database
- /pp about

All server and world parameters can be replaced by "all" to indicate a global setting.
When removing permissions or player groups, all server, world and expiry date parameters can be replaced by "any" to remove any occurrences of that parameter.
Parameters within ()'s are optional parameters.
Parameters within <>'s are required.
"haspermission" does a real permission check on specified user/group.
#
#
#
![installation](http://i.imgur.com/TG7vgq9.png)

Install a Redis server on your machine. It's really easy. (sudo apt-get install redis-server on Debian/Ubuntu, see this for CentOS, others see http://redis.io/download). Redis is optional but required if you want to edit permissions over the whole network in-game and reload all servers' permissions by the use of a command.

Place the plugin jar file in every server in your network including Bungee. Bungee is optional, but required if you need BungeeCord permissions to work with the plugin. This plugin will also run standalone in Bungee but you have to use the /ppbungee command.

Start a server.

Stop the server.

Edit the config.yml on both Bukkit and Bungee side to match your SQL setup. Also add the connection details to your Redis server. Set the "servername" property in config.yml to the same name of the server as in the bungee config if you want per-server Bukkit permissions and Redis to work.

Start your servers. The plugin will create the database tables required.
![permissions](http://i.imgur.com/Yb6JABm.png)

- powerfulperms.admin - Can use every command.
- powerfulperms.user
- powerfulperms.user.promote.<ladder>
- powerfulperms.user.demote.<ladder>
- powerfulperms.user.setrank
- powerfulperms.user.addgroup.<groupname>
- powerfulperms.user.removegroup.<groupname>
- powerfulperms.user.add
- powerfulperms.user.remove
- powerfulperms.user.clearperms
- powerfulperms.user.create
- powerfulperms.user.prefix
- powerfulperms.user.suffix
- powerfulperms.groups
- powerfulperms.group
- powerfulperms.group.create
- powerfulperms.group.delete
- powerfulperms.group.clearperms
- powerfulperms.group.add
- powerfulperms.group.remove
- powerfulperms.group.parents
- powerfulperms.group.prefix
- powerfulperms.group.suffix
- powerfulperms.group.setladder
- powerfulperms.group.setrank
- powerfulperms.group.rename
- powerfulperms.haspermission
- powerfulperms.reload
- powerfulperms.about

There are more permissions but can be determined by following this logic.
#
#
#
![config](http://i.imgur.com/LHPSGQv.png)

(https://pastebin.com/raw/1gr7wHbY)
