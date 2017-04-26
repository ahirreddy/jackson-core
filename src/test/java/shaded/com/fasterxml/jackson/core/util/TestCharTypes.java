package shaded.com.fasterxml.jackson.core.util;

import shaded.com.fasterxml.jackson.core.io.CharTypes;

public class TestCharTypes
    extends shaded.com.fasterxml.jackson.test.BaseTest
{
    public void testQuoting()
    {
        StringBuilder sb = new StringBuilder();
        CharTypes.appendQuoted(sb, "\n");
        assertEquals("\\n", sb.toString());
        sb = new StringBuilder();
        CharTypes.appendQuoted(sb, "\u0000");
        assertEquals("\\u0000", sb.toString());
    }
}
