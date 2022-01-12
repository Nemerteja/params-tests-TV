package testes;

import org.junit.jupiter.api.Test;
import pages.StepsForGithubTest;

public class AllureGithubAnnotatedStepTest {

    StepsForGithubTest websteps = new StepsForGithubTest();

    @Test
    public void TestIssue() {
        websteps.openGithub();
        websteps.searchGithub("allure-starter");
        websteps.goToLinkGithub("qa-guru/allure-starter");
        websteps.IssueGithub();
    }
}
