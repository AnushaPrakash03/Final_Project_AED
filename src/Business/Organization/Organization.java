/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;


public abstract class Organization {

    private String organizationName;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter = 0;
    //private String type; // New type field to store the subclass name

    

    public enum Type {

        //HealthCenter Organization Types:
        Admin("Admin Organization"), Doctor("Doctor Organization"),Nurse("Nurse Organization"), Lab("Lab Organization"), Patient("Patient Organization"), Accountant("Accountant Organization"),
        //Insurance Organization Types:
        InsuranceAgent("Insurance Agent Organization"), PolicyPlanner("Insurance Policy Planning Organization"), InsuranceFundOrganization("Insurance Finance Organization"),
        //Government Organization Types
        GovernmentAccountant("Treasurer Organization"), GovernmentSecretary("Secretary Organization"), HealthcareChief("Healthcare Officer Organization"),
        //Pharmacist Organization Types:
        Pharmacy("Pharmacy Organization");
        

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.organizationName = name;
        //this.type = this.getClass().getSimpleName(); // Automatically set type to the subclass name
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return organizationName;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.organizationName = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

//    public String getType() {
//        return type; // Getter for the type field
//    }
//    
    
    @Override
    public String toString() {
        return organizationName;
    }

}
