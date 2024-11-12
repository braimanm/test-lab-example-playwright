package com.yourcompany.example.pageobjects;

import com.braimanm.datainstiller.data.Data;

import com.braimanm.pom.playwright.components.FileUploadComponent;
import com.braimanm.pom.playwright.components.SelectComponent;
import com.braimanm.pom.playwright.components.WebComponent;
import com.braimanm.uitaf.playwright.support.PageObjectModel;
import com.microsoft.playwright.Page;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.qameta.allure.Step;

@SuppressWarnings({"NewClassNamingConvention", "unused"})
@XStreamAlias("client-info-page-object")
public class ClientInfoPO extends PageObjectModel<Page> {
    private WebComponent firstName;
    private WebComponent lastName;
    private WebComponent dateOfBirth;
    private SelectComponent gender;
    private WebComponent streetAddress;
    private WebComponent country;
    private WebComponent zipCode;
    private WebComponent city;
    private WebComponent occupation;
    private WebComponent hobbies;
    private WebComponent website;
    private FileUploadComponent picture;
    @Data(skip = true)
    private WebComponent submitButton;

    @Step("Populate Client Info form with provided data")
    public void populate() {
        autoFillPage();
    }

    @Step("Click Submit Button")
    public void submit() {
        submitButton.click();
    }

    //Generate report entry for each populated component
    @Override
    @Step("Populate field \"{0}\" with value \"{1}\"")
    protected void reportForAutoFill(String fieldName, String value) {
        super.reportForAutoFill(fieldName, value);
    }

}
