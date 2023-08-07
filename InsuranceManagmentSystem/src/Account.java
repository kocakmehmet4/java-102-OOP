import java.util.ArrayList;

public  abstract class Account implements Comparable<Account> {

    private User user;
    protected ArrayList<Insurance> insurances;
    private AuthenticationStatus authenticationStatus;

    public enum AuthenticationStatus{
        SUCCESS,FAIL
    }



    public Account(User user) {
        this.authenticationStatus = authenticationStatus;
        this.user = user;
        this.insurances = insurances;
    }

    public void login(String email,String password) throws InvalidAuthenticationException{
        if(this.user.getEmail().equals(email) && this.user.getPassword().equals(password)){
            this.authenticationStatus=AuthenticationStatus.SUCCESS;
        }else{
            throw new InvalidAuthenticationException("Invalid account");
        }
    }


    public abstract void addInsurance(Insurance insurance);

    public void addAddress(Address address){
        if(authenticationStatus==AuthenticationStatus.SUCCESS){
            user.addAddress(address);
        }
    }
    public void removeAddress(Address address){
        if(authenticationStatus==AuthenticationStatus.SUCCESS){
            user.addAddress(address);
        }
    }

    @Override
    public int compareTo(Account o) {
        return this.user.getEmail().compareTo(o.user.getEmail());
    }

    @Override
    public int hashCode() {
        // you can use the email as the basis for the hash code
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account other = (Account) obj;
        // you can check if two accounts are equal based on the email
        return user.getEmail().equals(other.user.getEmail());
    }

    public final void showUserInfo() {
        System.out.println("--------------Müşteri Bilgileri-------------");
        System.out.println("Name : "+user.getName());
        System.out.println("Surname : "+user.getSurname());
        System.out.println("E-Mail : "+ user.getEmail());
        System.out.println("Age : "+user.getAge());
        System.out.println("Job : "+user.getOccupation());
        System.out.println();
        System.out.println("---------------------------------------------");





    }

    public void insuranceInfo() {
        System.out.println("\n---------------Insurance List----------------");
        for(Insurance s : insurances) {
            System.out.println(s);

        }
    }

    public void addressListInfo() {
        System.out.println("---------------Address List------------------");
        for (Address address : user.getAddressList()) {
             System.out.println(address);
         }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }
}
