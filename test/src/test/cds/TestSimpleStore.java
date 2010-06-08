package test.cds;

import java.io.File;

import krati.cds.impl.segment.SegmentFactory;
import krati.cds.impl.store.SimpleDataStore;
import krati.cds.store.DataStore;

/**
 * TestSimpleStore using MemorySegment.
 * 
 * @author jwu
 *
 */
public class TestSimpleStore extends EvalDataStore
{
    public TestSimpleStore()
    {
        super(TestSimpleStore.class.getName());
    }
    
    protected SegmentFactory getSegmentFactory()
    {
        return new krati.cds.impl.segment.MemorySegmentFactory();
    }
    
    @Override
    protected DataStore<byte[], byte[]> getDataStore(File storeDir) throws Exception
    {
        return new SimpleDataStore(storeDir,
                                   idCount,   /* capacity */
                                   10000,     /* entrySize */
                                   5,         /* maxEntries */
                                   segFileSizeMB,
                                   getSegmentFactory());
    }
    
    public void testSimpleStore() throws Exception
    {
        new TestSimpleStore().run(4, 1);
        System.out.println("done");
        cleanTestOutput();
    }
}
