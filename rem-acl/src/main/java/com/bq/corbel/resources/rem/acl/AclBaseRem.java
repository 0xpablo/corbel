package com.bq.corbel.resources.rem.acl;

import com.google.common.collect.Lists;
import com.bq.corbel.resources.rem.BaseRem;
import com.bq.corbel.resources.rem.Rem;
import com.bq.corbel.resources.rem.request.*;
import com.bq.corbel.resources.rem.service.AclResourcesService;
import com.bq.corbel.resources.rem.service.RemService;

import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;

import javax.ws.rs.core.Response;

/**
 * @author Rubén Carrasco
 */
abstract public class AclBaseRem extends BaseRem<InputStream> {

    public static final List<MediaType> JSON_MEDIATYPE = Collections.singletonList(MediaType.APPLICATION_JSON);

    protected final AclResourcesService aclResourcesService;
    protected List<Rem> remsToExclude;
    protected RemService remService;

    public AclBaseRem(AclResourcesService aclResourcesService, List<Rem> remsToExclude) {
        this.aclResourcesService = aclResourcesService;
        this.remsToExclude = remsToExclude;
    }

    public void setRemService(RemService remService) {
        this.remService = remService;
    }

    @Override
    public Response collection(String type, RequestParameters<CollectionParameters> parameters, URI uri, Optional<InputStream> entity) {
        return collection(type, parameters, uri, entity, Optional.empty());
    }

    @Override
    public Response resource(String type, ResourceId id, RequestParameters<ResourceParameters> parameters, Optional<InputStream> entity) {
        return resource(type, id, parameters, entity, Optional.empty());
    }

    @Override
    public Response relation(String type, ResourceId id, String relation, RequestParameters<RelationParameters> parameters,
                             Optional<InputStream> entity) {
        return relation(type, id, relation, parameters, entity, Optional.empty());
    }

    @Override
    public Class<InputStream> getType() {
        return InputStream.class;
    }

    protected List<Rem> getExcludedRems(Optional<List<Rem>> excludedRems) {
        List<Rem> excluded = Lists.newArrayList(this);
        if (remsToExclude != null) {
            excluded.addAll(remsToExclude);
        }
        excludedRems.ifPresent(excluded::addAll);
        return excluded;
    }

}
