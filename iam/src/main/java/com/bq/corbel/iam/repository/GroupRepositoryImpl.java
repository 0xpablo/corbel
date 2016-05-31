package com.bq.corbel.iam.repository;

import com.bq.corbel.iam.model.Group;
import com.bq.corbel.lib.queries.mongo.builder.MongoQueryBuilder;
import com.bq.corbel.lib.queries.request.Pagination;
import com.bq.corbel.lib.queries.request.ResourceQuery;
import com.bq.corbel.lib.queries.request.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class GroupRepositoryImpl extends HasScopesRepositoryBase<Group, String> implements GroupRepositoryCustom {

    private static final String FIELD_DOMAIN = "domain";

    @Autowired
    public GroupRepositoryImpl(MongoOperations mongoOperations) {
        super(mongoOperations, Group.class);
    }

    @Override
    public List<Group> findByDomain(String domain, List<ResourceQuery> resourceQueries, Pagination pagination, Sort sort) {
        Query query = new MongoQueryBuilder().query(resourceQueries).pagination(pagination).sort(sort).build()
                .addCriteria(where(FIELD_DOMAIN).is(domain));
        return mongo.find(query, Group.class);
    }

    @Override
    public void deleteScopes(String... scopes) {
        removeScopes(scopes);
    }

    @Override
    public void insertGroup(Group group) {
        mongo.insert(group);
    }
}
