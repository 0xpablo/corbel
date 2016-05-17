package com.bq.corbel.resources.rem.request;

import java.util.List;
import java.util.Optional;

import com.bq.corbel.lib.queries.request.Aggregation;
import com.bq.corbel.lib.queries.request.Pagination;
import com.bq.corbel.lib.queries.request.ResourceQuery;
import com.bq.corbel.lib.queries.request.Search;
import com.bq.corbel.lib.queries.request.Sort;

/**
 * @author Alexander De Leon
 * 
 */
public interface CollectionParameters {

    Pagination getPagination();

    @Deprecated
    Optional<ResourceQuery> getQuery();

    Optional<List<ResourceQuery>> getQueries();

    Optional<List<ResourceQuery>> getConditions();

    Optional<Search> getSearch();

    Optional<Sort> getSort();

    Optional<Aggregation> getAggregation();

    void setPagination(Pagination pagination);

    @Deprecated
    void setQuery(Optional<ResourceQuery> query);

    void setQueries(Optional<List<ResourceQuery>> queries);

    void setConditions(Optional<List<ResourceQuery>> conditions);

    void setSearch(Optional<Search> search);

    void setSort(Optional<Sort> sort);

    void setAggregation(Optional<Aggregation> aggregation);

}
