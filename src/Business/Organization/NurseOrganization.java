/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.Nurse;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rutugawad
 */
public class NurseOrganization extends Organization {

    public NurseOrganization() {
        super(Organization.Type.Nurse.getValue()); // Ensure this matches the parent class constructor
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Nurse()); // Ensure NurseRole is implemented correctly
        return roles;
    }
}