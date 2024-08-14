package ait.cohort34.person.controller;

import ait.cohort34.person.dto.AddressDto;
import ait.cohort34.person.dto.CityPopulationDto;
import ait.cohort34.person.dto.PersonDto;
import ait.cohort34.person.servise.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    final PersonService personService;

    @PostMapping
    public Boolean addPerson(@RequestBody PersonDto personDto) {
        return personService.addPerson(personDto);
    }

    @GetMapping("/{id}")
    public PersonDto findPerson(@PathVariable Integer id) {
        return personService.findPersonById(id);
    }

    @GetMapping("/city/{cityName}")
    public PersonDto[] findByCity(@PathVariable String cityName) {
        return personService.findPersonByCity(cityName);
    }

    @GetMapping("/ages/{minAge}/{maxAge}")
    public PersonDto[] findByAges(@PathVariable Integer minAge, @PathVariable Integer maxAge) {
        return personService.findPersonBetweenAges(minAge, maxAge);
    }

    @PutMapping("/{id}/name/{name}")
    public PersonDto updatePersonName(@PathVariable Integer id, @PathVariable String name) {
        return personService.updatePersonName(id, name);
    }

    @GetMapping("/name/{name}")
    public PersonDto[] findPersonByName(@PathVariable String name) {
        return personService.findPersonByName(name);
    }

    @GetMapping("/population/city")
    public Iterable<CityPopulationDto> getCityPopulation() {
        return personService.getCitiesPopulation();
    }

    @PutMapping("/{id}/address")
    public PersonDto updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        return personService.updatePersonAddress(id, addressDto);
    }

    @DeleteMapping("/{id}")
    public PersonDto removePerson(@PathVariable Integer id) {
        return personService.removePerson(id);
    }
}
