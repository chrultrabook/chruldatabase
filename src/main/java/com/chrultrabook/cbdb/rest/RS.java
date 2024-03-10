package com.chrultrabook.cbdb.rest;

import com.chrultrabook.cbdb.entity.DeviceEntity;
import com.chrultrabook.cbdb.entity.GenerationEntity;
import com.chrultrabook.cbdb.rest.bean.Generation;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("v1")
public class RS {

    @Inject
    EntityMapper em;

    @GET
    @Produces("application/json")
    @Path("everything")
    public List<Generation> getAll() {
        return em.getEverything();
    }

    @GET
    @Produces("application/json")
    @Path("generation/{shortName}")
    public Response getGeneration(@PathParam("shortName") String shortName) {
        Optional<GenerationEntity> gen = GenerationEntity.find("shortName", shortName).firstResultOptional();
        if (gen.isPresent()) {
            return Response.ok(em.getAndMapGenerationWithDevices(gen.get())).build();
        }
        return Response.status(404, "Generation data not found").build();
    }

    @GET
    @Produces("application/json")
    @Path("device/{boardName}")
    public Response getDevice(@PathParam("boardName") String boardName) {
        Optional<DeviceEntity> device = DeviceEntity.find("boardName", boardName).firstResultOptional();
        if (device.isPresent()) {
            return Response.ok(em.getAndMapDevice(device.get())).build();
        }
        return Response.status(404, "Device data not found").build();
    }

}
