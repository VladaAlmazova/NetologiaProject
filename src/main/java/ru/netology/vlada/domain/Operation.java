package ru.netology.vlada.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.SplittableRandom;

@Data
//@EqualsAndHashCode(callSuper=false)
public class Operation implements ConsolePrintable{
    private final int id;
    private final int sum;
    private final String currency; //валюта
    private final String merchant; //куда отдали деньги

    public Operation(int id, int sum, String currency, String merchant)
    {
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
    }

    public Operation()
    {
        this.id = 0;
        this.sum = 0;
        this.currency = "";
        this.merchant = "";
    }

    @Override
    public String toString()
    {
        return "Operation {"+
                "id= " + id +
                ", sum= " + sum +
                ", currency= " + currency +
                ", merchant= " + merchant + "};";
    }

    @Override
    public void printToConsole()
    {
        String operationString = "Транзакция номер " + id +
                "\n\tна сумму = " + sum + currency +
                "\n\tорганизации - " + merchant;;
        System.out.println(operationString);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Operation operation = (Operation) obj;
        return id == operation.id; // && sum == operation.sum && currency.equals(operation.currency) && merchant.equals(operation.merchant);
    }

    @Override
    public int hashCode() {
        return id*123;
    }


    public static void print(Operation operation){
        System.out.println(operation);
    }
}
