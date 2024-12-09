/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PharmacyEnterprise extends Enterprise {
       public PharmacyEnterprise(String name) {
        super(EnterpriseType.Pharmacy, name);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        // No roles directly supported by the Pharmacy Enterprise
        return null;
    }

//    public List<Organization.Type> getOrganizationTypes() {
//        List<Organization.Type> orgTypes = new ArrayList<>();
//        orgTypes.add(Organization.Type.Pharmacy); // Support Pharmacist organizations
//        return orgTypes;
//    }
@Override
public List<Organization.Type> getOrganizationTypes() {
    List<Organization.Type> orgTypes = new ArrayList<>();
    orgTypes.add(Organization.Type.Pharmacy); // Include Pharmacy here
    return orgTypes;
}

    @Override
    public String toString() {
        return this.getName();
    }
}
