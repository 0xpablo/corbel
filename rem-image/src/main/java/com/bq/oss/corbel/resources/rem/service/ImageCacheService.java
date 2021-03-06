package com.bq.oss.corbel.resources.rem.service;

import java.io.File;
import java.io.InputStream;

import com.bq.oss.corbel.resources.rem.Rem;
import com.bq.oss.corbel.resources.rem.request.RequestParameters;
import com.bq.oss.corbel.resources.rem.request.ResourceId;
import com.bq.oss.corbel.resources.rem.request.ResourceParameters;

public interface ImageCacheService {

    InputStream getFromCache(Rem<?> restorRem, ResourceId resourceId, Integer width, Integer height, String type,
            RequestParameters<ResourceParameters> parameters);

    void saveInCacheAsync(Rem<InputStream> restorPutRem, ResourceId resourceId, Integer width, Integer height, Long newSize,
            String collection, RequestParameters<ResourceParameters> parameters, File file);

}
