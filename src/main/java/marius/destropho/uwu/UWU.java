package marius.destropho.uwu;


import marius.destropho.uwu.modules.chat.ChatTweaks;
import marius.destropho.uwu.modules.main.AutoBedCraft;
import marius.destropho.uwu.modules.main.PacketFly;
import marius.destropho.uwu.modules.main.SurroundPlus;
import marius.destropho.uwu.modules.main.VectorCevBreaker;
import marius.destropho.uwu.modules.chat.*;
import marius.destropho.uwu.modules.hud.items.*;
import marius.destropho.uwu.modules.hud.misc.*;
import marius.destropho.uwu.modules.hud.stats.*;
import marius.destropho.uwu.modules.hud.visual.*;
import marius.destropho.uwu.modules.main.*;
import marius.destropho.uwu.modules.player.*;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.config.Config;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.render.hud.HUD;
import net.minecraft.item.Items;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;


public class UWU extends MeteorAddon {
    public static final Logger LOG = LogManager.getLogger();
    public static final Category CATEGORY = new Category("UWU v1", Items.END_PORTAL_FRAME.getDefaultStack());
    public static final Category CATEGORY1 = new Category("UWU v2", Items.ENDER_EYE.getDefaultStack());
    public static final String VERSION = "1.0";

    @Override
    public void onInitialize() {
        LOG.info("Initializing UWU Client- Destro on top!");

        MeteorClient.EVENT_BUS.registerLambdaFactory("marius.destropho.uwu", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

        //Modules
        Modules.get().add(new PacketFly());
        Modules.get().add(new AutoBedCraft());
        Modules.get().add(new AutoCityPlus());
        Modules.get().add(new AutoLogin());
        Modules.get().add(new AutoXP());
        Modules.get().add(new AutoRespawn());
        Modules.get().add(new AnchorAura());
        Modules.get().add(new ArmorAlert());
        Modules.get().add(new BedAura());
        Modules.get().add(new BedDisabler());
        Modules.get().add(new BurrowAlert());
        Modules.get().add(new BurrowBreaker());
        Modules.get().add(new ChatTweaks());
        Modules.get().add(new NametagsPlus());
        Modules.get().add(new PopCounter());
        Modules.get().add(new RPC());
        Modules.get().add(new SelfTrapPlus());
        Modules.get().add(new SurroundPlus());
        Modules.get().add(new ChorusPredict());
        Modules.get().add(new BowBomb());
        Modules.get().add(new VectorCevBreaker());
        Modules.get().add(new cwystalAuwa());
        Modules.get().add(new StrafePlus());
        Modules.get().add(new BPlusSurround());
        Modules.get().add(new VectorCevBreaker());
        Modules.get().add(new CevBreaker());
        Modules.get().add(new BplusSelfTrap());


        //HUD
        HUD hud = Modules.get().get(HUD.class);
        //Item Counters
        hud.elements.add(new Beds(hud));
        hud.elements.add(new Crystals(hud));
        hud.elements.add(new Gaps(hud));
        hud.elements.add(new TextItems(hud));
        hud.elements.add(new XP(hud));
        //Stats
        hud.elements.add(new Deaths(hud));
        hud.elements.add(new Highscore(hud));
        hud.elements.add(new KDRatio(hud));
        hud.elements.add(new Killstreak(hud));
        hud.elements.add(new Kills(hud));
        //Visual
        hud.elements.add(new Logo(hud));
        hud.elements.add(new VisualBinds(hud));
        hud.elements.add(new Watermark(hud));
        hud.elements.add(new Welcome(hud));

        Config.get().customWindowTitleText = "UWU CLient - " + UWU.VERSION;
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
        Modules.registerCategory(CATEGORY1);
    }

}

