package ch.heigvd.amt.resources;


import ch.heigvd.amt.services.ProbeService;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;



@Path("/")
public class ProbeResource {

    @Inject
    Template indexPage;

    @Inject
    Template registerPage;

    @Inject
    Template probePage;

    @Inject
    ProbeService probeService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance index() {
        return indexPage.instance();
    }

    @GET
    @Path("/register")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance register() {
        return registerPage.instance();
    }

    @GET
    @Path("/probes")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance probes() {
        var probeList = probeService.listProbes();

        for (var probe : probeList) {
            System.out.println(probe.getUrl());
        }

        return probePage.data("probeList", probeList);
    }

    @POST
    @Path("/probes")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance registerProbe(@FormParam("url") String url) {
        var probe = probeService.getOrCreateProbe(url);
        return probePage.data("probeList", probeService.listProbes());
    }

}
