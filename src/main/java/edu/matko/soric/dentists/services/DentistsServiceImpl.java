package edu.matko.soric.dentists.services;

import edu.matko.soric.dentists.entities.Dentist;
import edu.matko.soric.dentists.repositories.DentistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DentistsServiceImpl implements DentistsService {

    private DentistsRepository dentistsRepository;

    @Autowired
    public void setDentistsRepository(DentistsRepository dentistsRepository) {
        this.dentistsRepository = dentistsRepository;
    }

    @Override
        public Iterable<Dentist> listAllDentists() {
        return dentistsRepository.findAll();
    }

    @Override
    public Optional<Dentist> getDentistById(Integer id) {
        return dentistsRepository.findById(id);
    }

    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistsRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Integer id) {
        dentistsRepository.deleteById(id);
    }
}
