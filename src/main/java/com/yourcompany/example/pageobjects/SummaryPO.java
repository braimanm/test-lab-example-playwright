package com.yourcompany.example.pageobjects;

import com.braimanm.pom.data.DataTypes;
import com.braimanm.pom.locator.Locate;
import com.braimanm.pom.pagecomponent.PageComponent;
import com.braimanm.pom.playwright.components.WebComponent;
import com.braimanm.pom.playwright.locators.By;
import com.braimanm.uitaf.playwright.support.PageObjectModel;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

@SuppressWarnings({"NewClassNamingConvention", "unused"})
public class SummaryPO extends PageObjectModel<Page> {
    //Vehicle Info related fields
    @Locate("//strong[.='Type of Vehicle:']/../span")
    private WebComponent vehicleType;
    @Locate("//strong[.='Make:']/../span")
    private WebComponent make;
    @Locate("//strong[.='Engine Performance [kW]:']/../span")
    private WebComponent enginePerformance;
    @Locate("//strong[.='Date of Manufacture:']/../span")
    private WebComponent manufacturerDate;
    @Locate("//strong[.='Number of Seats:']/../span")
    private WebComponent seats;
    @Locate("//strong[.='Fuel Type:']/../span")
    private WebComponent fuelType;
    @Locate("//strong[.='List Price [$]:']/../span")
    private WebComponent listPrice;
    @Locate("//strong[.='License Plate Number:']/../span")
    private WebComponent licensePlate;
    @Locate("//strong[.='Annual Mileage [mi]:']/../span")
    private WebComponent annualMileage;
    //Truck related fields
    @Locate("//strong[.='Payload [kg]:']/../span")
    private WebComponent payload;
    @Locate("//strong[.='Total Weight [kg]:']/../span")
    private WebComponent totalWeight;
    //Motorcycle related fields
    @Locate("//strong[.='Model:']/../span")
    private WebComponent model;
    @Locate("//strong[.='Cylinder Capacity [ccm]:']/../span")
    private WebComponent cylinderCapacity;

    //Client Info related fields
    @Locate(strategy = By.class, value = "//strong[.='First Name:']/../span")
    private WebComponent firstName;
    @Locate(strategy = By.class, value = "//strong[.='Last Name:']/../span")
    private WebComponent lastName;
    @Locate(strategy = By.class, value = "//strong[.='Date of Birth:']/../span")
    private WebComponent dateOfBirth;
    @Locate(strategy = By.class, value = "//strong[.='Gender:']/../span")
    private WebComponent gender;
    @Locate(strategy = By.class, value = "//strong[.='Street Address:']/../span")
    private WebComponent streetAddress;
    @Locate(strategy = By.class, value = "//strong[.='Country:']/../span")
    private WebComponent country;
    @Locate(strategy = By.class, value = "//strong[.='Zip Code:']/../span")
    private WebComponent zipCode;
    @Locate(strategy = By.class, value = "//strong[.='City:']/../span")
    private WebComponent city;
    @Locate(strategy = By.class, value = "//strong[.='Occupation:']/../span")
    private WebComponent occupation;
    @Locate(strategy = By.class, value = "//strong[.='Hobbies:']/../span")
    private WebComponent hobbies;
    @Locate(strategy = By.class, value = "//strong[.='Website:']/../span")
    private WebComponent website;
    @Locate(strategy = By.class, value = "//strong[.='Picture:']/../span")
    private WebComponent picture;


    @Step("Validate Summary Page")
    public void validate() {
        enumerateFields((pageComponent, field) -> {
            if (pageComponent.getData() != null && !pageComponent.getData().isEmpty()) {
                reportForValidation(field.getName(), pageComponent.getData());
                pageComponent.validateData(DataTypes.Data);
            } else {
                validateFieldIsNotDisplayed(field.getName(), (PageComponent<Locator>) pageComponent);
            }
        });
    }

    @Step("Validate that the \"{0}\" field has the value \"{1}\"")
    private void reportForValidation(String name, String value) {
        hideStepParams();
    }

    @Step("Validate that the \"{0}\" field is hidden")
    private void validateFieldIsNotDisplayed(String fieldName, PageComponent<Locator> component) {
        hideStepParams();

        Assertions.assertThat(component.getCoreLocator().isVisible())
                .withFailMessage("Field " + fieldName + " is displayed but should be hidden!").isFalse();
    }

}
