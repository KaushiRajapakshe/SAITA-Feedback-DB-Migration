package com.admin.saita.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
/**
 * Created by KaushiRajapakshe on 1/07/2021.
 */

/**
 * Feedback Issue for insert,
 * get issue attributes
 * and set issue attributes
 */
@Document(collection = "feedbacks")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feedback {
    @Transient
    public static final String SEQUENCE_NAME = "feedback_sequence";

    @Id
    private int id;

    private String applicationName;
    private String applicationVersion;
    private String errorDescription;
    private String errorType;
    private String errorStatus;
    private String errorAction;
    private String errorTarget;
    private String userName;
    private String contactNumber;
    private String userEmail;
    private List<Feedback> children;

    public Feedback() {
        // create Feedback object
    }

    public Feedback(int id, String applicationName, String applicationVersion, String errorType, String errorDescription,
                    String userName, String contactNumber, String userEmail) {
        this.id = id;
        this.applicationName = applicationName;
        this.applicationName = applicationVersion;
        this.errorType = errorType;
        this.errorDescription = errorDescription;
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.userEmail = userEmail;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorAction() {
        return errorAction;
    }

    public void setErrorAction(String errorAction) {
        this.errorAction = errorAction;
    }

    public String getErrorTarget() {
        return errorTarget;
    }

    public void setErrorTarget(String errorTarget) {
        this.errorTarget = errorTarget;
    }

    public List<Feedback> getChildren() {
        return children;
    }

    public void setChildren(List<Feedback> children) {
        this.children = children;
    }

}
