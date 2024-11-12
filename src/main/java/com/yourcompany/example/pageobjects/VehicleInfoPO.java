package com.yourcompany.example.pageobjects;

import com.braimanm.datainstiller.data.Data;

import com.braimanm.pom.locator.Locate;
import com.braimanm.pom.playwright.components.SelectComponent;
import com.braimanm.pom.playwright.components.WebComponent;
import com.braimanm.uitaf.playwright.support.PageObjectModel;
import com.microsoft.playwright.Page;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.qameta.allure.Step;

@SuppressWarnings({"NewClassNamingConvention", "unused"})
@XStreamAlias("vehicle-info-page-object")
public class VehicleInfoPO extends PageObjectModel<Page> {
    @Locate("select#vehicleType")
    private SelectComponent vehicleType;
    @Locate("select#make")
    private SelectComponent make;
    @Locate("input#enginePerformance")
    private WebComponent enginePerformance;
    @Locate("input#dateOfManufacture")
    private WebComponent manufacturerDate;
    @Locate("input#numberOfSeats")
    private WebComponent seats;
    @Locate("select#fuelType")
    private SelectComponent fuelType;
    @Locate("input#listPrice")
    private WebComponent listPrice;
    @Locate("input#licensePlateNumber")
    private WebComponent licensePlate;
    @Locate("input#annualMileage")
    private WebComponent annualMileage;
    //Truck related fields
    @Locate("input#payload")
    private WebComponent payload;
    @Locate("input#totalWeight")
    private WebComponent totalWeight;
    //Motorcycle related fields
    @Locate("input#model")
    private WebComponent model;
    @Locate("input#cylinderCapacity")
    private WebComponent cylinderCapacity;
    @Data(skip = true)
    private WebComponent nextButton;

    @Step("Populate Vehicle Info form with provided data")
    public void populate() {
        autoFillPage();
    }

    @Step("Click Next Button")
    public void next() {
        nextButton.click();
    }

    //Generate report entry for each populated component
    @Override
    @Step("Populate field \"{0}\" with value \"{1}\"")
    protected void reportForAutoFill(String fieldName, String value) {
        super.reportForAutoFill(fieldName, value);
    }

}
