package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateRegistryResultValid() {
        Person person = new Person("ESTEBANQUITO",458576,43,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateRegistryResultInvalidAge(){
        Person person = new Person("CARMENZA",2372482,-2,Gender.FEMALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateRegistryResultDuplicate() {
        Person person01 = new Person("RUPERTA",87247274,20,Gender.FEMALE,true);
        Person person02 = new Person("JAJAJAJAMES",87247274,74,Gender.MALE,true);

        RegisterResult result01 = registry.registerVoter(person01);
        RegisterResult result02 = registry.registerVoter(person02);

        Assert.assertEquals(RegisterResult.VALID, result01);
        Assert.assertEquals(RegisterResult.DUPLICATED, result02);
    }

    @Test
    public void validateRegistryResultUnderAge() {
        Person person = new Person("YESID",2424525,11,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
	
	@Test
    public void validateRegistryResultDead() {
        Person person = new Person("NAPOLEON",4578347,51,Gender.MALE,false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }
}