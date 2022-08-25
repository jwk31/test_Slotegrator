package stepDefs;

import asserts.AssertClass;
import UI.pageObjects.IndexPage;
import UI.pageObjects.LoginPage;
import UI.pageObjects.PlayersListPage;

public class BaseUITest {

    public AssertClass assertClass = new AssertClass();
    LoginPage loginPage = new LoginPage();
    IndexPage indexPage = new IndexPage();
    PlayersListPage playersListPage = new PlayersListPage();
}
