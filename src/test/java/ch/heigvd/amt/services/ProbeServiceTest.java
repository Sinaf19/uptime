package ch.heigvd.amt.services;


import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ProbeServiceTest {

    @Inject
    ProbeService probeService;

    @Test
    @TestTransaction
    void testProbeService() {
        var probeList = probeService.listProbes();
        assertEquals(0, probeList.size());

        var probe = probeService.getOrCreateProbe("https://www.example.com");
        assertNotNull(probe);

        probeList = probeService.listProbes();
        assertEquals(1, probeList.size());
    }



/*
    @Test
    void testComputeStatus() {
        Probe probe = new Probe("https://httpstat.us/200");
        probeService.createProbeIfNotExists(probe);

        Status status = probeService.computeStatus(probe);

        Assertions.assertTrue(status.isUp());
    }
*/
}
