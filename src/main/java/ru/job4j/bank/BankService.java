package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        users.putIfAbsent(findByPassport(srcPassport), new ArrayList<>());
        users.putIfAbsent(findByPassport(destPassport), new ArrayList<>());
        double srcBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
        double destBalance = findByRequisite(destPassport, destRequisite).getBalance();
        if (findByRequisite(srcPassport, srcRequisite) != null
        && findByRequisite(destPassport, destRequisite) != null
        && srcBalance >= amount) {
            srcBalance -= amount;
            findByRequisite(srcPassport, srcRequisite).setBalance(srcBalance);
            destBalance += amount;
            findByRequisite(destPassport, destRequisite).setBalance(destBalance);
            rsl = true;
        }
        return rsl;
    }
}