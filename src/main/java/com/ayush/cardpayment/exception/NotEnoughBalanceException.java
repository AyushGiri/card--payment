package com.ayush.cardpayment.exception;

public class NotEnoughBalanceException extends  Exception {

    public NotEnoughBalanceException() {
        super("Balance is low, Go work now!!");
    }

}
