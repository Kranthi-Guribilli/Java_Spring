package com.example20.SchoolApplication.service;

import com.example20.SchoolApplication.constants.EazySchoolConstants;
import com.example20.SchoolApplication.model.Contact;
import com.example20.SchoolApplication.model.Person;
import com.example20.SchoolApplication.model.Roles;
import com.example20.SchoolApplication.repository.ContactRepository;
import com.example20.SchoolApplication.repository.PersonRepository;
import com.example20.SchoolApplication.repository.RolesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}