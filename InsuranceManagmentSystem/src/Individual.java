public class Individual extends Account{
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        double price=insurance.getPrice()*1.05;
        insurance.setPrice(price);
        super.insurances.add(insurance);
    }
}
