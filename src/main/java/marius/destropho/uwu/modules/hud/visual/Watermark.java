package marius.destropho.uwu.modules.hud.visual;


import marius.destropho.uwu.Orion;
import marius.destropho.uwu.modules.chat.ChatTweaks;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;
import meteordevelopment.meteorclient.systems.modules.render.hud.modules.DoubleTextHudElement;

public class Watermark extends DoubleTextHudElement {
    public Watermark(HUD hud) {
        super(hud, "UWU Client-watermark", "Display UWU Client Watermark!.", "");
    }

    @Override
    protected String getRight() {
        ChatTweaks chatTweaks = Modules.get().get(ChatTweaks.class);
        if (chatTweaks.isActive() && chatTweaks.customPrefix.get()) {
            return chatTweaks.prefixText.get() + " " + Orion.VERSION;
        }
        return "UWU Client " + Orion.VERSION; }
}
