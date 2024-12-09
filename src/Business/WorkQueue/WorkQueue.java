/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

public class WorkQueue {

    private ArrayList<WorkRequest> workRequests;
    private List<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequests = new ArrayList();
        workRequestList = new ArrayList<>();
    }
public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
  // Method to add work request to the list
    public void addWorkRequest(WorkRequest request) {
        workRequestList.add(request);
    }
    public ArrayList<WorkRequest> getWorkRequests() {
        return workRequests;
    }
    public List<PharmacyWorkRequest> getPharmacyWorkRequests() {
        List<PharmacyWorkRequest> pharmacyRequests = new ArrayList<>();
        for (WorkRequest request : workRequestList) {
            if (request instanceof PharmacyWorkRequest) {
                pharmacyRequests.add((PharmacyWorkRequest) request);
            }
        }
        return pharmacyRequests;
    }
}
