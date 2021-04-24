package ghplugins;

import arc.util.CommandHandler;
import mindustry.core.NetClient;
import mindustry.gen.Groups;
import mindustry.gen.Player;
import mindustry.mod.Plugin;

import static io.anuke.mindustry.Vars.*;

public class GHAdminChat extends Plugin {

    @Override
    public void registerServerCommands(CommandHandler handler) {
        handler.register("ac", "<message...>", "Admin Chat", arg -> Groups.player.each(p -> p.admin, o -> o.sendMessage(arg[0], null, "[gold]<AC>Server")));
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        handler.<Player>register("ac", "<message...>", "Admin Chat", (arg, player) -> {
            if(player.admin) Groups.player..each(p -> p.admin, o -> o.sendMessage(arg[0], player, "[gold]<AC>" + NetClient.colorizeName(player.id, player.name)));
        });
    }
}
