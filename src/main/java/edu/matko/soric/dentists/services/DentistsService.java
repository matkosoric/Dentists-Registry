package edu.matko.soric.dentists.services;

import edu.matko.soric.dentists.entities.Dentist;

import java.util.Optional;

public interface DentistsService {

    Iterable<Dentist> listAllDentists();

    Optional<Dentist> getDentistById(Integer id);

    Dentist saveDentist(Dentist dentist);

    void deleteDentist(Integer id);

}
