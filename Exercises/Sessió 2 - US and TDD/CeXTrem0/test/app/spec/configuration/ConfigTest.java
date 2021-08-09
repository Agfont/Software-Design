package app.spec.configuration;

import app.Configuration; // connects to the System Being Tested

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;



@RunWith(ConcordionRunner.class)

public class ConfigTest {

public int getTestResult(int a, int b) {

Configuration conf = new Configuration();

return conf.addTwoIntegers(a,b);

}

}

