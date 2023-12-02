package ru.netology.vlada.domain;

import lombok.Data;

@Data
public class LoanOperation extends Operation implements ConsolePrintable{
    private int loanId;

    public LoanOperation(int id, int sum, String currency, String merchant) {
        super(id, sum, currency, merchant);
    }

    @Override
    public void printToConsole()
    {
        String loanIdString = "кридитный номер ";
        System.out.println(loanIdString);
    }
}