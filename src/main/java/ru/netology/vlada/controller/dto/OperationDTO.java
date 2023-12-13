package ru.netology.vlada.controller.dto;

import lombok.Data;

@Data
public class OperationDTO {
    private final int id;
    private final int sum;
    private final String currency; //валюта
    private final String merchant; //куда отдали деньги
}
