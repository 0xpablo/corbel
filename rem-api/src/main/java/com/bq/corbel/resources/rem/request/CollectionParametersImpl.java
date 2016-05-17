package com.bq.corbel.resources.rem.request;

import java.util.List;
import java.util.Optional;

import com.bq.corbel.lib.queries.jaxrs.QueryParameters;
import com.bq.corbel.lib.queries.request.Aggregation;
import com.bq.corbel.lib.queries.request.Pagination;
import com.bq.corbel.lib.queries.request.ResourceQuery;
import com.bq.corbel.lib.queries.request.Search;
import com.bq.corbel.lib.queries.request.Sort;

/**
 * @author Alexander De Leon
 *
 */
public class CollectionParametersImpl extends QueryParameters implements CollectionParameters {

    public CollectionParametersImpl(Pagination pagination, Optional<Sort> sort, Optional<List<ResourceQuery>> queries,
            Optional<List<ResourceQuery>> conditions, Optional<Aggregation> aggreagation, Optional<Search> search) {
        super(pagination, sort, queries, conditions, aggreagation, search);
    }

    public CollectionParametersImpl(QueryParameters queryParameters) {
        super(queryParameters);
    }

}
