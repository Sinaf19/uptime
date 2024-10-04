package ch.heigvd.amt;


import ch.heigvd.amt.probe.ProbeService;
import ch.heigvd.amt.probe.entity.Probe;
import ch.heigvd.amt.status.Status;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ProbeServiceTest {

    @Inject
    ProbeService probeService;

    @Test
    void testCreationProbe() {
        Probe probe = new Probe("http://www.example.com");
        probeService.createProbeIfNotExists(probe);

        Probe probe1 = new Probe("http://www.example.com");
        probeService.createProbeIfNotExists(probe1);

        Assertions.assertEquals(1, probeService.listProbes().size());
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
