package ait.cohort34.person.dao;

import ait.cohort34.person.dto.CityPopulationDto;
import ait.cohort34.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Stream<Person> findByAddressCityIgnoreCase(String cityName);

    Stream<Person> findByBirthDateBetween(LocalDate from, LocalDate to);

//    @Query("select p from Person p WHERE p.name=?1") для примера работы с нативними запросами к базе данных
    Stream<Person> findByNameIgnoreCase(String name);

    @Query("SELECT new ait.cohort34.person.dto.CityPopulationDto(p.address.city, count (p)) from Person p group by p.address.city order by count (p) desc ")
    List<CityPopulationDto> getCitiesPopulation();
}
