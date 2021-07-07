package com.admin.saita.controller;

import com.admin.saita.model.Feedback;
import com.admin.saita.repository.IssueRepository;
import com.admin.saita.service.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by KaushiRajapakshe on 1/07/2021.
 */

/**
 * Feedback Issue Controller for insert,
 * get feedback issue{id}, get all feedback issue
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/react/feedback")
public class IssueController {

    //    Create final variable for logger
    private static final Logger LOGGER = LoggerFactory.getLogger(IssueController.class);

    //    Feedback Issue service interface object
    @Autowired
    private IssueRepository issueRepository;

    //    Feedback Sequence Generator Service object
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    //    Get all User feedback
    @GetMapping(value = "/issue")
    public @ResponseBody
    ResponseEntity<List<Feedback>> getIssueFeedback() {
        try {
            List<Feedback> feedbacks = new ArrayList<Feedback>();

            issueRepository.findAll().forEach(feedbacks::add);

            if (feedbacks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOGGER.info("Get issue {}", feedbacks);
            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Add user feedback
    @PostMapping(value = "/issue")
    public ResponseEntity<Feedback> insertIssue(@RequestBody Feedback feedback) {
        try {
            Feedback _feedback = issueRepository.save(new Feedback(sequenceGeneratorService.getNextSequence(Feedback.SEQUENCE_NAME), feedback.getApplicationName(), feedback.getApplicationVersion(),
                    feedback.getErrorType(), feedback.getErrorDescription(), feedback.getUserName(),
                    feedback.getContactNumber(), feedback.getUserEmail()));
            LOGGER.info("Insert issue {}", _feedback);
            return new ResponseEntity<>(_feedback, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Update user feedback
    @PatchMapping(value = "/issue/{id}")
    public @ResponseBody
    ResponseEntity<Feedback> updateIssue(@PathVariable(value = "id") int id, @RequestBody Feedback feedback) {
        Optional<Feedback> tutorialData = issueRepository.findById(id);

        if (tutorialData.isPresent()) {
            Feedback _feedback = tutorialData.get();
            _feedback.setApplicationVersion(feedback.getApplicationName());
            _feedback.setApplicationVersion(feedback.getApplicationVersion());
            _feedback.setErrorType(feedback.getErrorType());
            _feedback.setErrorDescription(feedback.getErrorDescription());
            _feedback.setUserName(feedback.getUserName());
            _feedback.setContactNumber(feedback.getContactNumber());
            _feedback.setUserEmail(feedback.getUserEmail());

            LOGGER.info("Get issue by id {} {}", id, _feedback);
            return new ResponseEntity<>(issueRepository.save(_feedback), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    Delete user feedback
    @DeleteMapping(value = "/issue/{id}")
    public @ResponseBody
    ResponseEntity<String> deleteFeedback(@PathVariable(value = "id") int id) {
        try {
            issueRepository.deleteById(id);
            LOGGER.info("Delete issue id {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
