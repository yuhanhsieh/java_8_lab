package lab;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Run all Test")
@SelectPackages({"lab.stream"})
public class AllTest {
}
