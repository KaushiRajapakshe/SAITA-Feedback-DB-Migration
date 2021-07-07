package com.admin.saita.repository;

import com.admin.saita.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by KaushiRajapakshe on 1/07/2021.
 */

/**
 * Feedback Issue Model for insert,
 * get issue attributes
 * and set issue attributes on db
 */
@Repository
public interface IssueRepository extends MongoRepository<Feedback, String> {

    Optional<Feedback> findById(int id);
    void deleteById(int id);
}
