package ch.heigvd.amt.services;


import ch.heigvd.amt.entities.Probe;
import ch.heigvd.amt.entities.Status;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

@ApplicationScoped
public class ProbeService {

    @Inject
    EntityManager em;

    @Transactional
    public List<Probe> listProbes() {
        return em.createQuery("SELECT p FROM Probe p", Probe.class).getResultList();
    }

    @Transactional
    public Probe getOrCreateProbe(String url) {
        List<Probe> probes = em.createQuery("SELECT p FROM Probe p WHERE p.url = :url", Probe.class)
                .setParameter("url", url)
                .getResultList();

        if (probes.isEmpty()) {
            Probe probe = new Probe(url);
            em.persist(probe);
            return probe;
        }
        return probes.get(0);
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
