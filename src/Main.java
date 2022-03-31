public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("UBB");

        if(bank.addBranch("Serdika")) {
            System.out.println("Branched created successfully");
        } else {
            System.out.println("Cannot add branch");
        }

        if(bank.addCustomer("Serdika", "Tiko", 20.55)) {
            System.out.println("Successfully created customer with name Tiko and added initial amount of 20.55");
        } else {
            System.out.println("Cannot create customer with name Tiko");
        }

        if(bank.addCustomer("Serdika", "Tiko", 20.55)) {
            System.out.println("Successfully created customer with name Tiko and added initial amount of 20.55");
        } else {
            System.out.println("Cannot create customer with name Tiko");
        }

        bank.addCustomer("Serdika", "Mitko", 2.55);
        bank.addCustomer("Serdika", "Pesho", 35.44);
        bank.listCustomers("Serdika", true);
        bank.addCustomerTransaction("Serdika", "Tiko", 200.00);
        bank.listCustomers("Serdika", true);



    }
}
