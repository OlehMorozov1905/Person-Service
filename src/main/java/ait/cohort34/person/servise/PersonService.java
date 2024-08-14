package ait.cohort34.person.servise;

import ait.cohort34.person.dto.AddressDto;
import ait.cohort34.person.dto.CityPopulationDto;
import ait.cohort34.person.dto.PersonDto;

public interface PersonService {

    Boolean addPerson (PersonDto personDto);
    PersonDto findPersonById (Integer id);
    PersonDto[] findPersonByCity (String cityName);
    PersonDto[] findPersonBetweenAges (Integer minAge, Integer maxAge);
    PersonDto updatePersonName (Integer id, String name);
    PersonDto[] findPersonByName (String name);
    Iterable<CityPopulationDto> getCitiesPopulation ();
    PersonDto updatePersonAddress (Integer id, AddressDto addressDto);
    PersonDto removePerson (Integer id);
}
