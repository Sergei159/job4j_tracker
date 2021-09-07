package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод находит пользователя по паспорту
     * @param passport передаваемый методу паспорт пользователя
     * @return возвращает пользователя ,если пасспорт существует,
     * иначе возвращает null
     */

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет аккаунт по паспорту пользователя и реквизитам аккаунта
     * @param passport передаваемый паспорт
     * @param requisite передаваемые реквищиты
     * @return аккаунт,если пользователь с передаваемым паспортом  и реквизитами
     * найден
     *
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }

            }
        }
        return null;
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
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}