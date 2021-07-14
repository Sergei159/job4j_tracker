package ru.job4j.oop;

public class Error {

   private boolean active;
   private  int status;
   private  String message;

   public Error() {
   }

   public Error(boolean active, int status, String message) {
       this.active = active;
       this.status = status;
       this.message = message;
   }

    public void printInfo() {
        System.out.println("cостояние: " + active);
        System.out.println("номер: " + status);
        System.out.println(message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error404 = new Error(true, 404, "Not found");
        Error error401 = new Error(true, 401, "Unauthorized");
        error404.printInfo();
        error401.printInfo();
    }
}
