package shaded.com.fasterxml.jackson.core;

import shaded.com.fasterxml.jackson.core.json.*;
import shaded.com.fasterxml.jackson.core.io.IOContext;
import shaded.com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import shaded.com.fasterxml.jackson.core.util.BufferRecycler;

/**
 * Tests to verify [JACKSON-278]
 */
public class TestVersions extends shaded.com.fasterxml.jackson.test.BaseTest
{
    public void testCoreVersions() throws Exception
    {
        assertVersion(new JsonFactory().version());
        ReaderBasedJsonParser jp = new ReaderBasedJsonParser(getIOContext(), 0, null, null,
                CharsToNameCanonicalizer.createRoot());
        assertVersion(jp.version());
        jp.close();
        JsonGenerator jgen = new WriterBasedJsonGenerator(getIOContext(), 0, null, null);
        assertVersion(jgen.version());
        jgen.close();
    }

    /*
    /**********************************************************
    /* Helper methods
    /**********************************************************
     */
    
    private void assertVersion(Version v)
    {
        assertEquals(PackageVersion.VERSION, v);
    }

    private IOContext getIOContext() {
        return new IOContext(new BufferRecycler(), null, false);
    }
}

