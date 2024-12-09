/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.PharmacistRole;
import Business.Role.Role;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.WorkQueue;


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Diya
 */
public class PharmacyOrganization extends Organization {
     public PharmacyOrganization() {
        super(Type.Pharmacy.getValue()); // Initialize with the correct type
    }

    // This method is fine as it calls the inherited getWorkQueue from Organization
    public WorkQueue getWorkQueue() {
        return super.getWorkQueue(); // Access workQueue from the parent class
    }

    // Method to get all pharmacy work requests
    public List<PharmacyWorkRequest> getPharmacyWorkRequests() {
        return super.getWorkQueue().getPharmacyWorkRequests();  // Call method from WorkQueue
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PharmacistRole());
        return roles;
    }
 

}
