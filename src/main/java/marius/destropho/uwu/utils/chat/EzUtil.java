package marius.destropho.uwu.utils.chat;

import marius.destropho.uwu.UWU;
import marius.destropho.uwu.modules.chat.PopCounter;
import marius.destropho.uwu.modules.main.BedAura;
import marius.destropho.uwu.utils.Wrapper;
import marius.destropho.uwu.utils.misc.Placeholders;
import marius.destropho.uwu.utils.misc.Stats;
import marius.destropho.uwu.utils.misc.StringHelper;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.combat.CrystalAura;
import meteordevelopment.meteorclient.systems.modules.combat.KillAura;
import meteordevelopment.meteorclient.utils.player.ChatUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static meteordevelopment.meteorclient.MeteorClient.mc;

public class EzUtil {
    public static List<String> currentTargets = new ArrayList<>();

    public static void sendAutoEz(String playerName) {
        increaseKC();
        PopCounter popCounter = Modules.get().get(PopCounter.class);
        List<String> ezMessages = popCounter.ezMessages.get();
        if (ezMessages.isEmpty()) {
            ChatUtils.warning("Your auto ez message list is empty!");
            return;
        }
        String ezMessage = ezMessages.get(new Random().nextInt(ezMessages.size()));
        if (ezMessage.contains("{player}")) ezMessage = ezMessage.replace("{player}", playerName);
        if (popCounter.doPlaceholders.get()) ezMessage = Placeholders.apply(ezMessage);
        if (popCounter.killStr.get()) { ezMessage = ezMessage + " | Killstreak: " + Stats.killStreak; }
        if (popCounter.suffix.get()) { ezMessage = ezMessage + " | UWU CLIENT " + UWU.VERSION; }
        mc.player.sendChatMessage(ezMessage);
        if (popCounter.pmEz.get()) Wrapper.messagePlayer(playerName, StringHelper.stripName(playerName, ezMessage));
    }

    public static void increaseKC() {
        Stats.kills++;
        Stats.killStreak++;
    }

    public static void updateTargets() {
        currentTargets.clear();
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(Modules.get().get(CrystalAura.class));
        modules.add(Modules.get().get(KillAura.class));
        modules.add(Modules.get().get(BedAura.class));
        for (Module module : modules) currentTargets.add(module.getInfoString());
    }

}
