package com.gmail.gak.artem.view;

import com.gmail.gak.artem.EntityManager;
import com.gmail.gak.artem.MainUI;
import com.gmail.gak.artem.entity.Person;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.hibernate.HibernateException;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class OrdersView extends Composite implements View {
    EntityManager em = EntityManager.getInstance();

    public OrdersView() {
            try {
                Person person = new Person("Temp Name #copy", 32);

                em.getEm().getTransaction().begin();
                em.getEm().persist(person);
                em.getEm().getTransaction().commit();
            } catch (HibernateException e) {
                e.printStackTrace();
                em.getEm().getTransaction().rollback();
            }

            Query query = em.getEm().createQuery("SELECT p FROM Person p", Person.class);
            List<Person> people = (List<Person>) query.getResultList();

            Grid<Person> grid = new Grid<>();
            grid.setSizeFull();
            grid.setHeightByRows(20);
            grid.setItems(people);
            grid.addColumn(Person::getName).setCaption("Name");
            grid.addColumn(Person::getAge).setCaption("Age");


            Button button = new Button("Refresh", e -> {
                grid.getDataProvider().refreshAll();
            });

            Label title = new Label("<h3>Order LIst</h3>", ContentMode.HTML);

            CssLayout layout = new CssLayout();
            layout.setSizeFull();
            layout.setStyleName("my-panel");
            layout.addComponent(title);
            layout.addComponent(button);
            layout.addComponent(grid);

            setCompositionRoot(layout);

    }
}