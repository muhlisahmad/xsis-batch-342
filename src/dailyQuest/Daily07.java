package dailyQuest;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Daily07 {
  public static void atmMachine() {
    Scanner sc = new Scanner(System.in);
    String pin = null;
    long balance = 0;
    int option = 0;
    String code = null;
    String account = null;
    long amount = 0;

    while (true) {
      System.out.print("Masukkan PIN\t\t: ");
      pin = sc.nextLine();
      if (!pin.matches("^\\d{6}$")) {
        System.out.println("PIN salah\n");
        continue;
      } else {
        break;
      }
    }

    while (true) {
      System.out.print("Uang yang disetor\t: ");
      try {
        balance = sc.nextLong();
        sc.nextLine();
        if (balance < 0) {
          System.out.println("Invalid input!!!\n");
          continue;
        } else {
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input!!!\n");
        sc.nextLine();
        continue;
      }
    }

    while (true) {
      System.out.println("Pilihan transfer\t: 1. Antar Rekening\t2.Antar Bank\n*input pilihannya berupa angka 1 atau 2");
      try {
        option = sc.nextInt();
        sc.nextLine();
        if (option == 1 || option == 2) {
          break;
        } else {
          System.out.println("Invalid input!!!\n");
          continue;
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input!!!\n");
        sc.nextLine();
        continue;
      }
    }

    while (true) {
      if (option == 2) {
        System.out.print("Masukkan kode bank\t\t: ");
        code = sc.nextLine();
        if (!code.matches("^\\d{3}$")) {
          System.out.println("Kode bank tidak valid\n");
          continue;
        } else {
          break;
        }
      } else {
        break;
      }
    }

    while (true) {
      System.out.print("Masukkan rekening tujuan\t: ");
      account = sc.nextLine();
      if (!account.matches("^\\d{10}$")) {
        System.out.println("No Rekening Salah\n");
        continue;
      } else {
        break;
      }
    }

    while (true) {
      System.out.print("Masukkan nominal transfer\t: ");
      try {
        amount = sc.nextLong();
        sc.nextLine();
        if (option == 1 && balance - amount < 0 || option == 2 && balance - amount - 7500 < 0) {
          System.out.println("Saldo tidak mencukupi\n");
          continue;
        } else {
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input!!!\n");
        sc.nextLine();
        continue;
      }
    }

    NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("id").setRegion("ID").build());

    balance = transfer(balance, amount, option == 1);
    System.out.println("Transaksi berhasil, saldo anda saat ini " + currency.format(balance));
    sc.close();
  }

  private static long transfer(long balance, long amount, boolean same) {
    long result = same ? balance - amount : balance - amount - 7500;
    return result;
  }
}
