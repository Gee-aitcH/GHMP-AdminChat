package ghplugins;

import io.anuke.arc.util.CommandHandler;
import io.anuke.mindustry.core.NetClient;
import io.anuke.mindustry.entities.type.Player;
import io.anuke.mindustry.plugin.Plugin;

import static io.anuke.mindustry.Vars.*;

public class GHAdminChat extends Plugin {

    @Override
    public void registerServerCommands(CommandHandler handler) {
        handler.register("ac", "<message...>", "Admin Chat", arg -> playerGroup.all().each(p -> p.isAdmin, o -> o.sendMessage(arg[0], null, "[gold]<AC>Server")));
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        handler.<Player>register("ac", "<message...>", "Admin Chat", (arg, player) -> {
            if(player.isAdmin) playerGroup.all().each(p -> p.isAdmin, o -> o.sendMessage(arg[0], player, "[gold]<AC>" + NetClient.colorizeName(player.id, player.name)));
        });
    }
}
