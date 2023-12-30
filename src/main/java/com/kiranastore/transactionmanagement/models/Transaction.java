package com.kiranastore.transactionmanagement.models;

import com.kiranastore.transactionmanagement.controller.TransactionController;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.FixedRateTask;
import org.springframework.web.client.RestTemplate;



@Getter
@Setter
@Entity
public class Transaction extends BaseTransaction{
    public int transactionId;
    @Column(name = "product_name")
    private String productName;
    @Column
    private int quantity;
    @Column
    private double rate;
    @Column
    private double amount;
    @Column
    private String currency;
    @Enumerated (EnumType.ORDINAL)
    private PaymentType paymentType;
    public double getAmountInUSD() {
        amount = amount + (quantity * rate);
        if("USD".equals(currency)){
            return amount; //no need to convert if already in USD
        }else {
            //Fetch exchange rate and convert to INR
            double exchangeRate = getExchangeRate("USD");
            System.out.println(exchangeRate);
            return amount/exchangeRate;
        }

    }

    private double getExchangeRate(String targetCurrency){
        // Implement the logic to call the currency conversion API and get the exchange rate
        // You can use libraries like RestTemplate, HttpClient, or other HTTP clients
        TransactionController transactionController = new TransactionController();

        // Example using RestTemplate (you need to handle exceptions and error cases)
        String apiURL = "https://api.fxratesapi.com/latest";
        ResponseEntity<FxRatesApiResponse>responseEntity = new RestTemplate().getForEntity(apiURL, FxRatesApiResponse.class);

        if(responseEntity.getStatusCode() == HttpStatus.OK ){
            FxRatesApiResponse response = responseEntity.getBody();

            if(response != null && response.isSuccess()){
//                System.out.println("response "+response.getRates().get("INR"));
                return response.getRates().get("INR");

            }
        }
         //Handle API error or Invalid response
        throw  new RuntimeException("Error fetching currency conversion rates");

    }



}
