package com.gmail.gak.artem.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

public class View1 extends Composite implements View {
    public View1() {
        setCompositionRoot(new Label("This is View-1"));
    }
}
