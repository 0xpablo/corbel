package com.bq.oss.corbel.iam.model;

import com.bq.oss.lib.mongo.IdGenerator;
import com.google.common.base.Joiner;

/**
 * @author Alexander De Leon
 * 
 */
public class IdentityIdGenerator implements IdGenerator<Identity> {

    @Override
    public String generateId(Identity entity) {
        return Joiner.on("::").join(entity.getDomain(), entity.getUserId(), entity.getOauthService());
    }

}
