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
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import static io.qameta.allure.model.Parameter.Mode.*;

@SuppressWarnings({"NewClassNamingConvention", "unused"})
@XStreamAlias("vehicle-insurance-domain-object")
public class VehicleInsuranceBDD extends DomainObjectModel<Page> {
    private AliasedData appUrl;
    @InitPage
    private VehicleInfoPO vehicleInfoPO;
    @InitPage
    private ClientInfoPO clientInfoPO;
    @InitPage
    private SummaryPO summaryPO;

    private VehicleInsuranceBDD() {}

    public VehicleInsuranceBDD(PageContext context) {
        this.pageObjectContext = context;
    }

    @Step("{0} the user is on Vehicle Insurance page")
    public void is_on_vehicle_insurance_page(@Param(mode = HIDDEN) String gwt) {
        getContext().navigate(appUrl.getData());
    }

    @Step("{0} the user populates the vehicle insurance information page with provided data and clicks next button")
    public void populates_vehicle_insurance_information(@Param(mode = HIDDEN) String gwt) {
        vehicleInfoPO.populate();
        vehicleInfoPO.next();
    }

    @Step("{0} the user populates the client information with provided data and clicks submit button")
    public void populates_client_information_page(@Param(mode = HIDDEN) String gwt) {
        clientInfoPO.populate();
        clientInfoPO.submit();
    }

    @Step("{0} user validates that the summary page contains the expected fields and values")
    public void validates_summary_page_contains_expected_fields_and_values(@Param(mode = HIDDEN) String gwt) {
        hideStepParams();
        summaryPO.validate();
    }


}
