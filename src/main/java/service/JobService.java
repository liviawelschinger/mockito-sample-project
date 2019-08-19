package service;

import model.JobPosition;
import model.Person;

import java.util.Optional;
import java.util.stream.Stream;

public interface JobService {

    // Credit: https://github.com/eugenp/tutorials/blob/master/testing-modules/mockito-2/src/main/java/com/baeldung/mockito/java8/JobService.java

    /*
        https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
        A container object which may or may not contain a non-null value.
        If a value is present, isPresent() will return true and get() will return the value.
        Additional methods that depend on the presence or absence of a contained value are provided,
        such as orElse() (return a default value if value not present) and ifPresent() (execute a block of code if the value is present).

        This is a value-based class; use of identity-sensitive operations (including reference equality (==),
        identity hash code, or synchronization) on instances of Optional may have unpredictable results and should be avoided.
     */
    Optional<JobService> findCurrentJobPosition(Person person);

    default boolean assignJobPosition(Person person, JobPosition jobPosition) {
        if(!findCurrentJobPosition(person).isPresent()){
            person.setCurrentJobPosition(jobPosition);

            return true;
        } else {
            return false;
        }
    }

    Stream<JobPosition> listJobs(Person person);

}
