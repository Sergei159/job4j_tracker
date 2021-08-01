package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key)
            throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
<<<<<<< HEAD
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        throw new ElementNotFoundException(
                "Name is not found");
=======
            if (value[i] == key) {
                rsl = i;
            } else {
                throw new ElementNotFoundException(
                        "Name is not found");
            }
        }
        return rsl;
>>>>>>> origin/master
    }

    public static void main(String[] args) {
        String[] names = {
                "name1", "name2", "name3", "name4"
        };
        try {
            indexOf(names, "name5");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();

        }
    }
}