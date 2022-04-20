package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.function.Function;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    /**
     * Приватный метод, чтобы избежать дублирование кода
     * открывает сессию, начинает транзакцию
     * после выполнения входной функции закрывает сессию
     * @param command
     * @param <T>
     * @return
     */
    private <T> T transaction(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            T result = command.apply(session);
            transaction.commit();
            return result;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Item add(Item item) {
        transaction(session -> session.save(item));
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        item.setId(id);
        transaction(session ->  {
            session.update(item);
            return new Object();
        });
        return item.equals(findById(id));
    }

    @Override
    public boolean delete(int id) {
        Item item = new Item(null);
        item.setId(id);
        transaction(session -> {
            session.delete(item);
            return new Object();
        });
        return true;
    }

    @Override
    public List<Item> findAll() {
        return transaction(session -> session
                .createQuery("from ru.job4j.tracker.Item")
                .list());
    }

    @Override
    public List<Item> findByName(String key) {
        return transaction(session -> session.createQuery(
                "from ru.job4j.tracker.Item where name = :keyName")
                .setParameter("keyName", key).list());
    }

    @Override
    public Item findById(int id) {
        return transaction(session -> session.get(Item.class, id));
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
