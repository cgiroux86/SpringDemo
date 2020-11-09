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
        Optional <Person> foundPerson = selectPersonById(id);
        if(foundPerson.isEmpty()) {return 0;}
        else{
           DB.remove(foundPerson.get());
           return 1;
        }

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
    public int updatePersonById(UUID id, Person updates) {


         return selectPersonById(id).map(p -> {
                int indexToUpdate = DB.indexOf(p);
                if(indexToUpdate >= 0) {
                    DB.set(indexToUpdate, new Person(id, updates.getName()));
                    return 1;
                }
                return 0;
            }).orElse(0);
    }
}
