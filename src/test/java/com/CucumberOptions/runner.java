package com.CucumberOptions;/*import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import cucumber.api.SnippetType;

*//*@RunWith(Cucumber.class)
@CucumberOptions(
        features="C:\\Users\\walid.sadiq\\Desktop\\CUCUMBER-APIKCLI\\src\\test\\resources\\hellocucumber",
        glue="C:\\Users\\walid.sadiq\\Desktop\\CUCUMBER-APIKCLI\\src\\test\\java\\hellocucumber\\helloCucumber.Stepdefs.java",
        plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml"}
)*//*
@RunWith(Cucumber.class)
@CucumberOptions(//monochrome = true,
        //tags = "@tags",
        features="src\\test\\resources\\hellocucumber",
        glue="C:\\Users\\walid.sadiq\\Desktop\\CUCUMBER-APIKCLI\\src\\test\\java\\helloCucumber",
        plugin = {"pretty", "json:target/Destination.json"})

public class runner { }*/


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/features", glue="com.StepsDefinitions", plugin = {"pretty", "json:target/Destination.json"})
public class runner {
}
