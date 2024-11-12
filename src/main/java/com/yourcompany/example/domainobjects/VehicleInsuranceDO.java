package com.yourcompany.example.domainobjects;

import com.braimanm.pom.pagecomponent.AliasedData;
import com.braimanm.pom.pagecomponent.InitPage;
import com.braimanm.pom.playwright.context.PageContext;
import com.braimanm.uitaf.playwright.support.DomainObjectModel;
import com.microsoft.playwright.Page;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourcompany.example.pageobjects.ClientInfoPO;
import com.yourcompany.example.pageobjects.SummaryPO;
import com.yourcompany.example.pageobjects.VehicleInfoPO;

@SuppressWarnings({"unused", "NewClassNamingConvention"})
@XStreamAlias("vehicle-insurance-domain-object")
public class VehicleInsuranceDO extends DomainObjectModel<Page> {
    private AliasedData appUrl;
    @InitPage
    private VehicleInfoPO vehicleInfoPO;
    @InitPage
    private ClientInfoPO clientInfoPO;
    @InitPage
    private SummaryPO summaryPO;

    private VehicleInsuranceDO() {}

    public VehicleInsuranceDO(PageContext context) {
        this.pageObjectContext = context;
    }

    private void navigate() {
        getContext().navigate(appUrl.getData());
    }

    public void createNewInsurancePolicy() {
        navigate();

        vehicleInfoPO.populate();
        vehicleInfoPO.next();

        clientInfoPO.populate();
        clientInfoPO.submit();
    }

    public void validateSummary() {
        summaryPO.validate();
    }
}
