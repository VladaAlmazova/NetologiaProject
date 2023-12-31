package ru.netology.vlada.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CashbackOperation extends Operation implements ConsolePrintable{
    private int cashbackAmount;

    public CashbackOperation(int id, int sum, String currency, String merchant) {
        super(id, sum, currency, merchant);
    }

    @Override
    public void printToConsole()
    {
        String cashbackAmountString = "cash-back = ";
        System.out.println(cashbackAmountString);
    }
}
