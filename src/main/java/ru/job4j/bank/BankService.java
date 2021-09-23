package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * @author Sandrakov Sergei
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции Map.
     * Коллекция  содержит пользователя User
     * и список его существующих банковских аккаунтов
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя
     * Если такого пользователя нет, метод  добавляет пользователя и
     * создает новый список с банковскими аккаунтами
     * Если пользователь уже существует,метод не добавляет пользователя еще раз
     * @param user - Пользователь,который добавляется в карту.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод добавляет  банковский аккаунт
     * @param passport передаваемый методу паспорт пользователя
     * @param account передаваемый методу банковский аккаунт пользователя
     * Если пользователь с передаваемым паспортом существует,метод
     * добавляет аккаунт
     */

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод находит пользователя по паспорту
     * @param passport передаваемый методу паспорт пользователя
     * @return возвращает пользователя ,если пасспорт существует,
     * иначе возвращает null
     */

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        rsl = users.keySet().
                stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
        return rsl;
    }

    /**
     * Метод ищет аккаунт по паспорту пользователя и реквизитам аккаунта
     * @param passport передаваемый паспорт
     * @param requisite передаваемые реквищиты
     * @return аккаунт,если пользователь с передаваемым паспортом  и реквизитами
     * найден
     *
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод переводит деньги с одного счета на другой
     * @param srcPassport паспорт пользователя,со  счета
     * оторого переводят деньги
     * @param srcRequisite реквизиты аккаунта,с которого переводят деньги
     * @param destPassport паспорт пользователя,на счет
     * которого переводят деньги
     * @param destRequisite реквизиты аккаунта, на который переводят деньги
     * @param amount сумма перевода
     * @return true если перевод денег осуществился
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}