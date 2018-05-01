package com.mycompany.myapp;
import Gui.Nos_categories;
import Gui.Nos_recettes;
import Gui.SplashForm;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Toolbar;

public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
        UIManager.getInstance().setBundle(theme.getL10N("l1", "en"));
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }
      //  new SplashForm(theme).show();
    
           Nos_recettes h = new Nos_recettes();
        h.getF().show();
      
     //   Nos_categories h = new Nos_categories();
     //   h.getF().show();
    }
    public void stop() {
        current = Display.getInstance().getCurrent();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }

}
