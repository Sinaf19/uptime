package ch.heigvd.amt.probe;


import ch.heigvd.amt.probe.entity.Probe;
import ch.heigvd.amt.status.Status;
import jakarta.validation.Valid;

import java.util.List;

public class ProbeService {

    public List<Probe> listProbes() {
        return null;
    }

    public Probe createProbeIfNotExists(@Valid Probe newProbe) {
        return null;
    }

    public Status getLastStatus(String url) {
        return null;
    }

    public List<Status> getStatusList(String url, int count) {
        return null;
    }

    public Status executeProbe(Probe probe) {
        return null;
    }

    public Status computeStatus(Probe probe) {
        return null;
    }

}
