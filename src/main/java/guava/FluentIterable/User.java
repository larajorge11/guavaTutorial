package guava.FluentIterable;

enum Payment {
    CREDIT_CARD, POINTS, FREE, NA
}

public class User {
    private String name;
    private Payment payment;

    public User(String name, Payment payment) {
        this.name = name;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
