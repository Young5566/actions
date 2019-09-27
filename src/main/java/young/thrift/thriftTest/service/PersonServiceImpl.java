package young.thrift.thriftTest.service;

import org.apache.thrift.TException;
import young.thrift.thriftTest.thrift.DataException;
import young.thrift.thriftTest.thrift.Person;
import young.thrift.thriftTest.thrift.PersonService;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got young.thrift.test_thrift.client Param:" + username );

        Person person = new Person();
        person.setUsername(username);
        person.setAge(33);
        person.setMarried(true);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got young.thrift.test_thrift.client Param: ");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
