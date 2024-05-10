package personalExercises;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class RealLifeCocurrencyBank {


//    private static final int MAX_CONCURRENT_WITHDRAWALS = 5;
    private static final int TOTAL_CLIENTS = 8;
    public static int MAX_CONCURRENT_WITHDRAWALS=5;


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_CONCURRENT_WITHDRAWALS);

        // Simulate multiple clients withdrawing money
        for (int i = 1; i <= TOTAL_CLIENTS; i++) {
            Runnable client = new Client("Client " + i, new Bank(1000 + i * 100)); // Each client gets a different account with an initial balance
            executor.execute(client); // Submit client task to the thread pool
            if (i % MAX_CONCURRENT_WITHDRAWALS == 0) {
                // Pause execution for 5 seconds after every batch of 5 clients
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Shut down the thread pool after all tasks are completed
        executor.shutdown();
    }


static class Bank {
    private int balance;

    public Bank(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount, String clientName) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(clientName + " withdraws $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println(clientName + ": Insufficient funds!");
        }
    }
}

static class Client implements Runnable {
    private static final Bank[] bankAccounts = new Bank[RealLifeCocurrencyBank.MAX_CONCURRENT_WITHDRAWALS]; // Array to hold bank accounts
    private final String name;
    private final int amountToWithdraw;

    public Client(String name, Bank bank) {
        this.name = name;
        this.amountToWithdraw = (int) (Math.random() * 200) + 100; // Random amount between 100 and 300
        for (int i = 0; i < RealLifeCocurrencyBank.MAX_CONCURRENT_WITHDRAWALS; i++) {
            if (bankAccounts[i] == null) {
                bankAccounts[i] = bank; // Assign bank account to the client
                break;
            }
        }
    }

    @Override
    public void run() {
        for (Bank bankAccount : bankAccounts) {
            if (bankAccount != null) {
                bankAccount.withdraw(amountToWithdraw, name);
            }
        }
    }
}
}