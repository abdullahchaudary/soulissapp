package it.angelic.soulissclient.drawer;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import it.angelic.soulissclient.R;
import it.angelic.soulissclient.model.SoulissNode;
import it.angelic.soulissclient.model.db.SoulissDBHelper;
import it.angelic.soulissclient.util.FontAwesomeEnum;
import it.angelic.tagviewlib.SimpleTagViewUtils;

public class DrawerMenuHelper {
    private static Context ctx;

    public DrawerMenuHelper(Context ctx) {
        DrawerMenuHelper.ctx = ctx;
    }

    public static final int DASHBOARD = -9;
    public static final int SCENES = -1;
    public static final int PROGRAMS = -2;
    public static final int MANUAL = -3;
    public static final int SETTINGS_NET = -4;
    public static final int SETTINGS_DB = -5;
    public static final int SETTINGS_SERVICE = -6;
    public static final int SETTINGS_VISUAL = -7;
    public static final int SETTINGS_UDPTEST = -8;
    public static final int SETTINGS_DASHBOARD = -11;
    public static final int TAGS = -10;

    private INavDrawerItem[] getNodes() {
        ArrayList<INavDrawerItem> tmp = new ArrayList<>();

        SoulissDBHelper db = new SoulissDBHelper(ctx);
        SoulissDBHelper.open();
        List<SoulissNode> nodes = db.getAllNodes();
        // Aggiungi nodi
        for (SoulissNode object : nodes) {
            NavMenuItem item2 = new NavMenuItem();
            item2.setId(object.getNodeId());
            item2.setLabel(object.getNiceName());
            item2.setIcon("" + object.getIconResourceId());
            item2.setUpdateActionBarTitle(false);
            tmp.add(item2);
        }

        INavDrawerItem[] tmpa = new INavDrawerItem[tmp.size()];
        tmp.toArray(tmpa);
        return tmpa;
    }

    public INavDrawerItem[] getStuff() {

        ArrayList<INavDrawerItem> tmp = new ArrayList<>();

        NavMenuSection it = NavMenuSection.create(-9, ctx.getString(R.string.functions).toUpperCase());
        tmp.add(it);

        NavMenuItem das = new NavMenuItem(DASHBOARD, ctx.getString(R.string.dashboard), FontAwesomeEnum.fa_dashboard.getFontName(),
                false, ctx);
        tmp.add(das);

        //if (apartFromMe != SCENE){
        NavMenuItem scenes = new NavMenuItem(SCENES, ctx.getString(R.string.scenes_title), FontAwesomeEnum.fa_moon_o.getFontName(),
                false, ctx);
        tmp.add(scenes);
        //	}

        //if (apartFromMe != PROGRAMS){
        NavMenuItem pro = new NavMenuItem(PROGRAMS, ctx.getString(R.string.programs_title), FontAwesomeEnum.fa_calendar.getFontName(),
                false, ctx);
        tmp.add(pro);

        NavMenuItem prore = new NavMenuItem(TAGS, ctx.getString(R.string.tag), FontAwesomeEnum.fa_tags.getFontName(),
                false, ctx);
        tmp.add(prore);
        //	}
        NavMenuItem man = new NavMenuItem(MANUAL, ctx.getString(R.string.manual_typicals), "fa-codepen",
                false, ctx);
        tmp.add(man);

        SoulissDBHelper db = new SoulissDBHelper(ctx);
        SoulissDBHelper.open();
        List<SoulissNode> nodes = db.getAllNodes();
        //Aggiungi nodi
        for (SoulissNode object : nodes) {
            NavMenuItem item2 = new NavMenuItem();
            item2.setId(object.getNodeId());
            item2.setLabel(object.getNiceName());
            item2.setIcon(SimpleTagViewUtils.getAwesomeNames(ctx).get(object.getIconResourceId()));
            item2.setUpdateActionBarTitle(false);
            tmp.add(item2);
        }
        NavMenuSection it2 = NavMenuSection.create(-10, ctx.getString(R.string.menu_options).toUpperCase());
        tmp.add(it2);
        NavMenuItem op2 = new NavMenuItem(SETTINGS_NET, ctx.getString(R.string.opt_net_home), FontAwesomeEnum.fa_wifi.getFontName(),
                false, ctx);
        tmp.add(op2);
        NavMenuItem op3 = new NavMenuItem(SETTINGS_DB, ctx.getString(R.string.opt_db), FontAwesomeEnum.fa_sitemap.getFontName(),
                false, ctx);
        tmp.add(op3);
        NavMenuItem op4 = new NavMenuItem(SETTINGS_SERVICE, ctx.getString(R.string.opt_service), FontAwesomeEnum.fa_spinner.getFontName(),
                false, ctx);
        tmp.add(op4);
        NavMenuItem op5 = new NavMenuItem(SETTINGS_VISUAL, ctx.getString(R.string.opt_visual), FontAwesomeEnum.fa_picture_o.getFontName(),
                false, ctx);
        tmp.add(op5);
        NavMenuItem opd = new NavMenuItem(SETTINGS_DASHBOARD, ctx.getString(R.string.dashboard), FontAwesomeEnum.fa_calendar.getFontName(),
                false, ctx);
        tmp.add(opd);
        NavMenuItem op6 = new NavMenuItem(SETTINGS_UDPTEST, ctx.getString(R.string.menu_test_udp), FontAwesomeEnum.fa_gears.getFontName(),
                false, ctx);
        tmp.add(op6);

        INavDrawerItem[] tmpa = new INavDrawerItem[tmp.size()];
        tmp.toArray(tmpa);
        return tmpa;
    }


}
