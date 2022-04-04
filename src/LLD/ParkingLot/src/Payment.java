package LLD.ParkingLot.src;

import java.util.UUID;

public class Payment {
    private String id;
    private String type;
    private Long timeStamp;
    private PaymentStatus paymentStatus;
    private Long amount;

    public Payment(String type, Long timeStamp, PaymentStatus paymentStatus, Long amount) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.timeStamp = timeStamp;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
