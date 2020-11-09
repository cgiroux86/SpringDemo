package com.example.demo.dao;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;

    }

    @Override
    public Optional <Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }



    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
