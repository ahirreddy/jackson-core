package shaded.com.fasterxml.jackson.core.util;

import shaded.com.fasterxml.jackson.core.Version;
import shaded.com.fasterxml.jackson.core.json.PackageVersion;
import shaded.com.fasterxml.jackson.core.json.UTF8JsonGenerator;

public class TestVersionUtil extends shaded.com.fasterxml.jackson.test.BaseTest
{
    public void testVersionPartParsing()
    {
        assertEquals(13, VersionUtil.parseVersionPart("13"));
        assertEquals(27, VersionUtil.parseVersionPart("27.8"));
        assertEquals(0, VersionUtil.parseVersionPart("-3"));
    }

    public void testVersionParsing()
    {
        assertEquals(new Version(1, 2, 15, "foo", "group", "artifact"),
                VersionUtil.parseVersion("1.2.15-foo", "group", "artifact"));
    }

    public void testMavenVersionParsing() {
        assertEquals(new Version(1, 2, 3, "SNAPSHOT", "foo.bar", "foo-bar"),
                VersionUtil.mavenVersionFor(TestVersionUtil.class.getClassLoader(), "foo.bar", "foo-bar"));
    }

    public void testPackageVersionMatches() {
        assertEquals(PackageVersion.VERSION, VersionUtil.versionFor(UTF8JsonGenerator.class));
    }
}
