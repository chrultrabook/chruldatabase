package com.chrultrabook.cbdb.rest;

import com.chrultrabook.cbdb.entity.DeviceEntity;
import com.chrultrabook.cbdb.entity.DeviceGenerationEntity;
import com.chrultrabook.cbdb.rest.bean.DeviceGeneration;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/v1/public")
public class PublicRS {

    @GET
    @Produces("application/json")
    @Path("everything")
    public List<DeviceGeneration> getAll() {
        List<DeviceGenerationEntity> list = DeviceGenerationEntity.listAll();
        return list.stream().map(DeviceGenerationEntity::toRecord).toList();
    }

    @GET
    @Produces("application/json")
    @Path("generation/{shortName}")
    public Response getGeneration(@PathParam("shortName") String shortName) {
        Optional<DeviceGenerationEntity> gen = DeviceGenerationEntity.find("shortName", shortName).firstResultOptional();
        if (gen.isPresent()) {
            return Response.ok(gen.get().toRecord()).build();
        }
        return Response.status(404, "Generation data not found").build();
    }

    @GET
    @Produces("application/json")
    @Path("device/{boardName}")
    public Response getDevice(@PathParam("boardName") String boardName) {
        Optional<DeviceEntity> device = DeviceEntity.find("boardName", boardName).firstResultOptional();
        if (device.isPresent()) {
            return Response.ok(device.get().toRecord()).build();
        }
        return Response.status(404, "Device data not found").build();
    }

}
