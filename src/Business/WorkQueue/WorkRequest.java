/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

public abstract class WorkRequest {

   
    //private String requestId;
    private String requestId;
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String type; // Add a type field to store the subclass name

    
//    public String getRequestId() {
//        return requestId;
//    }
//
//    public void setRequestId(String requestId) {
//        this.requestId = requestId;
//    }
    public WorkRequest() {
        this.requestId = generateRequestId();
        this.type = this.getClass().getSimpleName(); // Automatically set type to the subclass name
        requestDate = new Date();
    }
    private String generateRequestId() {
        return "REQ-" + System.currentTimeMillis();
    }

    // Getter and Setter for Request ID
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    // Getter for type field
    public String getType() {
        return type;
    }
}
