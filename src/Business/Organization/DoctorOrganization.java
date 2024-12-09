/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.OncologistDoctorRole;
import Business.Role.RadiologistDoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Diya
 */
public class DoctorOrganization extends Organization{

    public DoctorOrganization() {
        super(Organization.Type.Doctor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new OncologistDoctorRole());
        roles.add(new RadiologistDoctorRole());
        return roles;
    }
     
}