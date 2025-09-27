package goormMondayChallenge;

import java.io.*;
import java.util.*;

public class Problem13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int initialBalance = Integer.parseInt(st.nextToken());
        int transactionCount = Integer.parseInt(st.nextToken());

        BankAccount account = new BankAccount(initialBalance);

        for (int i = 0; i < transactionCount; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            account.processTransaction(command, amount);
        }
        System.out.println(account.getBalance());
    }
}

/** 은행 계좌 클래스 */
class BankAccount {
    private int balance;
    private final Queue<Integer> reservationQueue;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
        this.reservationQueue = new ArrayDeque<>();
    }

    public int getBalance() {
        return balance;
    }

    /** 거래 처리 */
    public void processTransaction(String command, int amount) {
        switch (command) {
            case "deposit" -> deposit(amount);
            case "pay" -> pay(amount);
            case "reservation" -> reserve(amount);
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        }
    }

    /** 입금 처리 + 예약된 결제 처리 */
    private void deposit(int amount) {
        balance += amount;
        processReservations();
    }

    /** 결제 */
    private void pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    /** 예약 결제 */
    private void reserve(int amount) {
        if (reservationQueue.isEmpty()) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                reservationQueue.add(amount);
            }
        } else
            reservationQueue.add(amount);
    }

    /** 예약 결제 처리 (잔액이 충분할 때) */
    private void processReservations() {
        while (!reservationQueue.isEmpty() && balance >= reservationQueue.peek()) {
            balance -= reservationQueue.poll();
        }
    }
}
