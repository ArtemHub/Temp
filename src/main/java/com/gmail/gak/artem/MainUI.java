package com.gmail.gak.artem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.annotation.WebServlet;

import com.gmail.gak.artem.entity.Person;
import com.gmail.gak.artem.view.OrdersView;
import com.gmail.gak.artem.view.View1;
import com.gmail.gak.artem.view.View2;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.vaadin.teemusa.sidemenu.SideMenu;

import java.util.List;

@Theme("test")
@PushStateNavigation
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        SideMenu sideMenu = new SideMenu();
        setContent(sideMenu);

        Navigator navigator = new Navigator(this, sideMenu);
        setNavigator(navigator);

        navigator.addView("", OrdersView.class);
        navigator.addView("view1", View1.class);
        navigator.addView("view2", View2.class);


        navigator.navigateTo("");

        sideMenu.addNavigation("Clients", VaadinIcons.USER_CARD, "");
        sideMenu.addNavigation("Products", VaadinIcons.CUBES, "view1");
        sideMenu.addNavigation("Orders", VaadinIcons.CART, "view2");

        sideMenu.setMenuCaption("Test");
    }

    public String tmp() {
        return "TESSSSTTT!";
    }

    @WebServlet(urlPatterns = "/*", name = "MainUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {
    }
}
