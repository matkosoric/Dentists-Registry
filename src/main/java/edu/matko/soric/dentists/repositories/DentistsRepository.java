package edu.matko.soric.dentists.repositories;

import edu.matko.soric.dentists.entities.Dentist;
import org.springframework.data.repository.CrudRepository;

public interface DentistsRepository extends CrudRepository <Dentist, Integer> {
}
