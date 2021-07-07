package com.admin.saita.controller;

import com.admin.saita.model.Feedback;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * Created by KaushiRajapakshe on 1/07/2021.
 */

/**
 * Issue Controller Test Cases
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class FeedbackControllerTest {
    @Autowired
    private IssueController issueController;

    @Test
    public void addIssueTest()  {
//        Create IssueDTO object
        Feedback feedback = new Feedback();
        feedback.setApplicationName("VSCode");
        feedback.setContactNumber("777425432");
        feedback.setApplicationVersion("2019.1.4");
        feedback.setErrorType("Application");
        feedback.setUserEmail("kaushi.rajapakshe1@gmail.com");
        feedback.setUserName("Kaushi Rajapakshe");
        feedback.setErrorDescription("9000 port block");

        Feedback aFeedback = feedback;

        ObjectMapper mapper = new ObjectMapper();
        String actualResult = null;
        try {
            actualResult = mapper.writeValueAsString(aFeedback);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        Insert Issue function call
        String expectedResult = new Gson().toJson(issueController.insertIssue(feedback).getBody(), new TypeToken<Object>() {
        }.getType());

//        Check actual and expected values
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void deleteIssueTest() {
        // Delete Issue function call
        String expectedResult = issueController.deleteFeedback(100).getBody();
        String actualResult = "Delete Fail for feedback id : 100";

        // Check actual and expected values
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void deleteIssuesTest() {
        // Delete Issue function call
        String expectedResult = issueController.deleteFeedback(150).getBody();
        String actualResult = "Delete Fail for feedback id : 150";

        // Check actual and expected values
        assertEquals(actualResult,expectedResult);
    }
}