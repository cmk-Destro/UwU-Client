package marius.destropho.uwu.modules.hud.stats;

import marius.destropho.uwu.utils.misc.Stats;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;
import meteordevelopment.meteorclient.systems.modules.render.hud.modules.DoubleTextHudElement;

public class Highscore extends DoubleTextHudElement {
    public Highscore(HUD hud) {
        super(hud, "highscore", "Display your highest killstreak", "Highscore: ");
    }

    @Override
    protected String getRight() {return String.valueOf(Stats.highscore); }
}
