import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.newCustomer(customerName, initialTransaction);
        }

        return false;
    }


    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.addCustomerTransaction(customerName, amount);
        }

        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch existingBranch = this.branches.get(i);
            if (existingBranch.getName().equals(branchName)) {
                return existingBranch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            System.out.println("Customer details for branch " + existingBranch.getName());
            ArrayList<Customer> customers = existingBranch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                Customer branchCustomer = customers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
